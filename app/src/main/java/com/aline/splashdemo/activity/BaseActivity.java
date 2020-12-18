package com.aline.splashdemo.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aline.splashdemo.R;

/**
 * 测试工作台数据转换使用Comparetor
 *
 * @author SuTs
 * @create 2020/11/24 11:39
 * @Describe
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initData();
    }
    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart: pre ");
        super.onStart();
        Log.e(TAG, "onStart: after");
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart: ");
        super.onRestart();
    }
}