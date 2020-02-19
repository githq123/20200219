package com.example.app2;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static final Uri URI=Uri.parse("content://cp1");
    ListView listView;
   ArrayList<String> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        listData= new ArrayList<String>();
        findViewById(R.id.btnreadcp).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Cursor c=getContentResolver().query(URI,new String[]{"_id","name"},null,null,null);
           // int count=c.getCount();
            String result="";
            while (c.moveToNext()){
               // System.out.println("id="+c.getInt(0)+",name="+c.getString(1));
            result=c.getInt(0)+" "+c.getString(1);
            listData.add(result);


            }
           c.close();

            listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listData));
            for(int i=0;i<listData.size();i++){
                System.out.println(listData.get(i));
           }

        }
    });

    }
}
