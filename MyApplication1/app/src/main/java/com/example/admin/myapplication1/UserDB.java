package com.example.admin.myapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class UserDB  extends AppCompatActivity {
  UserDB userDB;
  EditText etName,etPwd;
  Button btnAdd;
  SQLiteDatabase dbWrite,DbRead;
  @Override
    protected  void onCrate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentview(R.layout.my_layout);
      etName=findViewById(R.id.etName);
      etPwd=findViewById(R.id.etPwd);
      btnAdd=findViewById(R.id.btnAdd);
      SQLiteDatabase dbWrite=userDB.getWritableDatabase();
      btnAdd.setOnClickListener(this);

  }
}
