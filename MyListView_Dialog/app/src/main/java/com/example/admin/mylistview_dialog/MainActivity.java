package com.example.admin.mylistview_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] names;
    String[] desc;
    ListView listView;
    List<Person> list;
    com.example.admin.mylistview_dialog.MyAdapter myAdapter;
    private static final int ACTION_DETAIL=0;
    private static final int ACTION_ADD=1;
    private static final int ACTION_REMOVE=2;
    private static final int ACTION_UPDATE=3;
    Person newPerson;
    int mPosition;
    int [] imageID=new int[]{R.drawable.libai,R.drawable.qingzhao,R.drawable.nongyu,R.drawable.lzc,R.drawable.myc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        desc = getResources().getStringArray(R.array.person_details);
        names = getResources().getStringArray(R.array.person_name);
        list = new ArrayList<Person>();
        Person p;

        for (int i = 0; i < names.length; i++) {
            p = new Person(imageID[i], names[i], desc[i]);
            list.add(p);
        }

        myAdapter = new MyAdapter(MainActivity.this, list);
        listView.setAdapter(myAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, names[i] + "被短按", Toast.LENGTH_SHORT).show();
                ;
            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择");
                AlertDialog.Builder builder1 = builder.setItems(new String[]{"查看详情", "添加数据", "删除数据", "修改数据"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case ACTION_DETAIL:
                                        showDetails(i);
                                        break;
                                    case ACTION_ADD:
                                        Intent intent = new Intent(MainActivity.this, AddActivity.class);
                                        startActivityForResult(intent, 0);
//                                        Person p=new Person(R.drawable.image,"新人","做测试");
//                                        myAdapter.add(newPerson);
                                        break;
                                    case ACTION_REMOVE:
                                        myAdapter.remove(i);
                                        break;
                                    case ACTION_UPDATE:
                                        Intent intentup = new Intent(MainActivity.this, UpdateActivity.class);
                                        intentup.putExtra("person",  list.get(i));
                                        mPosition=i;
                                        startActivityForResult(intentup,ACTION_UPDATE);
                                        break;
                                }
                            }

                            private void showDetails(int i) {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                                builder1.setTitle(list.get(i).getName())
                                        .setMessage(list.get(i).getDesc())
                                        .setPositiveButton("返回", null);
                                AlertDialog dialog1 = builder1.create();
                                dialog1.show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;

            }
        });


    }

    protected void onActivityResult(int requestCode, final int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 200:
                newPerson=(Person)data.getSerializableExtra("person");
                myAdapter.add(newPerson);
                break;
            case 300:
                newPerson=(Person)data.getSerializableExtra("person");
                myAdapter.update(mPosition,newPerson);
        }
    }
}