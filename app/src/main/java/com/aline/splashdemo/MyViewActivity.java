package com.aline.splashdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 自定义View设置wrapContent时，放进一个100dp的LinearLayout中，View大小是多少，为什么？
 *
 * @author SuTs
 * @create 2020/12/8 19:37
 * @Describe
 */
public class MyViewActivity extends AppCompatActivity {
    private static final String TAG = "MyViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_test_default_view_size
        //activity_my_viewgroup
        setContentView(R.layout.activity_test_default_view_size);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }
}