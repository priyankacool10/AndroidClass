package com.example.jsonparse;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class MainActivity extends Activity {
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * 
	 * {
	 * 		"students":[
	 * 		{
	 * 			"name":"abc",
	 * 			"class":"xyz",
	 * 			"contact":{
	 * 				"email":"xyz@live.com",
	 * 				"phone":"1234567"
	 * 			}
	 * 		},
	 * 		{
	 * 			"name":"other student",
	 * 			"class":"other class",
	 * 			"contact":{
	 * 				"email":"abc@gmail.com",
	 * 				"phone":"456789"
	 * 			}
	 * 		}
	 * 		]
	 * }
	 * 
	 * 
	 */
	
	String jsonData = "{\"students\":[{	\"name\":\"abc\",\"class\":\"xyz\",\"contact\":{\"email\":\"xyz@live.com\",\"phone\":\"1234567\"}},{\"name\":\"other student\",\"class\":\"other class\",\"contact\":{\"email\":\"abc@gmail.com\",\"phone\":\"456789\"}}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void onParseClick(View view)
    {
    	JSONObject json = null;
    	String TAG = "jsonParse";
    	try {
    		json = new JSONObject(jsonData);
    		JSONArray myArray = json.getJSONArray("students");
    		for (int i = 0 ; i < myArray.length() ; i++)
    		{
    			JSONObject myObj = myArray.getJSONObject(i);
    			String name = myObj.getString("name");
    			Log.d(TAG, "Name: "+name);
    			String myclass = myObj.getString("class");
    			Log.d(TAG, "Class: "+myclass);
    			JSONObject contactDetails = myObj.getJSONObject("contact");
    			String email = contactDetails.getString("email");
    			Log.d(TAG, "Email: "+email);
    			int phone = contactDetails.getInt("phone");
    			Log.d(TAG,"Phone: "+phone);
    		}
    	}
    	catch(JSONException e)
    	{
    		e.printStackTrace();
    		return;
    	}
    	
    	
    }
}
