package com.example.opennewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
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
    private NewsAdapter newsAdapter;
    private static final String REQUEST_URL = "http://newsapi.org/v2/top-headlines?country=in&apiKey=665814a9b6bc469cb9d95218a9dedb04";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsAdapter = new NewsAdapter(this, new ArrayList<NewsData>());
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(newsAdapter);

        NewsAsyncTask task = new NewsAsyncTask();
        task.execute(REQUEST_URL);

    }

    private class NewsAsyncTask extends AsyncTask<String, Void, List<NewsData>> {


        @Override
        protected List<NewsData> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<NewsData> result = QueryUtils.fetchNewsData(urls[0]);
            return result;
        }


        @Override
        protected void onPostExecute(List<NewsData> data) {
            newsAdapter.clear();

            if (data != null && !data.isEmpty()) {
                newsAdapter.addAll(data);
            }
        }
    }
}



