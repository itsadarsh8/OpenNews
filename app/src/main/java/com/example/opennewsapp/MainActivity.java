package com.example.opennewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;

import android.content.Loader;

import android.os.Bundle;

import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsData>> {
    private NewsAdapter newsAdapter;
    private static final String REQUEST_URL = "http://newsapi.org/v2/top-headlines?country=in&apiKey=665814a9b6bc469cb9d95218a9dedb04";
    private static final int News_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsAdapter = new NewsAdapter(this, new ArrayList<NewsData>());
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(newsAdapter);


        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(0,null,MainActivity.this).forceLoad();

    }

    //Loaders override methods below
    @Override
    public Loader<List<NewsData>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new NewsLoader(this, REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsData>> loader, List<NewsData> earthquakes) {
        // Clear the adapter of previous earthquake data
        newsAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            newsAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewsData>> loader) {
        // Loader reset, so we can clear out our existing data.
        newsAdapter.clear();
    }


}



