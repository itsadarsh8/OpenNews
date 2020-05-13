package com.example.opennews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        QueryUtils.fetchNewsData("http://newsapi.org/v2/top-headlines?country=in&apiKey=665814a9b6bc469cb9d95218a9dedb04");
    }
}
