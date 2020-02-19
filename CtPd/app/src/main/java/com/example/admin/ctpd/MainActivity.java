package com.example.admin.ctpd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//MyDB db;
//SQLiteDatabase dbwrite,dbread;
Button btnwrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //db=new MyDB(this);
        //dbwrite=db.getWritableDatabase();
        //dbread=db.getReadableDatabase();
        btnwrite=findViewById(R.id.btnwrite);
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values=new ContentValues();
                values.put("name","peter");
                getContentResolver().insert(MyContentProvider.URI,values);
                /*write();
                Toast.makeText(MainActivity.this,"插入完成",Toast.LENGTH_SHORT).show();
                Cursor c=dbread.query("user",new String[]{"_id","name"},null,null,50,)
           int count=c.getCount();
                System.out.println("count="+count);
                while (c.moveToNext()){
                    System.out.println("id="+c.getInt(0)+",name="+c.getString(1));
                }
                c.close();*/
            }
          /*  private void write() {
                ContentValues values=new ContentValues();
                values.put("name","peter");
                dbwrite.insert("user",null,values);
                dbwrite.execSQL("insert into user(name) values('xiaozhang')");
            }*/
        });
        findViewById(R.id.btnread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor c=getContentResolver().query(MyContentProvider.URI,new String[]{"_id","name"},null,null,null);
               // int count=c.getCount();
                while (c.moveToNext()){
                    System.out.println("_id="+c.getInt(0)+",name="+c.getString(1));
                }
                c.close();
            }
        });
        findViewById(R.id.btndelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
getContentResolver().delete(MyContentProvider.URI,new String("_id > ?"),new String[]{"7"});
            }
        });
    }


}
