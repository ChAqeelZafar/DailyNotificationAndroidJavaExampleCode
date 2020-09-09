package com.example.notificationandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        NotHel notificationHelper = new NotHel(context);
        notificationHelper.createNotification();

    }
}