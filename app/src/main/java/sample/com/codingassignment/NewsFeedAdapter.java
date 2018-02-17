package sample.com.codingassignment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * Adapter class required for the recycler view to render the data in the list
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.MyViewHolder> {

    private NewsFeedPresenter newsFeedPresenter;
    private Activity myActivity;

    public NewsFeedAdapter(NewsFeedPresenter newsFeedPresenter, Activity activity) {
        this.newsFeedPresenter = newsFeedPresenter;
        myActivity = activity;
    }

    /**
     * ViewHolder class for the Recycler view
     * also implements the contract interface to communicate with presenter
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements NewsFeedContract.RowView{
        public TextView title, description;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.rowtitle);
            description = view.findViewById(R.id.rowdescription);
            imageView = view.findViewById(R.id.rowimage);
        }

        @Override
        public void setRowTitle(String title) {
            this.title.setText(title);
        }

        @Override
        public void setRowDescription(String description) {
            this.description.setText(description);
        }

        @Override
        public void setRowImage(String path) {
            Glide.with(myActivity)
                    .load(path)
                    .into(imageView);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newsfeeditemlayout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //passing the holder to presenter class
        newsFeedPresenter.onBindRowViewHolder(position,holder);
    }

    @Override
    public int getItemCount() {
        return newsFeedPresenter.getListItemsCount();
    }
}