package com.natetheprogrammer.alarmipator;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAlert(View view) {
        EditText etTime = findViewById(R.id.time);
        EditText etTitle = findViewById(R.id.title);
        EditText etMessage = findViewById(R.id.message);
        
        int x = Integer.parseInt(etTime.getText().toString());
        Intent intent = new Intent(view.getContext(), AlertBR.class);
        intent.putExtra("title", etTitle.getText() );
        intent.putExtra("message", etMessage.getText());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                //this.getApplicationContext(), 2343, intent, Intent.FILL_IN_DATA);
                //this.getApplicationContext(), 0, intent, 0 );
                //this, 0, intent, 0 );
                view.getContext(), 0, intent, Intent.FILL_IN_DATA );
        
        AlarmManager alarmManager = (AlarmManager) view.getContext().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (x * 1000), pendingIntent);
        
        Toast.makeText(this, "Alarm set in " + x + " seconds \n"+etTitle.getText()+ "\n"+etMessage.getText(), Toast.LENGTH_LONG).show();
    }
    
}