package com.example.admin.ctpd;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {
    public MyDB(Context context) {
        super(context,"db1.db3",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(_id integer primary key autoincrement,name varchar(50))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
