package com.example.alok.trigoassignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AutotextShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autotext_show);






        TextView tvre=(TextView)findViewById(R.id.terv);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.getString("data");
        tvre.setText(data);

    }
}
