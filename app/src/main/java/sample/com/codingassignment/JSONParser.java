package sample.com.codingassignment;

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
    private List<ParsedData> mParsedData = new ArrayList<>();

    /**
     * Method which parses the json response
     * uses standard org.json java library to parse the data
     * @param response
     */
    public void ParseJsonData(String response) {
        try {
            JSONObject obj = new JSONObject(response);
            String appBarTitle = obj.getString("title");

            JSONArray jsonArray = obj.getJSONArray("rows");

            for(int i = 0; i < jsonArray.length(); i++) {
                ParsedData parsedData = new ParsedData();
                parsedData.appBarTitle = appBarTitle;

                parsedData.rowTitle = jsonArray.getJSONObject(i).getString("title");
                parsedData.rowDescription = jsonArray.getJSONObject(i).getString("description");
                parsedData.rowImagePath = jsonArray.getJSONObject(i).getString("imageHref");

                mParsedData.add(parsedData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
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
