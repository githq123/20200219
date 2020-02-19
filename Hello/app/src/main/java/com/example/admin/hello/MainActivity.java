package com.example.admin.hello;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Hello extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void thisButtonLogin(View view){
        //接收按钮按下事件

        //获取用户输入的账号和密码
        EditText editText = (EditText)findViewById(R.id.userEdit);
        String user = editText.getText().toString();
        editText = (EditText)findViewById(R.id.passwordEdit);
        String pw = editText.getText().toString();

        //这一段是测试的遗留的，用来在判断前输出输入的账号内容
        //AlertDialog.Builder message = new AlertDialog.Builder(this);
        //message.setMessage(user);
        //message.setPositiveButton("确定",click1);
        //AlertDialog message1 = message.create();
        //message1.show();

        //判断两个编辑框内容是否为空
        if (user == null || user.length() == 0) {
            AlertDialog.Builder usermessage=new AlertDialog.Builder(this);
            usermessage.setMessage("用户名不能为空！");
            usermessage.setPositiveButton("确定",click1);
            AlertDialog usermessage1=usermessage.create();
            usermessage1.show();
        }else if(pw == null || pw.length() == 0) {
            AlertDialog.Builder pwmessage=new AlertDialog.Builder(this);
            pwmessage.setMessage("密码不能为空！");
            pwmessage.setPositiveButton("确定",click1);
            AlertDialog pwmessage1=pwmessage.create();
            pwmessage1.show();
        }else{
            //弹出信息框，显示用户输入的账号和密码
            AlertDialog.Builder winmessage = new AlertDialog.Builder(this);
            winmessage.setMessage("账号:"+user+"\n"+"密码:"+pw);
            winmessage.setPositiveButton("确定",click2);
            AlertDialog winmessage2 = winmessage.create();
            winmessage2.show();
        }
    }
    private DialogInterface.OnClickListener click1 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    };
    private DialogInterface.OnClickListener click2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };
}