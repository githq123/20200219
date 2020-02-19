package com.example.drawable;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv1=findViewById(R.id.iv1);
        iv1.setBackgroundResource(R.drawable.my_anim);
        AnimationDrawable ad= (AnimationDrawable) iv1.getBackground();
        ad.start();

    }
}
