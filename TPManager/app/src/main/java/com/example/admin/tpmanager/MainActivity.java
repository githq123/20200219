package com.example.admin.tpmanager;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<String> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        listData=new ArrayList<String>();
        TelephonyManager telephonyManager=getSystemService(Context.TELEPHONY_SERVICE);
   listData.add(telephonyManager.getSimCountryIso());
   listData.add(telephonyManager.getNetworkType()+"");
   listData.add(telephonyManager.getNetworkOperator());
   if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE)
           ){
       System.out.println("perssion designed");
    }else{
        listData.add(telephonyManager.getDeviceSoftwareVersion());
    }
    listView.setAdapter(new ArrayList<String>)
}
