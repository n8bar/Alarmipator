package com.natetheprogrammer.alarmipator;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    Button start;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlert();
            }
        });
    }

    public void startAlert() {
        EditText txt = findViewById(R.id.time);
        int x = Integer.parseInt(txt.getText().toString());
        Intent my_intent = new Intent(this, AlertBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 2343, my_intent, 0);
        
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (x * 1000), pendingIntent);
        
        Toast.makeText(this, "Alarm set in " + x + " seconds", Toast.LENGTH_LONG).show();
    }
    
}