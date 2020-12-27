package com.aline.splashdemo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.aline.splashdemo.R;
import com.aline.splashdemo.activity.BaseActivity;

/**
 * 服务使用
 */
public class ServiceActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "ServiceActivity";
    private ServiceMethod binderService;
    private ServiceConnection connection;
    private ServiceConnection messengerConn;
    private Messenger messengerService;
    boolean isBind;

    @Override
    protected int initLayout() {
        return R.layout.activity_service;
    }

    @Override
    protected void initView() {
        findViewById(R.id.bt_start_service).setOnClickListener(this);
        findViewById(R.id.bt_stop_service).setOnClickListener(this);
        findViewById(R.id.bt_bind_service).setOnClickListener(this);
        findViewById(R.id.bt_invoke_service).setOnClickListener(this);
        findViewById(R.id.bt_unbind_service).setOnClickListener(this);
        findViewById(R.id.bt_service_messenger).setOnClickListener(this);
        findViewById(R.id.bt_messenger_bind).setOnClickListener(this);
        findViewById(R.id.bt_messenger_unbind).setOnClickListener(this);
        findViewById(R.id.bt_start_for_service).setOnClickListener(this);
        findViewById(R.id.bt_stop_for_service).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                ServiceMethod.LocalBinder binder = (ServiceMethod.LocalBinder) service;
                binder.start();
                binder.end();
                binderService = binder.getservices();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                binderService = null;
                Log.e(TAG, "onServiceDisconnected: ");
            }
        };

        messengerConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                messengerService = new Messenger(service);
                isBind = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                messengerService = null;
                isBind = false;
            }
        };
    }

    //用于接收消息
    Messenger receiveMessenger = new Messenger(new ReceiveHandler());

    private class ReceiveHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case RemoteService.MSG_SAY_HELLO:
                    Log.e(TAG, "通过messenger接收到Service消息： " + msg.getData().getString("reply"));
                    break;
            }
            super.handleMessage(msg);
        }
    }


    @Override
    public void onClick(View v) {
        Intent forIntent = new Intent(this, ForegroundService.class);
        switch (v.getId()) {
            //生命周期：onCreate-onStartCommand-onStart
            case R.id.bt_start_service:
                startService(new Intent(this, ServiceMethod.class));
                break;
            //onDestory
            case R.id.bt_stop_service:
                stopService(new Intent(this, ServiceMethod.class));
                break;
            /**
             * bindService
             */
            //生命周期：onCreate-onBind-onStart
            case R.id.bt_bind_service:
                Intent bindIntent = new Intent(ServiceActivity.this, ServiceMethod.class);
                bindService(bindIntent, connection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.bt_invoke_service:
                binderService.serviceMethod();
                break;
            //onUnbind-onDestory
            case R.id.bt_unbind_service:
                unbindService(connection);
                break;
            /**
             * Messenger的Service进行bind
             */
            case R.id.bt_messenger_bind:
                Intent msgBindIntent = new Intent(this, RemoteService.class);
                bindService(msgBindIntent, messengerConn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.bt_service_messenger:
                if (!isBind) return;
                Message message = Message.obtain(null, RemoteService.MSG_SAY_HELLO, 0, 0);
                message.replyTo = receiveMessenger;
                Bundle bundle = new Bundle();
                bundle.putString("to_service", "activity给service发送消息");
                message.setData(bundle);
                try {
                    messengerService.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bt_messenger_unbind:
                if (isBind) {
                    unbindService(messengerConn);
                    isBind = false;
                }
                break;

            /**
             * 前台服务
             */
            case R.id.bt_start_for_service:
                forIntent.putExtra("cmd", 0);//0,开启前台服务,1,关闭前台服务
                startService(forIntent);
                break;
            case R.id.bt_stop_for_service:
                forIntent.putExtra("cmd", 1);//0,开启前台服务,1,关闭前台服务
                startService(forIntent);
                break;
        }
    }
}