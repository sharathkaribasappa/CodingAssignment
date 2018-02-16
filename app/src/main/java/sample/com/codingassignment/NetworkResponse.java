package sample.com.codingassignment;

import com.android.volley.VolleyError;

/**
 * Created by sharathkaribasappa on 16/02/18.
 */

public interface NetworkResponse {
    void onSuccessReponse(String response);
    void onErrorResponse(VolleyError error);
    void onNoNetwork();
}