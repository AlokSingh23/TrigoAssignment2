package com.example.alok.trigoassignment2;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Progressbar extends AppCompatActivity {
    private ProgressBar progressbar;
    private int protressStatus=0;
    private TextView textView;
    private Handler handler=new Handler();
   // private Camera mCam;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        progressbar=(ProgressBar)findViewById(R.id.progress1);
        textView=(TextView)findViewById(R.id.text1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(protressStatus<100){
                    protressStatus+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        progressbar.setProgress(protressStatus);
                        textView.setText(protressStatus+"/"+progressbar.getMax());
                        }
                    });
                    try{
                        Thread.sleep(500);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
