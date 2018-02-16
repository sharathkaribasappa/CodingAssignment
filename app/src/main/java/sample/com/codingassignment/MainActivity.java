package sample.com.codingassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * View class which shows the list of news feed items
 */

public class MainActivity extends AppCompatActivity implements NewsFeedContract.View{

    private RecyclerView recyclerView;
    private NewsFeedAdapter mAdapter;
    private NewsFeedPresenter mNewsFeedPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));

        //Initializing the presenter class
        mNewsFeedPresenter = new NewsFeedPresenter(this, getApplicationContext());

        //initialization of recycler view
        recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new NewsFeedAdapter(mNewsFeedPresenter, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mNewsFeedPresenter.fetchNewsFeed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflating the action bar layout
        getMenuInflater().inflate(R.menu.actionbar_resource, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    /**
     * method to handle the refresh button click
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                // User clicked the "refresh" button, fetch the data from server and update the UI with new data
                mNewsFeedPresenter.fetchNewsFeed();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    /**
     * callback from Presenter class to update the UI once json data is ready
     */
    public void update() {
        setTitle(mNewsFeedPresenter.getAppBarTitle());
        mAdapter.notifyDataSetChanged();
    }
}