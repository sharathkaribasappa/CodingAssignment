package sample.com.codingassignment;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * Class to parse JSON data
 */

public class JSONParser {
    private static final String TAG = "JSONParser";
    private List<ParsedData> mParsedData = new ArrayList<>();

    /**
     * Method which parses the json response
     * uses standard org.json java library to parse the data
     * @param response
     */
    public boolean parseJsonData(String response) {
        try {
            JSONObject obj = new JSONObject(response);
            String appBarTitle = obj.getString("title");

            JSONArray jsonArray = obj.getJSONArray("rows");

            mParsedData.clear();
            for(int i = 0; i < jsonArray.length(); i++) {
                ParsedData parsedData = new ParsedData();
                parsedData.appBarTitle = appBarTitle;

                parsedData.rowTitle = jsonArray.getJSONObject(i).getString("title");
                parsedData.rowDescription = jsonArray.getJSONObject(i).getString("description");
                parsedData.rowImagePath = jsonArray.getJSONObject(i).getString("imageHref");

                if(parsedData.rowTitle.equals("null")) {
                    parsedData.rowTitle = "";
                }

                if(parsedData.rowDescription.equals("null")) {
                    parsedData.rowDescription = "";
                }

                if(parsedData.rowTitle.isEmpty() || parsedData.rowDescription.isEmpty()) {
                    //don't add empty data to list
                } else {
                    mParsedData.add(parsedData);
                }
            }

            return true;
        } catch (JSONException e) {
            Log.e(TAG,"json parsing exception");
            return false;
        }
    }

    /**
     * simple data structure class used to hold parsed data
     */
    class ParsedData {
        String appBarTitle;
        String rowTitle;
        String rowDescription;
        String rowImagePath;
    }

    public List<ParsedData> getParsedData() {
        return mParsedData;
    }
}
