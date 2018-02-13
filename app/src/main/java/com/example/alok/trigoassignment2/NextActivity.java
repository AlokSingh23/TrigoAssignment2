package com.example.alok.trigoassignment2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    Intent intent;
    Context context;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.getString("data");
        String[] words=data.split("\\n");
     //   TextView tvre=(TextView)findViewById(R.id.text3);
        //  tvre.setText(data);
       ListAdapter listAdapter;
      listAdapter  = new ArrayAdapter<String>(NextActivity.this,android.R.layout.simple_list_item_1,words);
       ListView listView=(ListView)findViewById(R.id.list);
       listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(NextActivity.this,value,Toast.LENGTH_LONG).show();


}

    });
    }
}

