package com.aline.splashdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aline.splashdemo.R;

import dagger.hilt.android.AndroidEntryPoint;

//@AndroidEntryPoint
public class HiltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilt);
    }
}