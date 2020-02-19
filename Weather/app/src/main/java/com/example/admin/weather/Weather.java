package com.example.admin.weather;

import android.icu.util.RangeValueIterator;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Weather extends AppCompatActivity {
TextView tv1,tv2,car,line,dress,sick,option,pollution;
ImageView iv;
LinearLayout layout01;
Elements elements,elements1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();
        String url="http://www.weather.com.cn/weather/101240701.shtml";
        new AsyncTask<String,Void,Boolean>(){
            @Override
            protected Boolean doInBackground(String... strings) {

                try {
                    String url0=strings[0];
                    Document document =Jsoup.connect(url0).get();
                    elements=document.getElementsByTag("P");
                    elements1=document.getElementsByTag("span");
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                tv1.setText(elements.get(3).text());
                tv2.setText(elements.get(4).text());
                car.setText(elements.get(38).text());
                dress.setText(elements.get(37).text());
                line.setText(elements.get(34).text());
                sick.setText(elements.get(35).text());
                pollution.setText(elements.get(36).text());
                option.setText(elements.get(39).text());

                String str=elements.get(3).text();

                String str1=elements1.get(38).text();
                String str2=elements1.get(37).text();
                String str3=elements1.get(34).text();
                String str4=elements1.get(35).text();
                String str5=elements1.get(36).text();
                String str6=elements1.get(39).text();
                if (str.equals("晴")){
               iv.setImageDrawable(getResources().getDrawable(R.drawable.sun));
               layout01.setBackgroundResource(R.drawable.sun1);
                }
                if (str.equals("多云")){
                    iv.setImageDrawable(getResources().getDrawable(R.drawable.cloud));
                    layout01.setBackgroundResource(R.drawable.cloud1);
                }
                if(str1.equals("较适宜")){
                    car.setText(str1);
                }
                if(str1.equals("舒适")){
                    dress.setText(str2);
                }
                if(str1.equals("弱")){
                    line.setText(str3);
                }
                if(str1.equals("不易波动")){
                    pollution.setText(str5);
                }
                if(str1.equals("中")){
                    option.setText(str6);
                }

            }
        }.execute(url);
    }

    private void init() {
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        pollution=findViewById(R.id.pollution);
        sick=findViewById(R.id.sick);
        line=findViewById(R.id.line);
        car=findViewById(R.id.car);
        dress=findViewById(R.id.dress);
        option=findViewById(R.id.option);
        iv=findViewById(R.id.iv);
        layout01=findViewById(R.id.layout01);
    }
}
