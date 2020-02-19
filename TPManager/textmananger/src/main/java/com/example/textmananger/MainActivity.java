package com.example.textmananger;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button btn;
    SmsManager smsMananger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btn=findViewById(R.id.btn);
        smsMananger = SmsManager.getDefault();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,new Intent(),0);
                smsMananger.sendTextMessage(et1.getText().toString(),null,et2.getText().toString(),pendingIntent,null);
                Toast.makeText(MainActivity.this,"发送成功",Toast.LENGTH_SHORT).show();;

            }
        });
    }
}
