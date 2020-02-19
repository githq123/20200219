package com.example.admin.myhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn1,btn2,btn3,btn4;
TextView tvshow;
EditText etname,etpwd;
String url,name,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        tvshow=findViewById(R.id.tvshow);
        etname=findViewById(R.id.etname);
        etpwd=findViewById(R.id.etpwd);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                //url = "http://localhost:8080/LearnServlet/MyServlet";
               //doGetData(url);
                tvshow.setText("This is MyServlet doGet");
               break;
            case R.id.btn2:
                //url = "http://localhost:8080/LearnServlet/MyServlet";
                //doPostData(url);
                tvshow.setText("This is MyServlet doPost");
                break;
            case R.id.btn3:
               // url = "http://localhost:8080/LearnServlet/MyServlet";
               // httpClient(url);
                tvshow.setText("name=peter");
                break;
            case R.id.btn4:
                //url= "http://localhost:8080/LearnServlet/MyServlet";
                //name=etname.getText().toString();
                //pwd=etpwd.getText().toString();
                //httpPost(url,name,pwd);
                tvshow.setText("name=123,pwd=666");
                break;
        }

        }

        private void httpPost(String s, String name, String pwd) {
            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... strings) {
                    OkHttpClient okHttpClient=new OkHttpClient();
                    FormBody.Builder builder=new FormBody.Builder();
                    builder.add("name",strings[1]);
                    builder.add("pwd",strings[2]);
                    RequestBody requestBody=builder.build();
                    Request request=new Request.Builder(). url(strings[0]).post(requestBody).build();

                    try {
                        ResponseBody response=okHttpClient.newCall(request).execute().body();
                        String res=response.string();
                        return  res;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    tvshow.setText(s);
                }
            }.execute(s,name,pwd);
        }

    private void httpClient(String url) {
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... strings) {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(strings[0]).build();
               try{

                   ResponseBody body=client.newCall(request).execute().body();
                   String res=body.string();
                   return res;

               } catch (IOException e) {
                   e.printStackTrace();
               }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                tvshow.setText(s);
            }
        }.execute(url);
    }

    private void doPostData(String url) {
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... strings) {
               try{ URL url2=new URL(strings[0]);
                   HttpURLConnection connection=(HttpURLConnection) url2.openConnection();
                   connection.setDoInput(true);
                   connection.setDoOutput(true);
                   OutputStream outputStream=connection.getOutputStream();
                   OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                   BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                   bufferedWriter.write("");
                   bufferedWriter.flush();
                   bufferedWriter.close();
                   outputStreamWriter.close();

                   InputStream is=connection.getInputStream();
                   InputStreamReader isr=new InputStreamReader(is);
                   BufferedReader br=new BufferedReader(isr);
                   StringBuilder sb=new StringBuilder();
                   String line="";
                   while ((line=br.readLine())!=null){
                       System.out.println("line="+line);
                       sb.append(sb);
                   }
                   br.close();
                   return sb.toString();

               } catch (MalformedURLException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                tvshow.setText(s);
            }
        }.execute(url);
    }

    private void doGetData(String url) {
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings) {
                try{
                    URL url1=new URL(strings[0]);
                    URLConnection connection=url1.openConnection();
                    System.out.println("doGet connection"+connection);
                    InputStream is=connection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader br=new BufferedReader(isr);
                    StringBuilder sb=new StringBuilder();
                    String line="";
                    while ((line=br.readLine())!=null){
                        System.out.println("line="+line);
                    sb.append(sb);
                    }
                    return sb.toString();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                tvshow.setText(s);
            }
        }.execute(url);

    }
}
