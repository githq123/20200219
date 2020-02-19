package com.example.admin.mylistview_dialog;
//
//import android.content.Intent;
//import android.media.Image;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//
//import java.io.Serializable;
//
//public class AddActivity extends AppCompatActivity {
//    EditText etName,etDesc;
//    Button btnOk,btnCancel;
//    ImageView imageId;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add);
//
//        etName=(EditText)findViewById(R.id.etName);
//        etDesc=(EditText)findViewById(R.id.etDesc);
//        btnOk=(Button)findViewById(R.id.btnOk);
//        btnCancel=(Button)findViewById(R.id.btnCancel);
//        imageId=(ImageView)findViewById(R.id.imageA);
//
//
//
//
//
//        btnOkOnclickListener();
//
//
//
//
//    }
//    private void btnOkOnclickListener(){
//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Person p2;
//
//                imageId.setImageResource(R.drawable.e);
//                int id=R.drawable.b;
//                String name=etName.getText().toString();
//                String desc=etDesc.getText().toString();
//
//                p2=new Person(R.drawable.c,name,desc);
//                Intent intent1=new Intent(AddActivity.this,MainActivity.class);
//                intent1.putExtra("person", (Serializable) p2);
//                setResult(2,intent1);
//                finish();
//
//            }
//        });
//
//    }
//}
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.Serializable;

public class AddActivity extends AppCompatActivity {

    EditText etName,etDesc;
    Button btnOk,btnCancel;
    ImageView imageAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName=findViewById(R.id.etName);
        etDesc=findViewById(R.id.etDesc);
        btnOk=findViewById(R.id.btnOk);
        btnCancel=findViewById(R.id.btnCancel);
        imageAdd=findViewById(R.id.imageA);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Person p2;
                String name=etName.getText().toString();
                String desc=etDesc.getText().toString();
                p2=new Person(R.drawable.qingzhao,name,desc);
                Intent intentAdd=new Intent(AddActivity.this,MainActivity.class);
                intentAdd.putExtra("person", p2);
                setResult(200,intentAdd);
                finish();

            }
        });


    }
}
