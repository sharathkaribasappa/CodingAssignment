package sample.com.codingassignment;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * View class which shows the list of news feed items
 */

public class NewsFeedActivity extends AppCompatActivity implements NewsFeedContract.View{

    private RecyclerView recyclerView;
    private NewsFeedAdapter mAdapter;
    private NewsFeedPresenter mNewsFeedPresenter;
    private RelativeLayout relativeLayout;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relativelayout);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));

        //Initializing the presenter class
        mNewsFeedPresenter = new NewsFeedPresenter(this, getApplicationContext());

        //initialization of recycler view
        recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new NewsFeedAdapter(mNewsFeedPresenter, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        progress = new ProgressDialog(this);
        showProgressBar(true);
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
        showProgressBar(false);
        setTitle(mNewsFeedPresenter.getAppBarTitle());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
        mNewsFeedPresenter.cancelNetworkRequests();
    }

    @Override
    /**
     * show message to the user when there is no network or error response
     */
    public void showMessage(String message) {
        showProgressBar(false);

        Snackbar snackbar = Snackbar
                .make(relativeLayout, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    private void showProgressBar(boolean toShow) {
        if(toShow) {
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);

            progress.show();
        } else {
            progress.cancel();
        }
    }
}