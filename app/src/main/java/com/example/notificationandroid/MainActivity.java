package com.example.notificationandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button show;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (Button)findViewById(R.id.btn_show);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//                Intent myIntent;
//                PendingIntent pendingIntent;
//
//                // SET TIME HERE
//                Calendar calendar= Calendar.getInstance();
//                calendar.set(Calendar.HOUR_OF_DAY,16);
//                calendar.set(Calendar.MINUTE,44);
//
//
//                myIntent = new Intent(MainActivity.this,AlarmNotificationReceiver.class);
//                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,myIntent,0);
//
//
//
//                    manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);



                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 48);



                Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                if (alarmManager != null) {
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

                }else{
                    Toast.makeText(MainActivity.this, "null", Toast.LENGTH_LONG).show();
                }

    }
        });

    }

}