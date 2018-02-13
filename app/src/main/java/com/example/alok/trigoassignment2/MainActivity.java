package com.example.alok.trigoassignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] tool={"Recycleview","service","customView","notification","progresbar","sharedPreferences","sqlitedatabase","Jsonfile","Autotext"};
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tool);
        ListView listView=(ListView)findViewById(R.id.list_itema);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=String.valueOf(adapterView.getItemAtPosition(i));

                switch(value){
                    case "Recycleview":
                        intent=new Intent(getApplicationContext(),RviewActivity.class);
                       // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "service":
                        intent=new Intent(getApplicationContext(),ServiceActivity.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "customView":
                        intent=new Intent(getApplicationContext(),CustumActivity.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);


                        break;
                    case "notification":
                        intent=new Intent(getApplicationContext(),NotificationActivity.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "progresbar":
                        intent=new Intent(getApplicationContext(),Progressbar.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "sharedPreferences":
                        intent=new Intent(getApplicationContext(),SharedPreference.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "sqlitedatabase":
                        intent=new Intent(getApplicationContext(),database.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "Jsonfile":
                        intent=new Intent(getApplicationContext(),Jsonfile.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                    case "Autotext":
                        intent=new Intent(getApplicationContext(),AutotextView.class);
                        // Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
