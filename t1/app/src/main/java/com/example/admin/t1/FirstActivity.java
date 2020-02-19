package com.example.admin.t1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    Button btn;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btn =findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                String a=et1.getText().toString();
                String b=et2.getText().toString();
                intent.putExtra("a",a);
                intent.putExtra("b",b);
                intent.setClass(FirstActivity.this, SecondActivity.class);
                FirstActivity.this.startActivity(intent);
            }
        });
    }
}

/*public class FirstActivity extends Activity {
    Button btn;
    EditText et1,et2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1=findViewById（R.id.et1）;
        et2=findViewById（R.id.et2）;
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                string a=et1.getText.toString（）;
                string b=et2.getText.toString（）;
                intent.putExtra("a", a);
                intent.putExtra（''b'',b）;
                intent.setClass(FirstActivity.this, SecondActivity.class);
                FirstActivity.this.startActivity(intent);
            }
        });
    }
}
*/