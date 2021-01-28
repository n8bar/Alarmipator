package com.natetheprogrammer.alarmipator;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlertBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("fromAlert",true);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(i);
        
        Notification notification = new NotificationCompat.Builder( context, App.NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle("iStillNeedToGetATitleFromTheIntentOrSumpn")
                .setContentText("iStillNeedToGetAMessageFromTheIntentOrSumpn")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        NotificationManagerCompat nmc = NotificationManagerCompat.from(context);

        nmc.notify(1, notification);
        
        mediaPlayer = MediaPlayer.create(context, R.raw.knock);
        mediaPlayer.start();
        Toast.makeText(context, "iProbablyNeedAMessageFromTheIntentOrSumpn", Toast.LENGTH_LONG).show();
        
    }
}
