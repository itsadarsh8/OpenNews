package com.example.opennewsapp;

public class NewsData {

    private String mTitle;
    private String mSectionName;
    private String mWebURL;
    private String mDate;
    private String mTime;


    public NewsData(String title, String webUrl,String sectionName,String date,String time){
        mWebURL=webUrl;
        mTitle=title;
        mSectionName=sectionName;
        mDate=date;
        mTime=time;
    }

    public String getTitle(){
        return mTitle;
    }
    public String getSectionName(){
        return mSectionName;
    }
    public String getWebURL(){
        return mWebURL;
    }
    public String getDate(){
        return mDate;
    }
    public String getTime(){
        return mTime;
    }
}
