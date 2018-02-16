package sample.com.codingassignment;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * interfaces to communicate between presenter and view
 */
public interface NewsFeedContract {

    /** Represents the View in MVP. */
    interface View {
        void update();
    }

    /** Represents the list item view in the news feed list*/
    interface RowView {
        void setRowTitle(String title);
        void setRowDescription(String description);
        void setRowImage(String path);
    }

    /** Represents the Presenter in MVP. */
    interface Presenter {
        void fetchNewsFeed();
    }
}