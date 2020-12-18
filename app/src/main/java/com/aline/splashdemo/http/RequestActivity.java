package com.aline.splashdemo.http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.aline.splashdemo.R;

/**
 * 网络请求库的封装，使对于第三方不直接进行依赖
 */
public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }

    public void sendRequest(View view) {
        String url = "http://www.baidu.com";
        RequestFactory.getRequestManager(RequestActivity.this).getRequest(url, "", new ICallback() {
            @Override
            public void onSucceed(String response) {

            }

            @Override
            public void onFailed(String response) {

            }
        });
    }
}