package com.example.alok.trigoassignment2;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Alok on 17-01-2018.
 */

public class Message {
    public static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
