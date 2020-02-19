package com.example.admin.xmlrw;

import java.io.Serializable;

public class Person implements Serializable{
    String name,pwd;
    Person(String name,String pwd){
        this.name=name;
        this.pwd=pwd;

    }
    public String getName(){
        return name;

    }
    public String getPwd(){
        return pwd;
    }

    public void setName(String name){
        this.name=name;

    }
    public void setPwd(String pwd){
        this.pwd=pwd;
    }

}
