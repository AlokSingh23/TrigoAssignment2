package com.example.alok.trigoassignment2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    NotificationCompat.Builder notification;
    private static final int uniqueid=1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        button = findViewById(R.id.btnnotify);
        button.setOnClickListener(this);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    @Override
    public void onClick(View view) {

     notification.setSmallIcon(R.drawable.download1);
        notification.setTicker("ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("here is the title");
        notification.setContentText("i am the body texrt");
    Intent intent=new Intent(this,NotificationActivity.class);
    PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
    NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(uniqueid,notification.build());
}
}