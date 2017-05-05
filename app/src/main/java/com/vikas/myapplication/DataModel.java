package com.vikas.myapplication;


public class DataModel {


    String name;
    String version;
    //String email;
    int id_;
    int image;

    public DataModel(String name, String version ,int id_, int image) {
        this.name = name;
        this.version = version;
        //this.email= email;
        this.id_ = id_;
        this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getVersion() {
        return version;
    }
/*
    public String getEmail() {
        return email;
    }*/

    public int getImage() {
        return image;
    }


    public int getId() {
        return id_;
    }
}