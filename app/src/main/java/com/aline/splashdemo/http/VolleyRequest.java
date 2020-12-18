package com.aline.splashdemo.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SuTs
 * @create 2020/12/10 11:04
 * @Describe
 */
public class VolleyRequest implements IRequestManager {

    private static RequestQueue requestQueue;

    private static class Singleton {
        private static final VolleyRequest INSTANCE = new VolleyRequest();
    }

    private VolleyRequest() {
    }

    public static VolleyRequest getInstance(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        return Singleton.INSTANCE;
    }

    @Override
    public void getRequest(String url, String para, ICallback iCallback) {
        requestQueue.add(new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallback.onFailed(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallback.onFailed(error.getMessage());
            }
        }));
    }

    @Override
    public void postRequest(String url, String para, ICallback iCallback) {
        requestQueue.add(new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallback.onSucceed(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallback.onFailed(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> maps = new HashMap<>();
                maps.put("key", "value");
                return maps;
            }
        });
    }

    @Override
    public void deleteRequest(String url, String para, ICallback iCallback) {

    }
}
