package com.aline.splashdemo.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aline.splashdemo.R;

public class ThreeActivity extends AppCompatActivity {
    private static final String TAG = "ThreeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        setContentView(R.layout.activity_three);
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

    public void openFour(View view) {//FourActivity
        startActivity(new Intent(ThreeActivity.this, FourActivity.class));
    }
}