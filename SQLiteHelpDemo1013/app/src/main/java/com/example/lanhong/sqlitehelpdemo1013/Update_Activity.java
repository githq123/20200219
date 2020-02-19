package com.example.lanhong.sqlitehelpdemo1013;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update_Activity extends AppCompatActivity {
    EditText etNameUp,etPwdUp;
    Button btnOkUp,btnCancelUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etNameUp=findViewById(R.id.etNameUp);
        etPwdUp=findViewById(R.id.etPwdUp);
        btnOkUp=findViewById(R.id.btnOkUp);
        btnCancelUp=findViewById(R.id.btnCancelUp);

        Intent intentUp=getIntent();
        etNameUp.setText(intentUp.getStringExtra("name"));
        etPwdUp.setText(intentUp.getStringExtra("password"));

        btnOkUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnCancelUp:
                        break;
                    case R.id.btnOkUp:
                        String name=etNameUp.getText().toString();
                        String password=etPwdUp.getText().toString();
                        Intent intent1=new Intent(Update_Activity.this,MainActivity.class);
                        intent1.putExtra("name", name);
                        intent1.putExtra("password",password);
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
