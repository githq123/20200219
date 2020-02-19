package com.example.admin.myasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    ProgressBar pg;
    Button btnRead,btnImg;
    TextView tvshow;
    ImageView imgview;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg=findViewById(R.id.pg);
        btnRead=findViewById(R.id.btnRead);
        btnImg=findViewById(R.id.btnImg);
        tvshow=findViewById(R.id.tvshow);
        imgview=findViewById(R.id.imgview);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview.setImageBitmap(null);
                readURL("http://www.jxust.edu.cn");
            }
        });
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr="http://pic.sc.chinaz.com/files/pic/pic9/201808/zzpic13306.jpg";
                readIMG(addr);
            }


        });
            }
    private void readIMG(String addr) {
        new AsyncTask<String,Void,Bitmap>(){
            @Override
            protected Bitmap doInBackground(String... strings) {
                try{
                    URL url=new URL(strings[0]);
                   URLConnection conn=url.openConnection();
                    InputStream is=conn.getInputStream();
                    bitmap=BitmapFactory.decodeStream(is);
                    return bitmap;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return  null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imgview.setImageBitmap(bitmap);
            }

            @Override
            protected void onCancelled(Bitmap bitmap) {
                super.onCancelled(bitmap);
            }
        }.execute(addr);
    }
    private void readURL(String s) {
        new AsyncTask<String,Integer,String>(){

            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url=new URL(strings[0]);
                    URLConnection conn=url.openConnection();
                    InputStream is=conn.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader br=new BufferedReader(isr);
                    String line;
                    StringBuilder sb=new StringBuilder();
                    int i=0;
                    while ((line=br.readLine())!=null){
                        i++;
                        sb.append(line);
                        onProgressUpdate(i);
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
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                pg.setProgress(values[0]);
                System.out.println("values="+values[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                tvshow.setText(s);
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }
        }.execute(s);
    }

}

