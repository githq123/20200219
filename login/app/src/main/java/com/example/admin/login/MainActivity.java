package com.example.admin.login;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPwd;
    Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    private void init()

    {
        etName = findViewById(R.id.etName);
        etPwd = findViewById(R.id.etPwd);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);



    }

    public void onClick (View view){
        switch (view.getId()) {
            case R.id.btnLogin:
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("name", etName.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnRegister:
                Intent intent1=new Intent(MainActivity.this,registerActivity.class);
                startActivityForResult(intent1,0);

        }
    }
protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        etName.setText(data.getStringExtra("name"));
        etPwd.setText(data.getStringExtra("pwd"));
}


}