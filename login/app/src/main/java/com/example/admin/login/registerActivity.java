package com.example.admin.login;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;
import  android.widget.CheckBox;
import  android.widget.Spinner;

public class registerActivity extends AppCompatActivity {
    EditText etName,etPwd;
    Button btnRegister;
    RadioGroup rg;
    Spinner spinner;
    CheckBox chk1,chk2,chk3;
    String tip,city,hobbies="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        spinnerListener();
        checkBoxListener();
        radioGroupListener();
        buttonListener();
    }
    private void buttonListener() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerActivity.this,MainActivity.class);
                intent.putExtra("name",etName.getText().toString());
                intent.putExtra("pwd",etPwd.getText().toString());
                setResult(1,intent);
                finish();
            }
        });
    }

    private void radioGroupListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                tip=checkedId== R.id.rbMale? "性别是男人":"性别是女人";

            }
        });
    }

    private void checkBoxListener() {
        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    hobbies+=chk1.getText().toString()+" , ";
            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    hobbies+=chk2.getText().toString()+" , ";
            }
        });
        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    hobbies+=chk3.getText().toString()+" . ";
            }
        });
    }

    private void spinnerListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city= (String) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {
        etName= (EditText) findViewById(R.id.etName);
        etPwd= (EditText) findViewById(R.id.etPwd);
        rg= (RadioGroup) findViewById(R.id.rg);
        spinner= (Spinner) findViewById(R.id.spinner);
        chk1= (CheckBox) findViewById(R.id.chk1);
        chk2= (CheckBox) findViewById(R.id.chk2);
        chk3= (CheckBox) findViewById(R.id.chk3);
        btnRegister= (Button) findViewById(R.id.btnRegister);

    }
}