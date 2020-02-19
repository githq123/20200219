package com.example.admin.myapplication1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LanHong on 2017/10/24.
 */

public class DB extends SQLiteOpenHelper {
    public DB(Context context) {
        super(context, "db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT DEFAULT \"\"," +
                "sex TEXT DEFAULT \"\" )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "db");
        onCreate(db);
    }
}

