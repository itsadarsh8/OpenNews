package com.example.opennewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<NewsData> newsData=QueryUtils.fetchNewsData(this);
        NewsAdapter newsAdapter=new NewsAdapter(this,newsData);
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(newsAdapter);
    }
}
