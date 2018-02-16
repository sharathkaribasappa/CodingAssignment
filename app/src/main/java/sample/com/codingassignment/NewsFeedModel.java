package sample.com.codingassignment;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * Model class to hold the parsed json data
 */

public class NewsFeedModel {
    private String AppBarTitle;
    private String rowTitle;
    private String rowDescription;
    private String imagePath;

    public NewsFeedModel() {}

    public String getAppBarTitle() {
        return AppBarTitle;
    }

    public void setAppBarTitle(String appBarTitle) {
        AppBarTitle = appBarTitle;
    }

    public String getRowTitle() {
        return rowTitle;
    }

    public void setRowTitle(String rowTitle) {
        this.rowTitle = rowTitle;
    }

    public String getRowDescription() {
        return rowDescription;
    }

    public void setRowDescription(String rowDescription) {
        this.rowDescription = rowDescription;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
