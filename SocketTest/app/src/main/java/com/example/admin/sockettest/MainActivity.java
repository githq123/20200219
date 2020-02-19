package com.example.admin.sockettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1;
Button btnScoket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScoket=findViewById(R.id.btnSocket);
        btnScoket.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        new Thread() {
            @Override
            public void run() {
                String[] mess = {"JAVA: 1+1在什么情况下不等于2", "JAVA: 狗为什不生跳蚤", "JAVA: 什么东西能看、能吃、能坐"};
                Socket socket;
                DataInputStream in = null;
                DataOutputStream out = null;
                try {
                    socket = new Socket("192.168.43.74", 2200);
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    for (int i = 0; i < mess.length; i++) {
                        out.writeUTF(mess[i]);
                        String str = in.readUTF();
                        System.out.println("recieve from server" + str);
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
    }
}
