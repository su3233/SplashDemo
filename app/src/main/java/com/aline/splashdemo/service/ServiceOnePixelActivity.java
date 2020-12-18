package com.aline.splashdemo.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.aline.splashdemo.R;

/**
 * 一像素保活
 *
 * @author SuTs
 * @create 2020/12/18 17:30
 * @Describe
 */
public class ServiceOnePixelActivity extends AppCompatActivity {
    private static final String TAG = "ServiceOnePixelActivity";

    public static void actionToLiveActivity(Context pContext) {
        Intent intent = new Intent(pContext, ServiceOnePixelActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        pContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_service_one_pixel);
        Window window = getWindow();
//放在左上角
        window.setGravity(Gravity.START | Gravity.TOP);
        WindowManager.LayoutParams attributes = window.getAttributes();
//宽高设计为1个像素
        attributes.width = 1;
        attributes.height = 1;
//起始坐标
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        ScreenManager.getInstance(this).setActivity(this);

    }

}