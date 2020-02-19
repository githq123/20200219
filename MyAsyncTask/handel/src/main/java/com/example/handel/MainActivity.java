package com.example.handel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class MainActivity extends AppCompatActivity {
 EditText et;
 ImageView iv;
 Bitmap bitmap;
 String path;
  Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bitmap0 = (Bitmap) msg.obj;
            iv.setImageBitmap(bitmap0);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
        iv=findViewById(R.id.iv);
        path=et.getText().toString().trim();
     findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    URL url=null;
                    try{
                         url=new URL(path);
                        URLConnection conn=url.openConnection();
                        InputStream is=conn.getInputStream();
                        bitmap=BitmapFactory.decodeStream(is);
                        Message msg=new Message();
                        msg.obj=bitmap;
                        handler.sendMessage(msg);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

         }
     });
   }
}