package sample.com.codingassignment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by sharathkaribasappa on 16/02/18.
 *
 * VolleyRequest for handling Network requests
 */

public class VolleyRequest {

    private static final String TAG = "VolleyRequest";
    private static RequestQueue mQueue;
    private Context mContext;

    private static final VolleyRequest M_VOLLEY_REQUEST = new VolleyRequest();

    public static VolleyRequest getInstance() {
        return M_VOLLEY_REQUEST;
    }

    private VolleyRequest(){}

    public void initializeRequestQueue(Context context) {
        mContext = context;
        mQueue = Volley.newRequestQueue(context);
    }

    /**
     * method to perform a network call. Uses Volley library to perform the call
     * @param url
     * @param responseCallBack
     */
    public void performNetworkRequest(String url, final NetworkResponse responseCallBack) {
        //check for network availability before making the network call
        if(!isNetworkAvailable()) {
            responseCallBack.onNoNetwork();
            return;
        }

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    responseCallBack.onSuccessResponse(response);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    responseCallBack.onErrorResponse(error);
                }
            }
        );

        stringRequest.setTag(TAG);
        mQueue.add(stringRequest);
    }

    /**
     * cancel all the network request in queue
     */
    public void cancelRequestQueue() {
        mQueue.cancelAll(TAG);
    }

    /**
     * method to check is phone is connected to wifi/mobile data
     * @return boolean
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
