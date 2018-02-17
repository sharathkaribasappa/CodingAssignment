package sample.com.codingassignment;

import android.content.Context;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * Presenter class which handles the json data, parsing and interacting with model and view class
 */
public class NewsFeedPresenter implements NewsFeedContract.Presenter,NetworkResponse {

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
    /**
     * method to request a network call
     */
    public void fetchNewsFeed(String url) {
        //perform network request to get the json data
        mVolleyRequest.performNetworkRequest(url,this);
    }

    @Override
    /**
     * got a success response for the network call made
     * parse the json data and update the model class
     */
    public void onSuccessResponse(String response) {
        JSONParser jsonParser = new JSONParser();

        jsonParser.parseJsonData(response);

        List<JSONParser.ParsedData> parsedData = jsonParser.getParsedData();

        //clear the list before updating with new one
        mNewsFeedModelList.clear();
        for(int i = 0; i < parsedData.size(); i++) {
            NewsFeedModel newsFeedModel = new NewsFeedModel();
            newsFeedModel.setAppBarTitle(parsedData.get(i).appBarTitle);
            newsFeedModel.setRowTitle(parsedData.get(i).rowTitle);
            newsFeedModel.setRowDescription(parsedData.get(i).rowDescription);
            newsFeedModel.setImagePath(parsedData.get(i).rowImagePath);

            mNewsFeedModelList.add(newsFeedModel);
        }

        mView.update();
    }

    @Override
    /**
     * got an error response for the network call made
     * tell the user network error and try again by tapping the refresh button
     */
    public void onErrorResponse(VolleyError error) {
        mView.showMessage("Network Error, " + error.getMessage() + ", please try again");
    }

    @Override
    /**
     * no network available to perform network call
     * tell the user to connect to the mobile data/wife and try again
     */
    public void onNoNetwork() {
        mView.showMessage("Device is offline");
    }

    /**
     * method to stop all the network requests which are in queue
     */
    public void cancelNetworkRequests() {
        mVolleyRequest.cancelRequestQueue();
    }
}