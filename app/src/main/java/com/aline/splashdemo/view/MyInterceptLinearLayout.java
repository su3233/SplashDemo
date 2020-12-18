package com.aline.splashdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author SuTs
 * @create 2020/11/26 17:53
 * @Describe
 */
public class MyInterceptLinearLayout extends LinearLayout {
    private static final String TAG = "MyInterceptLinearLayout";

    public MyInterceptLinearLayout(Context context) {
        super(context);
    }

    public MyInterceptLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyInterceptLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyInterceptLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "ACTION_DOWN: ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "ACTION_MOVE: ");
                break;

            case MotionEvent.ACTION_UP:
                Log.e(TAG, "ACTION_UP: ");
                break;
        }
        return true;
//        return super.onTouchEvent(event);
    }

    //此处只拦截子控件的ACTION_UP事件进行处理，onTouch中处理自身的事件，
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int eventAction = ev.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "ACTION_UP:将被拦截 ");
                return true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
