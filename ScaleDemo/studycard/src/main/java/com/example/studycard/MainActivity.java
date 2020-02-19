package com.example.studycard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imgA,imgB;
ScaleAnimation sat0=new ScaleAnimation(1,0,1,1,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
    ScaleAnimation sat1=new ScaleAnimation(0,1,1,1,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgA.getVisibility()==View.VISIBLE){
                    imgA.setAnimation(sat0);
                }else {
                    imgB.startAnimation(sat0);
                }
            }
        });
    }

    private void init() {
        imgA=findViewById(R.id.imgA);
        imgB=findViewById(R.id.imgB);
        showImgA();
        sat0.setDuration(500);
        sat1.setDuration(500);
        sat0.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(imgA.getVisibility()==View.VISIBLE){
                    imgA.setAnimation(null);
                    showImgB();
                    imgB.startAnimation(sat1);
                }else {
                    imgB.setAnimation(null);
                    showImgA();
                    imgA.startAnimation(sat1);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }



    private void showImgA() {
        imgA.setVisibility(View.VISIBLE);
        imgB.setVisibility(View.INVISIBLE);
    }
    private void showImgB() {
        imgA.setVisibility(View.INVISIBLE);
        imgB.setVisibility(View.VISIBLE);
    }
}
