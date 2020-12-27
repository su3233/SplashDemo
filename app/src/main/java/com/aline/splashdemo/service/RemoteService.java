package com.aline.splashdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    static final int MSG_SAY_HELLO = 1;
    private static final String TAG = "RemoteService";

    class Localhandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
//                    Log.e(TAG, "handleMessage : accepted!");
                    Log.e(TAG, "service接收到消息: "+msg.getData().getString("to_service") );
                    //接收到消息，进行信息回馈
                    Messenger client = msg.replyTo;
                    Message replyMsg = Message.obtain(null, RemoteService.MSG_SAY_HELLO, 0, 0);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "ok~,I had receiver message from you! ");
                    replyMsg.setData(bundle);
                    try {
                        client.send(replyMsg);
                        Log.e(TAG, "handleMessage:");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    //通过IncomingHandler对象创建一个Messenger对象,该对象是与客户端交互的特殊对象
    final Messenger mMessenger = new Messenger(new Localhandler());

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: remoteService");
        return mMessenger.getBinder();
    }
}
