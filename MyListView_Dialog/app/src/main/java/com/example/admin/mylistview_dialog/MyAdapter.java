package com.example.admin.mylistview_dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Person> list;
    MyAdapter(Context context,List<Person> list){
        this.context=context;
        this.list=list;
    }

    //删，增，改
    void remove(int i){
        list.remove(i);
        notifyDataSetChanged();
    }
    void add(Person p){
        list.add(p);
        notifyDataSetChanged();
    }
    void update(int i,Person p){
        list.set(i,p);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Person getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.item_list,null);
        ImageView iv=v.findViewById(R.id.iv);
        TextView tvName=v.findViewById(R.id.tvName);

        iv.setImageResource(getItem(position).getId());
        tvName.setText(getItem(position).getName());

        return v;
    }
}
