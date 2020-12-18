package com.aline.splashdemo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author SuTs
 * @create 2020/11/25 14:14
 * @Describe
 */
public class LiveService extends Service {

    public static void toliveService(Context pContext) {
        Intent intent = new Intent(pContext, LiveService.class);
        pContext.startService(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//屏幕关闭的时候启动-个1像素的Activity,开屏的时候关闭Activity
        final ScreenManager screenManager = ScreenManager.getInstance(LiveService.this);
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
        return START_REDELIVER_INTENT;

    }
}