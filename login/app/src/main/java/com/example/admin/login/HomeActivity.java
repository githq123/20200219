package com.example.admin.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
Button calculator;
TextView tvShow1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i=getIntent();
        String str=i.getStringExtra("name");
        TextView tvShow=findViewById(R.id.tvShow);
        tvShow.setText("Welcome "+str+" to my page.");
        init();
        calculator.setOnClickListener(this);

    }
private void init() {
        calculator=findViewById(R.id.calculator);
        tvShow1=findViewById(R.id.tvShow1);
    }
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.calculator:
                        Intent intent2 = new Intent(HomeActivity.this, caculatorActivity.class);
                        startActivity(intent2);
                        break;

                }
                finish();
            }
}

