package com.example.admin.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText in1,in2;
    TextView tvResult;
    Button add,minus,multiply,divide,equal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in1=findViewById(R.id.in1);
        in2=findViewById(R.id.in2);
        tvResult=findViewById(R.id.tvResult);
        add=findViewById(R.id.add);
        minus=findViewById(R.id.minus);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double a = Double.parseDouble(in1.getText().toString());
                Double b = Double.parseDouble(in2.getText().toString());
                Double c=a+b;
                String res= in1.getText().toString() +"+"+in2.getText().toString()+"="+c;
                tvResult.setText(res);

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double a = Double.parseDouble(in1.getText().toString());
                Double b = Double.parseDouble(in2.getText().toString());
                Double c=a-b;
                String res= in1.getText().toString() +"-"+in2.getText().toString()+"="+c;
                tvResult.setText(res);

            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double a = Double.parseDouble(in1.getText().toString());
                Double b = Double.parseDouble(in2.getText().toString());
                Double c=a*b;
                String res= in1.getText().toString() +"*"+in2.getText().toString()+"="+c;
                tvResult.setText(res);

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double a = Double.parseDouble(in1.getText().toString());
                Double b = Double.parseDouble(in2.getText().toString());
                Double c=a/b;
                String res= in1.getText().toString() +"/"+in2.getText().toString()+"="+c;
                tvResult.setText(res);

            }
        });

    }
}
