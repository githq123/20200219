package com.example.admin.myweather;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ViewPagerAdapter vpAdapter;
    ViewPager vp;
    List<View> views;
    ImageView[] dots;
    Button btnstart;
    int[] ids=new int[]{R.id.iv1,R.id.iv2,R.id.iv3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initdots();
        vp.addOnPageChangeListener(this);
        btnstart=views.get(2).findViewById(R.id.btnstart);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GuideActivity.this,Home.class);
                startActivity(i);
            }
        });
    }

    private void initdots() {
        dots=new ImageView[views.size()];
        for (int i=0;i<views.size();i++){
            dots[i]=findViewById(ids[i]);

        }

    }

    private void initView() {
        vp=findViewById(R.id.vp);
        LayoutInflater inflater=LayoutInflater.from(this);
        views=new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one,null));
        views.add(inflater.inflate(R.layout.two,null));
        views.add(inflater.inflate(R.layout.three,null));
        vpAdapter=new ViewPagerAdapter(views,this);
        vp.setAdapter(vpAdapter);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        for (int k=0;k<ids.length;k++) {
            if (k == i)
            {
                dots[k].setImageResource(R.drawable.login_point_selected);
            }
            else{
                dots[k].setImageResource(R.drawable.login_point);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
