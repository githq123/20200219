package com.example.admin.t1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int v1= Integer.parseInt(intent.getStringExtra("a"));
        int v2= Integer.parseInt(intent.getStringExtra("b"));
        int v=v1+v2;
        tv= findViewById(R.id.tv);
        tv.setText("结果为:"+v);
    }
}
/*public class SecondActivity extends Activity{
    private TextView myTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        Intent intent = getIntent();
        int v1=（int） intent.getStringExtra("a");
        int v2= （int）intent.getStringExtra("b");
        int v=v1+v2;
        tv= (TextView) findViewById(R.id.tv);
        tv.setText(“结果为：”+v);
    }
}
*/