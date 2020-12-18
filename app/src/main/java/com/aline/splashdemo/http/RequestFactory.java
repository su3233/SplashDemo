package com.aline.splashdemo.http;

import android.content.Context;

/**
 * @author SuTs
 * @create 2020/12/10 11:05
 * @Describe
 */
public class RequestFactory {
    public static IRequestManager getRequestManager(Context context) {
        return VolleyRequest.getInstance(context);
    }
}
