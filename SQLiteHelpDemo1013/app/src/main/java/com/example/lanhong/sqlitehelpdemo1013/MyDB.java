package com.example.lanhong.sqlitehelpdemo1013;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {
    public MyDB(Context context) {
        super(context, "testdb", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(_id Integer primary key autoincrement," +
                "name text default \'\', password text default \'\')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if  EXISTS"+" user");
        onCreate(db);
    }
}

