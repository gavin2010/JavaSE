package com.gavin.jmx.mbean;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Jack extends NotificationBroadcasterSupport implements JackMBean{
    private int seq = 0;
    @Override
    public void hi() {
        //创建一个信息包     //通知名称；谁发起的通知；序列号；发起通知时间；发送的消息
        Notification notify = new Notification("jack.hi",this,++seq,System.currentTimeMillis(),"jack");
        sendNotification(notify);
    }
}
