package com.aline.splashdemo.service;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * 一像素保活
 *
 * @author SuTs
 * @create 2020/11/25 13:09
 * @Describe
 */
public class ScreenManager {
    private Context mContext;
    private WeakReference<Activity> mActivityWiref;
    public static ScreenManager gDefualt;

    public static ScreenManager getInstance(Context pContext) {
        if (gDefualt == null) {
            gDefualt = new ScreenManager(pContext.getApplicationContext());
        }
        return gDefualt;
    }

    private ScreenManager(Context pContext) {
        this.mContext = pContext;
    }

    public void setActivity(Activity pActivity) {
        mActivityWiref = new WeakReference<Activity>(pActivity);
    }

    public void startActivity() {
        ServiceOnePixelActivity.actionToLiveActivity(mContext);
    }

    public void finishActivity() {
        // 结束掉LiveActivity
        if (mActivityWiref != null) {
            Activity activity = mActivityWiref.get();
            if (activity != null) {
                activity.finish();
            }

        }
    }
}