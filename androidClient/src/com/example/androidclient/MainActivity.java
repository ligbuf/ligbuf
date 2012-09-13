package com.example.androidclient;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.example.gson.NewGson;
import com.example.gson.Student;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        
        Log.d("song","http://beautifulpromise2.appspot.com/jsonservlet");
        String serverUrl = "http://beautifulpromise2.appspot.com/jsonservlet";
        
        JSONParser jParser = new JSONParser();
        
        String json = null;
        
        try {
			json = jParser.executeHttpGet(serverUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Log.d("song","songsong : "+json);
     /*   
        NewGson gson = new NewGson();
        
        Student student = (Student) gson.fromJson(json, "Student"); 
        
        ArrayList<String> jsonList = new ArrayList<String>();
        
        jsonList.add("name : " + student.getName());
        jsonList.add(" age : " + student.getAge());
        jsonList.add(" isExistGirlFriend : " + student.isExistGirlFriend());
        jsonList.add(" current job : " + student.getCurrentjob());
        jsonList.add(" job : " + student.getJobs().get(0));
        jsonList.add(" job : " + student.getJobs().get(1));
        jsonList.add(" job : " + student.getJobs().get(2));
        
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, jsonList);
            setListAdapter(adapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
