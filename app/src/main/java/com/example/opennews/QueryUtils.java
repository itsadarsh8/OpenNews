package com.example.opennews;

import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    //Make call direct from class name and dont make its objects
    private QueryUtils() {
    }


    //Creating list of objects
    public static List<NewsData> fetchNewsData(String requestUrl) {
        URL url = null;
        String jsonValue = "";

        url = createURL(requestUrl);
        try {
            jsonValue = makeHTTPrequest(url);
        } catch (IOException e) {
            Log.e("uniqueyoyo","Problem in HTTP Request");
        }

        Log.i("Output",jsonValue);

        List<NewsData> newsList= createFeatures(jsonValue);

        return newsList;


    }

    //Creating URL object
    private static URL createURL(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    //making HTTP Request for given URL and creating input stream
    private static String makeHTTPrequest(URL url) throws IOException {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        String jsonValue = "";

        if (url == null) {
            //if url is null return empty jsonValue
            return jsonValue;
        }

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                // Sucessfull response
                inputStream = urlConnection.getInputStream();
                // To convert stream of string into readable form
                jsonValue = convertStream(inputStream);
            } else {
                Log.e("uniqueyoyo", "url connection" + String.valueOf(urlConnection.getResponseCode()));
            }
        } catch (IOException e) {
            Log.e("uniqueyoyo", "Error at  line makeHTTPrequest block", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonValue;
    }

    //Converting InputStream into readable string
    private static String convertStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();

        if (inputStream != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = br.readLine();

            while (line != null) {
                output.append(line);
                line = br.readLine();
            }
        }
        return output.toString();

    }

    //Creating List of objects of extracted features
    private static List<NewsData> createFeatures(String jsonValue){


        if(jsonValue==null){
            return null;
        }

        ArrayList<NewsData> arrayList=new ArrayList<>();


        try {
            JSONObject jsonObject=new JSONObject(jsonValue);
            JSONArray jsonArray=jsonObject.getJSONArray("articles");

            for(int i=0;i< jsonArray.length();i++){
                JSONObject jsonChild=jsonArray.getJSONObject(i);
                String title=jsonChild.getString("title");
                String description=jsonChild.getString("description");
                NewsData newsData=new NewsData(title,description);

                arrayList.add(newsData);
            }


        } catch (JSONException e) {
            e.printStackTrace();

        }

        return  arrayList;


    }


}

