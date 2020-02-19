package com.example.admin.myweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends AppCompatActivity {
    WebView wv;
   /* GridView gv;
    /*ImageSwitcher is;
    String html;*/
    /*int[] imageIds=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*gv=findViewById(R.id.gv);
        is=findViewById(R.id.is);*/
        wv=findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebChromeClient (new WebChromeClient()); //处理JavaScript对话框//处理各种通知和请求事件，如果不使用该句代码，将使用内置浏览器访问网页。
        wv. setWebViewClient (new WebViewClient());//设置默认显示的天气预报信息
        wv.loadUrl("http://m.weather.com.cn/mweather/101010100.shtml");
        wv. setInitialScale (57*4);//将网页内容放大4倍
        /*List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();XX
        for (int i=0;i<imageIds.length;i++) {
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("image",imageIds[i]);
            listItems.add(item);

        }
        /*is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv=new ImageView(Home.this);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                return iv;
            }
        });*/

        /*SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,
                R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        gv.setAdapter(simpleAdapter);
        /*gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                is.setImageResource(imageIds[position]);
            }
        });
        gv.setOnItemSelectedListener();*/
    }







}

