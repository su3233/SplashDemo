package com.aline.splashdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.aline.splashdemo.activity.AActivity;
import com.aline.splashdemo.activity.GlideProgressActivity;
import com.aline.splashdemo.activity.LifeCycleActivity;
import com.aline.splashdemo.activity.MyFragmentActivity;
import com.aline.splashdemo.activity.TestExtendsActivity;
import com.aline.splashdemo.activity.TestWorkBenchActivity;
import com.aline.splashdemo.activity.ViewGroupInterTouchActivity;
import com.aline.splashdemo.demo.OneActivity;
import com.aline.splashdemo.fragment.LifeCycleFragment;
import com.aline.splashdemo.handler.HandlerActivity;
import com.aline.splashdemo.handler.HandlerPostActivity;
import com.aline.splashdemo.handler.HandlerThreadActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //HandlerThreadActivity     HandlerActivity     HandlerThreadActivity   MyViewActivity
                //AActivity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}