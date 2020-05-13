package com.example.opennews;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class QueryUtils {

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

        return null;


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


}

