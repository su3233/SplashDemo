package com.aline.splashdemo.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * @author SuTs
 * @create 2020/12/10 11:13
 * @Describe
 */
public class OkHttpRequest implements IRequestManager {
    private static final String TAG = "OkHttpRequest";
    private static OkHttpClient okHttpClient;

    private static class Singleton {
        private static final OkHttpRequest INSTANCE = new OkHttpRequest();
    }

    private OkHttpRequest() {
    }

    public static OkHttpRequest getInstance(Context context) {
        okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return null;
                    }
                })
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String reuqest = chain.toString();
                        Log.e(TAG, "intercept: " + reuqest);
                        return null;
                    }
                })
                .build();
        return OkHttpRequest.Singleton.INSTANCE;
    }


    @Override
    public void getRequest(String url, String para, ICallback iCallback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("", "")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallback.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                iCallback.onSucceed(response.body().string());
            }
        });
    }

    @Override
    public void postRequest(String url, String para, ICallback iCallback) {
        RequestBody requestBody =RequestBody.create(MediaType.parse("application/json; charset=utf-8"),para);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("", "")
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallback.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                iCallback.onSucceed(response.body().string());
            }
        });
    }

    @Override
    public void deleteRequest(String url, String para, ICallback iCallback) {

    }
}
