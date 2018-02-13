package com.example.alok.trigoassignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class AutotextView extends AppCompatActivity {
     String names[]={"deep","ramesh","rahul","ashok","deepak"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autotext_view);
        AutoCompleteTextView at=(AutoCompleteTextView)findViewById(R.id.autodemo);

        at.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,names));
        at.setThreshold(1);
      at.setOnItemClickListener(new OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             // Toast.makeText(AutotextView.this,names[i],Toast.LENGTH_LONG).show();
              Intent intent=new Intent(getApplicationContext(),AutotextShow.class);
              intent.putExtra("data",names[i+1]);
              startActivity(intent);
          }
      });
    }

}
