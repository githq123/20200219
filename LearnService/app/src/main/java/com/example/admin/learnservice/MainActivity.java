package com.example.admin.learnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    Button start,stop,bind,unbind,sync;
    Intent intent;
    EditText text;
    TextView show;
    MyService.MyBinder binder=null;
    Message message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        text=findViewById(R.id.text);
        bind=findViewById(R.id.bind);
        unbind=findViewById(R.id.unbind);
        sync=findViewById(R.id.sync);
        show=findViewById(R.id.show);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
        sync.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                intent=new Intent(MainActivity.this,MyService.class);
                intent.putExtra("data",text.getText().toString());
                startService(intent);
                break;
            case R.id.stop:
                stopService(intent);
                break;
            case R.id.bind:
                intent=new Intent(MainActivity.this,MyService.class);
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(this);
                binder=null;
                break;
            case R.id.sync:
                if(binder!=null){
                    binder.setData(text.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("onServiceConnected");
        binder= (MyService.MyBinder) service;
        binder.getservice().setCallback(new MyService.callback() {
            @Override
            public void onDataChanged(String data) {
                message=new Message();
                Bundle bundle=new Bundle();
                bundle.putString("data",data);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            show.setText(message.getData().getString("data"));
        }
    };
}

