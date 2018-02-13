package com.example.alok.trigoassignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreference extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView name;
    TextView email;
    public static final String mypreference="mypref";
    public static final String Name="nameKey";
    public static final String Email="emailKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        name=(TextView)findViewById(R.id.etName);
        email=(TextView)findViewById(R.id.etEmail);
        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }

    }
    public void Save(View view){
        String n=name.getText().toString();
        String e=email.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Name,n);
        editor.putString(Email,e);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Text save",Toast.LENGTH_SHORT).show();
    }
    public void Clear(View view){
     name=(TextView)findViewById(R.id.etName);
     email=(TextView)findViewById(R.id.etEmail);
     name.setText("");
     email.setText("");
        Toast.makeText(getApplicationContext(),"Text Clear",Toast.LENGTH_SHORT).show();
    }
    public void Get(View view){
        name=(TextView)findViewById(R.id.etName);
        email=(TextView)findViewById(R.id.etEmail);
        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }
        Toast.makeText(getApplicationContext(),"Text Retrive",Toast.LENGTH_SHORT).show();

    }
    public boolean onCreateOptionMenu(Menu menu){
       // getMenuInflater().inflate(R.menu,menu_main,menu);
        return true;
    }
}
