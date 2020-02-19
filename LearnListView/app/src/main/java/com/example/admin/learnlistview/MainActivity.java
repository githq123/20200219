package com.example.admin.learnlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
//import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String[] names=new String[]{"小王","小李","小赵","小张"};
    String[] descs=new String[]{"学习委员","生活委员","体育委员","文娱委员"};
    int[] images=new int[]{R.drawable.c,R.drawable.d,R.drawable.c,R.drawable.d};
    List<Map<String,Object>> list;
    ListView listView;
    //ArrayAdapter adapter;
    //SimpleAdapter sAdapter;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        list=new ArrayList<Map<String,Object>>();
        Map<String,Object> p;
        for(int i=0;i<names.length;i++){
            p=new HashMap<String, Object>();
            p.put("image",images[i]);
            p.put("name",names[i]);
            p.put("desc",descs[i]);
            list.add(p);
        }

        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);
        //sAdapter=new SimpleAdapter(MainActivity.this, list,R.layout.item_list,
       // new String[]{"image","name","desc"},
         //       new int[]{R.id.iv,R.id.tvName,R.id.tvDesc});
        //listView.setAdapter(sAdapter);


        //adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,names);
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,names[position]+"被短按",Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,names[position]+"被长按...",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public HashMap getItem(int position) {
            return (HashMap)list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1=View.inflate(MainActivity.this,R.layout.item_list,null);
            ImageView imageView=view1.findViewById(R.id.iv);
            final TextView tvName=view1.findViewById(R.id.tvName);
            final TextView tvDesc=view1.findViewById(R.id.tvDesc);
            Button btn=view1.findViewById(R.id.btn);
            HashMap p=(HashMap)list.get(position);
            imageView.setImageResource((Integer) p.get("image"));
            tvName.setText((CharSequence) p.get("name"));
            tvDesc.setText((CharSequence) p.get("desc"));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s=tvName.getText().toString()+"是"+tvDesc.getText().toString();
                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                }
            });
            return view1;
        }
    }

}
