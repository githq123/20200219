package com.example.admin.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    boolean running=false;
    String str="abc";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }

    class MyBinder extends Binder{
        public void setData(String data){
            MyService.this.str=data;
        }
        public MyService getservice(){
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                super.run();
                running=true;
                int i=0;
                while (running) {
                    i++;
                    str=i+":"+str;
                    System.out.println(str);
                    if(callback!=null){
                        callback.onDataChanged(str);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        str=intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("myservice onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("myservice onDestory()");
    }

    callback callback=null;

    public MyService.callback getCallback() {
        return callback;
    }

    public void setCallback(MyService.callback callback) {
        this.callback = callback;
    }

    public static interface callback{
        void onDataChanged(String data);
    }
}
