package com.example.alok.trigoassignment2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Alok on 16-01-2018.
 */

public class Myservice extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"default rintone",Toast.LENGTH_LONG).show();
         mediaPlayer=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
