package com.example.opennewsapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QueryUtils  {

    //Dummy data of same API for testing purpose
   static String s="{\"status\":\"ok\",\"totalResults\":38,\"articles\":[{\"source\":{\"id\":null,\"name\":\"Ndtv.com\"},\"author\":null,\"title\":\"Government Announces PF Benefits, Take Home Salaries To Increase - NDTV Profit\",\"description\":\"To provide more take home salary for employees and to give relief to employers, the EPF or Employee Provident Fund contribution is being reduced for businesses and workers for three months, the government said today. This will amount to a liquidity support of…\",\"url\":\"https://www.ndtv.com/business/epf-contribution-to-be-reduced-for-businesses-workers-for-3-months-to-10-from-12-stays-at-12-for-state-run-firms-2228187\",\"urlToImage\":\"https://c.ndtvimg.com/sfuu5ndo_epf_625x300_28_July_18.jpg\",\"publishedAt\":\"2020-05-13T14:26:20Z\",\"content\":\"For state-run firms, the employer contribution will remain at 12%.\"},{\"source\":{\"id\":null,\"name\":\"Ndtv.com\"},\"author\":\"Prabhakar Thakur\",\"title\":\"Vivo V19 vs Poco X2: Price in India, Specifications Compared - Gadgets 360\",\"description\":\"Vivo V19 was launched in India on Tuesday with dual selfie camera setup and Qualcomm Snapdragon 712 SoC. The phone has come to the country after several delays due to coronavirus. Its price starts at Rs. 27,990 for the 8GB + 128GB storage model. On the other …\",\"url\":\"https://gadgets.ndtv.com/mobiles/news/vivo-v19-vs-poco-x2-price-in-india-specifications-features-comparison-2228288\",\"urlToImage\":\"https://i.gadgets360cdn.com/large/vivo_v19_poco_x2_full_1589376189087.jpg\",\"publishedAt\":\"2020-05-13T13:36:58Z\",\"content\":\"Vivo V19 was launched in India on Tuesday with dual selfie camera setup and Qualcomm Snapdragon 712 SoC. The phone has come to the country after several delays due to coronavirus. Its price starts at Rs. 27,990 for the 8GB + 128GB storage model. On the other … [+7520 chars]\"},{\"source\":{\"id\":null,\"name\":\"Gsmarena.com\"},\"author\":\"Peter\",\"title\":\"Samsung Galaxy Fold Lite to cost $1,100, come with S865 and 4G connectivity - GSMArena.com news - GSMArena.com\",\"description\":\"That's Galaxy S20+ 4G money and a good deal less than the original Fold, which was nearly $2,000 (and came with an S855 chipset).\",\"url\":\"https://www.gsmarena.com/samsung_galaxy_fold_lite_may_cost_1100_will_have_s865_chipset_and_4g_connectivity-news-43174.php\",\"urlToImage\":\"https://fdn.gsmarena.com/imgroot/news/20/05/samsung-galaxy-fold-lite-weinbach/-476x249w4/gsmarena_000.jpg\",\"publishedAt\":\"2020-05-13T13:30:02Z\",\"content\":\"Rumor has it that Samsung will drop the starting price of the Galaxy Fold 2 by $100 compared to the first Fold, but that would still leave it beyond the means of most people. A new bit of gossip (coming from Max Weinbach who leaked a ton of Galaxy S20 info) d… [+1297 chars]\"},{\"source\":{\"id\":\"mashable\",\"name\":\"Mashable\"},\"author\":\"Mashable News Staff\",\"title\":\"Astronomers Discover A Rare Super-Earth Exoplanet In The Centre Of The Galaxy - Mashable India\",\"description\":\"Astronomers have found a super-Earth exoplanet towards the centre of our Milky Way galaxy, near the galactic bulge. The rare discovery has been described by the scientists to be one of the few exoplanets that are comparable to Earth in terms of size and orbit.\",\"url\":\"https://in.mashable.com/science/13986/astronomers-discover-a-rare-super-earth-exoplanet-in-the-centre-of-the-galaxy\",\"urlToImage\":\"https://sm.mashable.com/mashable_in/seo/1/17958/17958_4tkp.jpg\",\"publishedAt\":\"2020-05-13T13:08:00Z\",\"content\":\"Astronomers have found a super-Earth exoplanet towards the centre of our Milky Way galaxy, near the galactic bulge. The rare discovery has been described by scientists as to be one of the few exoplanets that are comparable to Earth, in terms of size and orbit… [+1915 chars]\"}]}";

    //Call by direct class name and not by creating its objects
    private QueryUtils(){}
    

    public static ArrayList<NewsData> fetchNewsData(Context context){
        ArrayList<NewsData> arrayList=new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(s);
            JSONArray jsonArray=baseJsonResponse.getJSONArray("articles");

            for(int i=0;i< jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String title=jsonObject.getString("title");
                String description=jsonObject.getString("description");

                Log.i(context.getString(R.string.output_test),title);
                Log.i(context.getString(R.string.output_test),description);

                NewsData newsData=new NewsData(title,description);
                 arrayList.add(newsData);
            }

        } catch (JSONException e) {
            Log.i(context.getString(R.string.error_test),"Cant extract features :"+e.toString());
        }
        return arrayList;
    }


}

