package sample.com.codingassignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

/**
 * Created by sharathkaribasappa on 17/02/18.
 */
@RunWith(CustomTestRunner.class)
@Config(constants = BuildConfig.class, shadows = {ShadowVolleyRequest.class})

public class NewsFeedActivityTest {

    private NewsFeedActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(NewsFeedActivity.class);
    }

    @Test
    /**
     * Test for success scenario/error scenario
     */
    public void Test1() {
        Assert.assertNotNull(activity);
        //passing the correct url to download the json data
        activity.fetchNewsData(Constants.URL);
        Assert.assertTrue(activity.getState() == 1);

        //passing error as url to test the error scenario
        //here UI can show old data if it is there in the cache else a blank screen
        activity.fetchNewsData("error");
        Assert.assertTrue(activity.getState() == 2);

        //passing noNetwork as url to test the no Network scenario
        //here UI can show old data if it is there in the cache or else a blank screen
        activity.fetchNewsData("noNetwork");
        Assert.assertTrue(activity.getState() == 2);
    }

    @After
    public void tearDown() {
        activity = null;
    }
}
