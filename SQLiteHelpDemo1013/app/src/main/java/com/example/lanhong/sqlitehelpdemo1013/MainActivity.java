package com.example.lanhong.sqlitehelpdemo1013;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd;
    EditText etName,etPwd;
    MyDB userDB;
    TextView tvName;
    ListView listView;
    SQLiteDatabase dbWrite,dbRead;
    SimpleCursorAdapter adapter;
    List<Map<String,Object>> list;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        userDB=new MyDB(this);

        dbWrite=userDB.getWritableDatabase();
        dbRead=userDB.getReadableDatabase();

        list=new ArrayList<Map<String,Object>>();
        adapter=new SimpleCursorAdapter(MainActivity.this,
                R.layout.item_list,
                null,
                new String[]{"name","password"},
                new int[]{R.id.tvname,R.id.tvpwd} //item_list
        );
        listView.setAdapter(adapter);
        refreshListView();
        btnAdd.setOnClickListener(this);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final android.app.AlertDialog.Builder builder =
                        new android.app.AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择");
                android.app.AlertDialog.Builder builder1 = builder.setItems(new String[]{"删除数据", "修改数据"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0:
                                        Cursor c1=adapter.getCursor();
                                        c1.moveToPosition(position);
                                        int itemid=c1.getInt(c1.getColumnIndex("_id"));
                                        dbWrite.delete("user","_id=?",new String[]{itemid+""});
                                        refreshListView();
                                        break;

                                    case 1:
                                        Cursor c2=adapter.getCursor();
                                        c2.moveToPosition(position);
                                        index=c2.getInt(c2.getColumnIndex("_id"));
                                        String name=c2.getString(c2.getColumnIndex("name"));
                                        String password=c2.getString(c2.getColumnIndex("password"));
                                        Intent intentup = new Intent(MainActivity.this, Update_Activity.class);
                                        intentup.putExtra("name", name);
                                        intentup.putExtra("password",password);
                                        startActivityForResult(intentup,1);


                                        //dbWrite.delete("user","name=?",new String[]{name+""});
                                        //refreshListView();

                                        break;
                                }
                            }

                        });
                android.app.AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });

    }

    private void refreshListView() {
        Cursor c=dbRead.query("user",null,null,null,null,null,null
        );
        adapter.changeCursor(c);
    }

    private void init() {
        btnAdd=findViewById(R.id.btnAdd);
        etName=findViewById(R.id.etName);
        etPwd=findViewById(R.id.etPwd);
        listView=findViewById(R.id.listView);
        tvName=findViewById(R.id.tvName);
        //etDelName=findViewById(R.id.etDelName);
        //btnDel=findViewById(R.id.btnDel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                addDB(dbWrite);
                break;

        }
    }

//    private void delDB() {
//        String name=etDelName.getText().toString();
//        dbWrite.delete("user","name=?",new String[]{name});
//        refreshListView();
//        Toast.makeText(MainActivity.this,"Delete data is ok",Toast.LENGTH_SHORT).show();
//
//    }

    private void addDB(SQLiteDatabase db) {
        ContentValues values=new ContentValues();
        values.put("name",etName.getText().toString());
        values.put("password",etPwd.getText().toString());
        db.insert("user",null,values);

//        values=new ContentValues();
//        values.put("name","zxy");
//        values.put("password","123");
//        db.insert("user",null,values);
        refreshListView();
//        db.close();
        etName.setText("");
        etPwd.setText("");
        Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();

    }

    protected void onActivityResult(int requestCode, final int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 300:
                String name=data.getStringExtra("name");
                String password=data.getStringExtra("password");
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("password", password);
                dbWrite.update("user", values, "_id=" +index , null);
                refreshListView();
                break;
        }
    }
}
