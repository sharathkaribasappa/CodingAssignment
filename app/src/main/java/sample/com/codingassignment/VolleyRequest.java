package sample.com.codingassignment;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by sharathkaribasappa on 16/02/18.
 */

public class VolleyRequest {

    private static final String TAG = "VolleyRequest";
    private static RequestQueue mQueue;

    private static final VolleyRequest M_VOLLEY_REQUEST = new VolleyRequest();

    public static VolleyRequest getInstance() {
        return M_VOLLEY_REQUEST;
    }

    private VolleyRequest(){}

    public void initializeRequestQueue(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void performNetworkRequest(String url, final NetworkResponse responseCallBack) {
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    responseCallBack.onSuccessReponse(response);
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

    public void cancelRequestQueue() {
        mQueue.cancelAll(TAG);
    }
}
