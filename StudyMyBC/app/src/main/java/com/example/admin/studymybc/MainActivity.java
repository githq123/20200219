package com.example.admin.studymybc;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
MyReceiver myReceiver=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnsend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(MainActivity.this,MyReceiver.class);
                Intent intent=new Intent("com.example.admin.studymybc.action.MyReceiver");
                intent.putExtra("data","abc");
                sendBroadcast(intent);
            }
        });
        findViewById(R.id.btnrgs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myReceiver==null){
                    myReceiver=new MyReceiver();
                    registerReceiver(myReceiver,new IntentFilter("com.example.admin.studymybc.action.MyReceiver"));
                }
            }
        });

        findViewById(R.id.btnurgs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myReceiver!=null){
                    unregisterReceiver(myReceiver);
                    myReceiver=null;
                }
            }
        });
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("aaaaa");
                startActivity(intent);
            }
        });
    }
}
