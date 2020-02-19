package com.example.admin.mylistview_dialog;

import java.io.Serializable;

public class Person implements Serializable{
    int id;
    String name,desc;
    Person(int id,String name,String desc){
        this.id=id;
        this.name=name;
        this.desc=desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}
