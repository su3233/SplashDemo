package com.aline.splashdemo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.TestParcelableActivity;
import com.aline.splashdemo.entity.LocalFeedbackBean;

import java.util.ArrayList;

/**
 * 通过使用HandlerThread，创建Handler+Thread更新UI
 *
 * @author SuTs
 * @create 2020/11/3 18:22
 * @Describe
 */
public class HandlerThreadActivity extends AppCompatActivity {
    private static final String TAG = "HandlerThreadActivity";
    public Handler mHandler;
    private TextView tvShowName, tvShowAge;
    private HandlerThread handlerThread;
    ArrayList<LocalFeedbackBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initData();
        initView();
        createHandlerThread();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LocalFeedbackBean.DataBean dataBean = new LocalFeedbackBean.DataBean();
            dataBean.setTitle("title" + i);
            dataBean.setContent("Content" + i);
            list.add(dataBean);
        }
    }

    private void createHandlerThread() {
        handlerThread = new HandlerThread("handler+thread");
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                int num = msg.what;
                Log.e(TAG, "handleMessage: " + Thread.currentThread().getName());
                tvShowName.setText(num + "");
            }
        };
    }

    private void initView() {
        tvShowName = findViewById(R.id.tv_show_post_name);
        tvShowAge = findViewById(R.id.tv_show_post_age);
        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startThreadTime();
            }
        });
        findViewById(R.id.bt_trans_para).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestParcelableActivity.lunch(HandlerThreadActivity.this, list);
            }
        });
    }

    private void startThreadTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(1000);
                        Message message = Message.obtain();
                        message.what = i;
                        mHandler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }
}