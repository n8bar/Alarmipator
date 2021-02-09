package com.natetheprogrammer.alarmipator;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final  String NOTIFICATION_CHANNEL_ID = "Channel 1";

    @Override
    public void onCreate() {
        super.onCreate();

    }
    
}
