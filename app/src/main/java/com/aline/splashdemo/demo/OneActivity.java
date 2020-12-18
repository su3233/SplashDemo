package com.aline.splashdemo.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aline.splashdemo.R;
import com.aline.splashdemo.activity.AActivity;
import com.aline.splashdemo.activity.BActivity;

/**
 * A(standard)->B(SingleTask)->C(SingleInstance)->D(SingleTop)->B的生命周期
 * 此时会D(onPause)->B的onNewIntent-onRestart-onStart-onResume-D(onStop-onDestory)
 */
public class OneActivity extends AppCompatActivity {
    private static final String TAG = "OneActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        setContentView(R.layout.activity_one);
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart: ");
        super.onStart();
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
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "onNewIntent: ");
        super.onNewIntent(intent);
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

    public void openTwo(View view) {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(OneActivity.this, TwoActivity.class));
//        startActivity(new Intent(OneActivity.this, BActivity.class));
    }

    public void testAnr(View view) {
        Toast.makeText(OneActivity.this,"显示土司",Toast.LENGTH_SHORT).show();
    }
}