package com.example.admin.xmlrw;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,pwd;
    Button btn,read,readRes,readJson;
    TextView show;
    Person p;
    List<Person> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        show = findViewById(R.id.show);
        pwd = findViewById(R.id.pwd);
        btn = findViewById(R.id.btn);
        read = findViewById(R.id.read);
        readRes = findViewById(R.id.readRes);
        readRes.setOnClickListener(new View.OnClickListener() {
            StringBuilder sb = new StringBuilder("");
            Resources res = getResources();
            XmlResourceParser xrp = res.getXml(R.xml.myxml);

            @Override
            public void onClick(View v) {
                int counter = 0;
                try {
                    // 判断是否到了文件的结尾
                    while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                        //文件的内容的起始标签开始，注意这里的起始标签是test.xml文件里面<resources>标签下面的第一个标签
                        if (xrp.getEventType() == XmlResourceParser.START_TAG) {
                            String tagname = xrp.getName();
                            if (tagname.endsWith("person")) {
                                counter++;
                                sb.append("这是第" + counter + "条记录" + "\n");
                                sb.append("年龄：" + xrp.getAttributeValue(0) + "\n");
                                sb.append("身高：" + xrp.getAttributeValue(1) + "\n");
                                sb.append("姓名：" + xrp.getAttributeValue(2) + "\n");
                            }
                        }
                        xrp.next();
                    }
                    show.setText(sb.toString());
                } catch (XmlPullParserException e) {
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readJson = findViewById(R.id.readJson);
        btn.setOnClickListener(this);
        read.setOnClickListener(this);
        //readRes.setOnClickListener(this);
        //readJson.setOnClickListener(this);
        readJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="";
                try {
                    InputStreamReader isr = new InputStreamReader(getAssets().open("test_json.json"), "UTF-8");
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    StringBuilder bulider = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        bulider.append(line);
                    }
                    JSONObject root = null;
                    try {
                        root = new JSONObject(bulider.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("cat = "+root.getString("cat"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONArray array= null;
                    try {
                        array = root.getJSONArray("languages");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for (int i=0;i<array.length(); i++) {
                        try {
                            JSONObject lan = array.getJSONObject(i);
                            msg+="\n"+"--------";
                            msg+="\n"+"id="+lan.getInt("id");
                            msg+="\n"+"ide="+lan.get("ide");
                            msg+="\n"+"name="+lan.get("name");
                            show.setText(msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                createXml();
                break;
            case R.id.read:
                readXml();
                break;
            case R.id.readRes:
                readResource();
                break;
            case R.id.readJson:
                readJSON();
                break;
        }
    }

    private void readResource() {
        //XmlPullParser parser=getResources();
    }

    private void readJSON(){

    }
    private void readXml() {
        try {
            FileInputStream fi_in=openFileInput("person.xml");
            XmlPullParser pullParser=Xml.newPullParser();
            pullParser.setInput(fi_in,"UTF-8");
            int event=pullParser.getEventType();
            while (event!=XmlPullParser.END_DOCUMENT){
                switch (event){
                    case XmlPullParser.START_DOCUMENT:
                        list=new ArrayList<Person>();//链表初始化
                        break;
                    case XmlPullParser.START_TAG:
                        if ("name".equals(pullParser.getName())){
                            event=pullParser.next();
                            String name=pullParser.getText();
                            p=new Person("","");
                            p.setName(name);
                        }
                        if("password".equals(pullParser.getName())){//无需再next
                            String password=pullParser.nextText();//使用nextText获取到值
                            p.setPwd(password);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("person".equals(pullParser.getName())){
                            list.add(p);
                            p=null;
                        }
                        break;
                }
                event=pullParser.next();//循环的下一步移动
            }
            for (int i=0;i<list.size();i++){
                String n=list.get(i).getName();
                String  p=list.get(i).getPwd();
                show.setText("用户名:"+n+" \n密码:"+p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createXml() {
        XmlSerializer serializer = Xml.newSerializer();
        p = new Person(name.getText().toString(), pwd.getText().toString());
        try {
            FileOutputStream fi_out = openFileOutput("person.xml", MODE_PRIVATE);
            serializer.setOutput(fi_out, "UTF-8");
            serializer.startDocument("UTF-8", true);
            serializer.startTag(null, "persons");
            serializer.startTag(null, "person");

            serializer.startTag(null, "name");
            serializer.text(p.getName());
            serializer.endTag(null, "name");

            serializer.startTag(null, "password");
            serializer.text(p.getPwd());
            serializer.endTag(null, "password");

            serializer.endTag(null, "person");
            serializer.endTag(null, "persons");
            serializer.endDocument();
            serializer.flush();
            fi_out.close();
            Toast.makeText(MainActivity.this, "写入成功!", Toast.LENGTH_SHORT).show();
            name.setText("");
            pwd.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}