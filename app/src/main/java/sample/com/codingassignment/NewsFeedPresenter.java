package sample.com.codingassignment;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * Presenter class which handles the json data, parsing and interacting with model and view class
 */
public class NewsFeedPresenter implements NewsFeedContract.Presenter,NetworkResponse {
    private static final String URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json";

    private List<NewsFeedModel> mNewsFeedModelList = new ArrayList<>();
    private NewsFeedContract.View mView;
    private VolleyRequest mVolleyRequest;

    public NewsFeedPresenter(NewsFeedContract.View view,Context context) {
        mView = view;
        mVolleyRequest = VolleyRequest.getInstance();
        mVolleyRequest.initializeRequestQueue(context);
    }

    public void onBindRowViewHolder(int position, NewsFeedContract.RowView rowView) {
        NewsFeedModel newsFeed = mNewsFeedModelList.get(position);
        rowView.setRowTitle(newsFeed.getRowTitle());
        rowView.setRowDescription(newsFeed.getRowDescription());
        rowView.setRowImage(newsFeed.getImagePath());
    }

    public int getListItemsCount() {
        return mNewsFeedModelList.size();
    }

    public String getAppBarTitle() {
        return mNewsFeedModelList.get(0).getAppBarTitle();
    }

    @Override
    public void fetchNewsFeed() {
        //perform network request to get the json
        mVolleyRequest.performNetworkRequest(URL,this);

    }

    @Override
    public void onSuccessReponse(String response) {
        JSONParser jsonParser = new JSONParser();

        jsonParser.ParseJsonData(response);
        mNewsFeedModelList = jsonParser.getParsedData();

        mView.update();
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onNoNetwork() {

    }
}