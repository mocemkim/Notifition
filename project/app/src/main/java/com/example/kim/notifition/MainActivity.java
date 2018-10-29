package com.example.kim.notifition;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mylibrary.SenderActivity;
import com.example.mylibrary.ShowListNotification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends Activity {

    private Button btnSendmessage;
    private Button btnShowListNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        btnSendmessage = findViewById(R.id.btn_sendmessage);
        btnShowListNotification = findViewById(R.id.btn_showlistnotification);

        // send notification
        btnSendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SenderActivity.class);
                startActivity(intent);
            }
        });
        // Show History
        btnShowListNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowListNotification.class);
                startActivity(intent);
            }
        });
    }
}