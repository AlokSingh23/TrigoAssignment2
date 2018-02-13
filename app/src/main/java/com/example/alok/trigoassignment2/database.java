package com.example.alok.trigoassignment2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class database extends AppCompatActivity {
    EditText userName,password;
    VivzDatabaseAdapter vivzHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        userName=(EditText)findViewById(R.id.userNameValue);
        password=(EditText)findViewById(R.id.passwordValue);
        vivzHelper=new VivzDatabaseAdapter(this);


    }
    public void addUser(View view){
        String user=userName.getText().toString();
        String pass=password.getText().toString();
    //    SQLiteDatabase sqLiteDatabase=vivzHelper.getWritableDatabase();
      //  ContentValues contentValues=new ContentValues();
        //contentValues.put(VivzDatabaseAdapter);
        long id=vivzHelper.insertData(user,pass);
        if(id<0){
            Message.message(this,"unsucessfull");
        }
        else{
            Message.message(this,"Sucessfully a Row");
        }
    }
    public void viewDetails(View view){
        String data=vivzHelper.getAllData().toString();
        Intent intent=new Intent(this,NextActivity.class);
        intent.putExtra("data",data);
        startActivity(intent);
      //  Message.message(this,"contacts\n "+data);
    }

}