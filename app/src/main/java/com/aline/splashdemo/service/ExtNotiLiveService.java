package com.aline.splashdemo.service;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

/**
 * NotificationListenerService 就是一个监听 通知的服务，只要手机收到了通知，NotificationListenerService 都能监听到，
 *
 * @author SuTs
 * @create 2020/11/25 14:33
 * @Describe
 */
public class ExtNotiLiveService extends NotificationListenerService {
    public ExtNotiLiveService() {

    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
    }

}
