package sample.com.codingassignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * Presenter class which handles the json data, parsing and interacting with model and view class
 */
public class NewsFeedPresenter implements NewsFeedContract.Presenter {
    private List<NewsFeedModel> mNewsFeedModelList = new ArrayList<>();
    private NewsFeedContract.View mView;

    public NewsFeedPresenter(NewsFeedContract.View view) {
        mView = view;
    }

    public void onBindRowViewHolder(int position, NewsFeedContract.RowView rowView){
        NewsFeedModel newsFeed = mNewsFeedModelList.get(position);
        rowView.setRowTitle(newsFeed.getRowTitle());
        rowView.setRowDescription(newsFeed.getRowDescription());
        rowView.setRowImage(newsFeed.getImagePath());
    }

    public int getListItemsCount() {
        return mNewsFeedModelList.size();
    }

    @Override
    public void fetchNewsFeed() {
        mView.update();
    }

    public String getAppBarTitle() {
        return mNewsFeedModelList.get(0).getAppBarTitle();
    }
}