package com.aline.splashdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aline.splashdemo.R;

/**
 * ViewGroup拦截View的点击事件
 *
 * @author SuTs
 * @create 2020/11/26 17:52
 * @Describe
 */
public class ViewGroupInterTouchActivity extends AppCompatActivity {
    private static final String TAG = "ViewGroupInterTouchActi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group_inter_touch);
        initView();
    }

    private void initView() {
        findViewById(R.id.bt_is_inter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "ViewGroupInterTouchActi-----onClick: ");
            }
        });
    }
}