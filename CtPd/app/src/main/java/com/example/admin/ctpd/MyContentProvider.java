package com.example.admin.ctpd;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public static final Uri URI=Uri.parse("content://cp1");
    MyDB db;
    SQLiteDatabase database;
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        //throw new UnsupportedOperationException("Not yet implemented");
    database.delete("user",selection,selectionArgs);
        return  0;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
       // throw new UnsupportedOperationException("Not yet implemented");
    return  null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        //throw new UnsupportedOperationException("Not yet implemented");
        database.insert("user",null,values);
        return  null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
         db = new MyDB(getContext());
        database=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name","peters");
        database.insert("user",null,values);
        database.execSQL("insert into user(name) values ('xiangxin')");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
       // throw new UnsupportedOperationException("Not yet implemented");
        Cursor c=database.query("user",projection,selection,selectionArgs,null,null,sortOrder);
    return  c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
      //  throw new UnsupportedOperationException("Not yet implemented");
    return 0;
    }
}
