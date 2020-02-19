package com.example.admin.readwritefile;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText text;
    TextView getText;
    Button writeIn,readIn,writeOut,readOut,sfw,sfr;
    String infile_name="myfile.txt";
    File sd_path= Environment.getExternalStorageDirectory();
    File outfile_name=new File(sd_path,"test.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        text=findViewById(R.id.text);
        writeIn=findViewById(R.id.btn1);
        readIn=findViewById(R.id.btn2);
        writeOut=findViewById(R.id.btn3);
        readOut=findViewById(R.id.btn4);
        sfw=findViewById(R.id.btn5);
        sfr=findViewById(R.id.btn6);
        getText=findViewById(R.id.getText);
        writeIn.setOnClickListener(this);
        readIn.setOnClickListener(this);
        writeOut.setOnClickListener(this);
        readOut.setOnClickListener(this);
        sfw.setOnClickListener(this);
        sfr.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                writeIn();
                break;
            case R.id.btn2:
                readIn();
                break;
            case R.id.btn3:
                writeOut();
                break;
            case R.id.btn4:
                readOut();
                break;
            case R.id.btn5:
                sharePW();
                break;
            case R.id.btn6:
                sharePR();
                break;
        }
    }

    private void sharePR() {
        SharedPreferences sharedPreferences=getSharedPreferences("test",MODE_PRIVATE);
        String name=sharedPreferences.getString("name","default");
        String password=sharedPreferences.getString("password","111111");
        String data=sharedPreferences.getString("测试","default");
        getText.setText("测试数据为:"+data);
    }

    private void sharePW() {
        SharedPreferences sharedPreferences=getSharedPreferences("test",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name","张三");
        editor.putString("password","123456");
        editor.putString("测试",text.getText().toString());
        editor.commit();
        text.setText("");
    }

    private void readOut() {
        if(!sd_path.exists()){
            return;
        }
        try {
            FileInputStream getout=new FileInputStream(outfile_name);
            InputStreamReader isr=new InputStreamReader(getout,"UTF-8");
            char[] input=new char[getout.available()];
            isr.read(input);
            String s=new String(input);
            getText.setText(s);
            getout.close();
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeOut() {
        FileOutputStream fos;
        try {
            fos=new FileOutputStream(outfile_name);
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            osw.write(text.getText().toString());
            osw.flush();
            osw.close();
            fos.close();
            text.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readIn() {
        FileInputStream get;
        try {
            get=openFileInput(infile_name);
            try {
                byte[] in=new byte[get.available()];
                get.read(in);
                String str=new String(in);
                getText.setText(str);
                get.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeIn() {
        FileOutputStream fos;
        try {
            fos=openFileOutput(infile_name,MODE_PRIVATE);
            String s=text.getText().toString();
            fos.write(s.getBytes());
            fos.flush();
            fos.close();
            text.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

