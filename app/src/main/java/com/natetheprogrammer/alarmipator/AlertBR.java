package com.natetheprogrammer.alarmipator;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlertBR extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    String title = "<untitled>";
    String message = "<empty>";

    @Override
    public void onReceive(Context context, Intent intent) { 
        
        context = context.getApplicationContext();
        
        title = intent.getStringExtra("title");
        message = intent.getStringExtra("message");
        
        Notification notification = new NotificationCompat.Builder( context, App.NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        NotificationManagerCompat nmc = NotificationManagerCompat.from(context);

        nmc.notify(1, notification);
        
        mediaPlayer = MediaPlayer.create(context, R.raw.knock);
        mediaPlayer.start();
        Toast.makeText(context, title+"\n"+message, Toast.LENGTH_LONG).show();
        
    }
    
    
}
