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
//public class UpdateActivity extends AppCompatActivity {
//    EditText etName0,etDesc0;
//    Button btnOk0,btnCancel0;
//    ImageView imageId0;
//    Person oldperson;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_update);
//
//        etName0=(EditText)findViewById(R.id.etName0);
//        etDesc0=(EditText)findViewById(R.id.etDesc0);
//        btnOk0=(Button)findViewById(R.id.btnOk0);
//        btnCancel0=(Button)findViewById(R.id.btnCancel0);
//        imageId0=(ImageView)findViewById(R.id.imageB);
//        Intent intent0=getIntent();
//        oldperson=(Person)intent0.getSerializableExtra("person");
//        etName0.setText(oldperson.getName());
//        etDesc0.setText(oldperson.getDesc());
//
//        //btnOk0.setOnClickListener();
//
//
//
//
//
//
//        btnOkOnclickListener(this);
//
//
//
//
//    }
//    private void btnOkOnclickListener(UpdateActivity updateActivity){
//        btnOk0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//    }
//}
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.Serializable;

public class UpdateActivity extends AppCompatActivity {

    EditText etNameUp,etDescUp;
    Button btnOkUp,btnCancelUp;
    ImageView imageUp;
    Person oldPerson;
    int photoID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etNameUp=findViewById(R.id.etNameUp);
        etDescUp=findViewById(R.id.etDescUp);
        btnOkUp=findViewById(R.id.btnOkUp);
        btnCancelUp=findViewById(R.id.btnCancelUp);
        imageUp=findViewById(R.id.imageUp);

        Intent intentUp=getIntent();
        oldPerson= (Person) intentUp.getSerializableExtra("person");
        etNameUp.setText(oldPerson.getName());
        etDescUp.setText(oldPerson.getDesc());
        photoID=oldPerson.getId();
        imageUp.setImageResource(photoID);


        btnOkUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnCancelUp:
                        break;
                    case R.id.btnOkUp:
                        Person p2;
                        String name=etNameUp.getText().toString();
                        String desc=etDescUp.getText().toString();
                        p2=new Person(photoID,name,desc);//p2=new Person(R.drawable.libai,name,desc);
                        Intent intent1=new Intent(UpdateActivity.this,MainActivity.class);
                        intent1.putExtra("person",  p2);
                        setResult(300,intent1);
                        finish();
                        break;
                }

            }
        });

        btnCancelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }
}

