package com.example.opennewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.net.URL;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsData>> {

    private static final String LOG_TAG ="Test-Case-Error-generated";
    private String mURL;

    public NewsLoader(Context context,String url){
        super(context);
        mURL=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<NewsData> loadInBackground() {
        if(mURL==null){
            return null;
        }
        List<NewsData> newsDataList=QueryUtils.fetchNewsData(mURL);
        return newsDataList;
    }
}