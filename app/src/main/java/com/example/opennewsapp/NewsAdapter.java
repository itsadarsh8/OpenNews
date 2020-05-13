package com.example.opennewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<NewsData> {

    public NewsAdapter(Context context, ArrayList<NewsData> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentListView=convertView;

        if(currentListView==null){
            currentListView= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_structure, parent, false);
        }

        NewsData newsData=getItem(position);

        TextView titleView=currentListView.findViewById(R.id.title);
        titleView.setText(newsData.getTitle());

        TextView descriptionView=currentListView.findViewById(R.id.description);
        descriptionView.setText(newsData.getDescription());

        return currentListView;


    }
}
