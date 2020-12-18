package com.aline.splashdemo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aline.splashdemo.R;

import java.lang.ref.WeakReference;

/**
 * 子线程中创建Handler更新UI，静态软引用Handler更新UI
 *
 * @author SuTs
 * @create 2020/11/3 18:21
 * @Describe
 */
public class HandlerActivity extends AppCompatActivity {

    public SafeHandler safeHandler;
    private TextView tvShowName, tvShowAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initView();
        safeHandler = new SafeHandler(this);
    }

    private void initView() {
        tvShowName = findViewById(R.id.tv_show_post_name);
        tvShowAge = findViewById(R.id.tv_show_post_age);
        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //模拟线程耗时操作
                downLoadThread();
                //在子线程中创建Handler
                handlerInThread();
            }
        });
    }

    //子线程中创建Handler，更新UI
    @SuppressLint("HandlerLeak")
    private void handlerInThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler mHandler = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        int num = msg.what;
                        Toast.makeText(getApplicationContext(), num + "--子线程", Toast.LENGTH_SHORT).show();
                        tvShowName.setText(num + "--张三");
                    }
                };
                Message message = Message.obtain();
                message.what = 4;
                mHandler.sendMessage(message);
                Looper.loop();
            }
        }).start();
    }

    //静态内部类创建Handler，子线程更新UI
    private void downLoadThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        Message message = Message.obtain();
                        message.what = i;
                        safeHandler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //静态+对activity软引用，避免activity销毁时ThreadHandler持有activity造成内存泄漏
    private static class SafeHandler extends Handler {
        private WeakReference<HandlerActivity> wrActivity;

        public SafeHandler(HandlerActivity activity) {
            wrActivity = new WeakReference(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            HandlerActivity activity = wrActivity.get();
            if (activity != null) {
                activity.handlerMessage(msg);
            }
        }
    }

    /**
     * activity中进行message处理
     *
     * @param msg
     */
    private void handlerMessage(Message msg) {
        int num = msg.what;
        tvShowAge.setText(num + "--岁");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        safeHandler.removeCallbacksAndMessages(null);
    }
}