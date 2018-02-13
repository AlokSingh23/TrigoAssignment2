package com.example.alok.trigoassignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alok on 17-01-2018.
 */

public class VivzDatabaseAdapter {
    VivzHelper helper;
    public VivzDatabaseAdapter(Context context){
        helper=new VivzHelper(context);
    }
    public long insertData(String name,String password) {
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(VivzHelper.NAME,name);
        contentValues.put(VivzHelper.PASSWORD,password);
        long id=db.insert(VivzHelper.TABLE_NAME,null,contentValues);
        return id;
    }
    public String getAllData(){
        SQLiteDatabase db=helper.getWritableDatabase();
        String[] columns={VivzHelper.UID, VivzHelper.NAME,VivzHelper.PASSWORD};
        Cursor cursor=db.query(VivzHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
           int cid=cursor.getInt(0);
           String name=cursor.getString(1);
           String password=cursor.getString(2);
           buffer.append(cid+" "+name+" "+password+"\n");


        }
        return buffer.toString();
    }
   static class VivzHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME="hello";
        private static final String TABLE_NAME="tab";
        private static final String UID="_id";
        private static final int DATABASE_VERSION=1;
        private static final String NAME="Name";
        private static final String PASSWORD="password";
        private static final String CREATE_TABLE="CREATE TABLE "
                +TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255))";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS"+TABLE_NAME;
        private  Context context;
        public VivzHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            Message.message(context,"constructor is called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(CREATE_TABLE);
            }catch (SQLException e){
                Message.message(context,""+e);
            }
            Message.message(context,"oncreate is called");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            try {
                db.execSQL(DROP_TABLE);
            }catch (SQLException e){
                Message.message(context,""+e);
            }
            Message.message(context,"upgrade is called");
        }
    }

}
