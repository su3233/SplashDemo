package com.aline.splashdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aline.splashdemo.R;
import com.aline.splashdemo.fragment.LifeCycleFragment;

/**
 * 测试Activity+Fragment的生命周期转换
 *
 * @author SuTs
 * @create 2020/12/18 15:18
 * @Describe
 */
public class LifeCycleActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LifeCycleActivity";
    private FragmentManager fragmentManager;
    private LifeCycleFragment lifeCycleFragment;
    private static final String FM_TAG = "fragment_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.e(TAG, "onCreate: ");

        initView();
    }

    private void initView() {
        findViewById(R.id.bt_show_hide_fm).setOnClickListener(this);
        findViewById(R.id.bt_replace_fm).setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        lifeCycleFragment = LifeCycleFragment.newInstance("fm_key", "fm_value");
        transaction.add(R.id.ll_fm_1, lifeCycleFragment, FM_TAG).commit();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        LinearLayout linearLayout = findViewById(R.id.ll_fm_1);
        ViewGroup.LayoutParams params = linearLayout.getLayoutParams();
        params.width = widthPixels * 2 / 3;
        linearLayout.setLayoutParams(params);
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
    protected void onResume() {
        Log.e(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_show_hide_fm:
                if (fragmentManager.findFragmentByTag(FM_TAG).isHidden()) {
                    fragmentManager.beginTransaction().show(lifeCycleFragment).commit();
                } else {
                    fragmentManager.beginTransaction().hide(lifeCycleFragment).commit();
                }
                break;
            case R.id.bt_replace_fm:
                lifeCycleFragment = LifeCycleFragment.newInstance("fm_key", "fm_value");
                fragmentManager.beginTransaction().replace(R.id.ll_fm_1, lifeCycleFragment, FM_TAG).commit();
                break;
        }
    }
}