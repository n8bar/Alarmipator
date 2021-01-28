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

        this.createNotificationChannels();
    }

    private void createNotificationChannels()  {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel SPPAChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "Student Pocket Planner",
                    NotificationManager.IMPORTANCE_HIGH
            );
            SPPAChannel.setDescription("Student Pocket Planner Alert");


            NotificationManager manager = this.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(SPPAChannel);
        }
    }
    
}
