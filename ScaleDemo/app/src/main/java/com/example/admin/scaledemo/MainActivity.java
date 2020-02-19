package com.example.admin.scaledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView iv;
Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        iv=findViewById(R.id.iv);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Animation ani1=AnimationUtils.loadAnimation(this,R.anim.alpha);
                iv.startAnimation(ani1);
                break;
            case R.id.btn2:
                Animation ani2=AnimationUtils.loadAnimation(this,R.anim.scale);
                iv.startAnimation(ani2);
                break;
            case R.id.btn3:
                Animation ani3=AnimationUtils.loadAnimation(this,R.anim.translate);
                iv.startAnimation(ani3);
                break;
            case R.id.btn4:
                Animation ani4=AnimationUtils.loadAnimation(this,R.anim.rotate);
                iv.startAnimation(ani4);
                break;
            case R.id.btn5:
                Animation ani5=AnimationUtils.loadAnimation(this,R.anim.animset);
                iv.startAnimation(ani5);
                break;
        }
    }
}
