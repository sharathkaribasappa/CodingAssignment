package sample.com.codingassignment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharathkaribasappa on 16/02/18.
 */

public class JSONParser {
    private List<NewsFeedModel> mNewsFeedModelList = new ArrayList<>();

    public void ParseJsonData(String response) {
        try {
            JSONObject obj = new JSONObject(response);
            String appBarTitle = obj.getString("title");

            JSONArray jsonArray = obj.getJSONArray("rows");

            for(int i = 0; i < jsonArray.length(); i++) {
                String rowTitle = jsonArray.getJSONObject(i).getString("title");
                String rowDescription = jsonArray.getJSONObject(i).getString("description");
                String rowImagePath = jsonArray.getJSONObject(i).getString("imageHref");

                NewsFeedModel newsFeedModel = new NewsFeedModel();
                newsFeedModel.setAppBarTitle(appBarTitle);
                newsFeedModel.setRowTitle(rowTitle);
                newsFeedModel.setRowDescription(rowDescription);
                newsFeedModel.setImagePath(rowImagePath);

                mNewsFeedModelList.add(newsFeedModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<NewsFeedModel> getParsedData() {
        return mNewsFeedModelList;
    }
}
