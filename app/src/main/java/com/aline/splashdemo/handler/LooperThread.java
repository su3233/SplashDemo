package com.aline.splashdemo.handler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * @author SuTs
 * @create 2020/11/2 11:06
 * @Describe
 */
public class LooperThread extends Thread {
    private static final String TAG = "LooperThread";
    private Handler mHandler;

    public LooperThread(Handler handler) {
        mHandler = handler;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 20; i++) {
            Log.e(TAG, "run: " + i);
            try {
                Thread.sleep(1000);
                Message message = Message.obtain();
                message.what = i;
//                message.arg1 = i;
                mHandler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
