package com.example.admin.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends AppCompatActivity {
GridView gv;
ImageSwitcher is;
int[] imageIds=new int[]{R.drawable.cat0,R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5,R.drawable.cat6,R.drawable.cat7,R.drawable.cat8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gv=findViewById(R.id.gv);
        is=findViewById(R.id.is);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for (int i=0;i<imageIds.length;i++) {
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("image",imageIds[i]);
            listItems.add(item);

        }
       is.setFactory(new ViewSwitcher.ViewFactory() {
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
       });

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,
                R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
               gv.setAdapter(simpleAdapter);
               gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       is.setImageResource(imageIds[position]);
                   }
               });
               /*gv.setOnItemSelectedListener();*/
}
}
