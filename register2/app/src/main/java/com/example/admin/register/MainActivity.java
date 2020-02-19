package com.example.admin.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import  android.widget.CheckBox;
import  android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText etName, etPwd;
    TextView tvResult;
    Button btnLogin;
    RadioGroup rg;
    RadioButton rbMale, rbFemale;
    CheckBox chk1, chk2, chk3;
    Spinner spinner;
    String localcity = "";
    String sex = "";
    String hobby = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etPwd = (EditText) findViewById(R.id.etPwd);
        rg = (RadioGroup) findViewById(R.id.rg);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        spinner = (Spinner) findViewById(R.id.spinner);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hobby+=chk1.getText().toString()+"、";
                }

            }
        });

        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hobby+=chk2.getText().toString()+"、";
                }

            }
        });

        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hobby+=chk3.getText().toString()+"、";
                }

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                localcity=(String)spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbMale){
                    sex="男生";}
                else{
                    sex="女生";
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String res="用户名：" + etName.getText().toString()+"\n" + "密码：" + etPwd.getText().toString()+"\n"+
                        "性别是："+sex+"\n"+"爱好是："+hobby+"\n"+"城市是："+localcity;
                tvResult.setText(res);

            }
        });
    }
}
