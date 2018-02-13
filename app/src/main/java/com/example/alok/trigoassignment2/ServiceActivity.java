package com.example.alok.trigoassignment2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button start, stop;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        start = (Button) findViewById(R.id.button_Start);
        stop = (Button) findViewById(R.id.button_Stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    public void onClick(View view) {
        if (view == start) {
            startService(new Intent(this, Myservice.class));
        } else if (view == stop) {
            stopService(new Intent(this, Myservice.class));
        }
    }
}


