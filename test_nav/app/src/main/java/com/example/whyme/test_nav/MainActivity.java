package com.example.whyme.test_nav;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnClick,btnBack,btnSlide,btnTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick=findViewById(R.id.btnClick);
        btnSlide=findViewById(R.id.btnSlide);
        btnTab=findViewById(R.id.btnTab);
        btnClick.setOnClickListener(this);
        btnSlide.setOnClickListener(this);
        btnTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClick:
                NewFragment newFragment=new NewFragment();
                FragmentManager manager=getSupportFragmentManager(); //初始化
                FragmentTransaction trans=manager.beginTransaction();
                trans.replace(R.id.right_layout,newFragment);
                trans.addToBackStack(null);//不会直接退出程序
                trans.commit();
                break;
            case R.id.btnSlide:
                startActivity(new Intent(MainActivity.this,SlideActivity.class));
                break;
            case R.id.btnTab:
                startActivity(new Intent(MainActivity.this,Tabbed2Activity.class));
                break;
        }
    }
}

