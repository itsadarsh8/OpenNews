package com.example.opennewsapp;

public class NewsData {

    private String mTitle;
    private String mDescription;

    public NewsData(String title, String description){
        mDescription=description;
        mTitle=title;
    }

    public String getTitle(){
        return mTitle;
    }
    public String getDescription(){
        return mDescription;
    }
}
