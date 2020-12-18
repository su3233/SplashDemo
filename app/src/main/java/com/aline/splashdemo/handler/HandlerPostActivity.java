package com.aline.splashdemo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aline.splashdemo.R;

/**
 * activity传递给Thread一个Handler，Thread通过Handler更新activity
 * Thread通过Post更新activity de UI
 *
 * @author SuTs
 * @create 2020/11/3 18:11
 * @Describe
 */
public class HandlerPostActivity extends AppCompatActivity {
    private static final String TAG = "HandlerPostActivity";
    private TextView tvShowName, tvShowAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_post);
        initView();
    }

    private void initView() {
        tvShowName = findViewById(R.id.tv_show_post_name);
        tvShowAge = findViewById(R.id.tv_show_post_age);
        findViewById(R.id.bt_start_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LooperThread looperThread = new LooperThread(postHandler);
                looperThread.start();
                threadPost();
            }
        });
    }

    //Post更新一次
    private void threadPost() {
        postHandler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    Log.e(TAG, "run: " + i);
                    try {
                        Thread.sleep(1200);
//                        Message message = Message.obtain();
//                        message.what = 2;
//                        message.arg1 = i;
//                        postHandler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @SuppressLint("HandlerLeak")
    private Handler postHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
//            if (msg.what == 1) {
//                int name = msg.arg1;
            int name = msg.what;
            tvShowName.setText(name + "--张三");
//            } else if (msg.what == 2) {
//                int age = msg.arg1;
//                tvShowAge.setText(age + "岁");
//            }
        }
    };
}