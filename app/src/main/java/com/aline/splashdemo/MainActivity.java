package com.aline.splashdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.aline.splashdemo.activity.BaseActivity;
import com.aline.splashdemo.activity.BigImageActivity;
import com.aline.splashdemo.activity.LifeCycleActivity;
import com.aline.splashdemo.activity.RecyclerViewActivity;
import com.aline.splashdemo.service.ScreenBroadcastListener;
import com.aline.splashdemo.service.ScreenManager;
import com.aline.splashdemo.service.ServiceActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Context context;


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        context = MainActivity.this;
        //一像素保活
        final ScreenManager screenManager = ScreenManager.getInstance(MainActivity.this);
        ScreenBroadcastListener listener = new ScreenBroadcastListener(this);
        listener.registerlistener(new ScreenBroadcastListener.ScreenStateListener() {
            @Override
            public void onScreen0n() {
                screenManager.finishActivity();
            }

            @Override
            public void onScreenOff() {
                screenManager.startActivity();
            }
        });

        findViewById(R.id.bt_hash_recycler).setOnClickListener(this);
        findViewById(R.id.bt_activity_life).setOnClickListener(this);
        findViewById(R.id.bt_big_iamge).setOnClickListener(this);
        findViewById(R.id.bt_service).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_hash_recycler:
                startActivity(new Intent(context, RecyclerViewActivity.class));
                break;
            case R.id.bt_activity_life:
                startActivity(new Intent(context, LifeCycleActivity.class));
                break;
            case R.id.bt_big_iamge:
                startActivity(new Intent(context, BigImageActivity.class));
                break;
            case R.id.bt_service:
                startActivity(new Intent(context, ServiceActivity.class));
                break;
        }
    }
}