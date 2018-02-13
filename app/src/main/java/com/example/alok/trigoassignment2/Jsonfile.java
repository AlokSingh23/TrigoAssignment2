package com.example.alok.trigoassignment2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Jsonfile extends AppCompatActivity {
    private  String TAG=Jsonfile.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    //private static CustomAdapter adapter;
    //url json
    private static String url="https://api.androidhive.info/contacts/";

    ArrayList<HashMap<String,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonfile);
        contactList=new ArrayList<>();
        lv=(ListView)findViewById(R.id.listView);
        new GetContacts().execute();

    }
    private class GetContacts extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            //show loading dialog
            pDialog=new ProgressDialog(Jsonfile.this);
            pDialog.setMessage("loading");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        protected Void doInBackground(Void... voids) {
            HttpHandler sh=new HttpHandler();
            String jsonStr=sh.makeServiceCall(url);

            Log.e(TAG,"Response from url"+jsonStr);
            if(jsonStr!=null){
                try{
                    JSONObject jsonObject=new JSONObject(jsonStr);
                    //getting json array mode
                    JSONArray contacts=jsonObject.getJSONArray("contacts");
                    //looping through all contacs
                    for(int i=0;i<contacts.length();i++){
                        JSONObject c=contacts.getJSONObject(i);

                        String id=c.getString("id");
                        String name=c.getString("name");
                        String email=c.getString("email");
                        String address=c.getString("address");
                        String gender=c.getString("gender");

                        JSONObject phone=c.getJSONObject("phone");
                        String mobile=phone.getString("mobile");
                        String home=phone.getString("home");
                        String office=phone.getString("office");

                        HashMap<String,String> contact=new HashMap<>();
                       // adding each child node
                        contact.put("id",id);
                        contact.put("name",name);
                        contact.put("name",email);
                        contact.put("name",mobile);
                        contactList.add(contact);

                    }
                }catch(final JSONException e){
                    Log.e(TAG,"JSON parssing error"+e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Jsonfile.this,"Json parssing error"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }else{
                Log.e(TAG,"could not get from server");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Jsonfile.this,"could not get from server",Toast.LENGTH_SHORT).show();
                    }
                });

            }
            return null;
        }
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);

            if(pDialog.isShowing()){
                pDialog.dismiss();
            }
            //updating java data to listview


            ListAdapter adapter=new SimpleAdapter(Jsonfile.this,contactList,R.layout.list_item,new String[]{"name","email","mobile"}, new int[]{R.id.name,R.id.email,R.id.mobile});

            lv.setAdapter(adapter);
        }
    }
}
