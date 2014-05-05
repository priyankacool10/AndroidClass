package com.example.forresult;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	SharedPreferences myPrefs;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }
    
    public void read(View view) {
    	if (myPrefs == null)
    		myPrefs = getSharedPreferences("mypreferences", Activity.MODE_PRIVATE);
    	
    	String userName = myPrefs.getString("username", null);
    	String password = myPrefs.getString("password", null);
    	if (userName != null && password != null) {
    		((EditText)findViewById(R.id.username)).setText(userName+" => "+password);
    	}
    }
    
    public void store(View view) {
    	if (myPrefs == null)
    		myPrefs = getSharedPreferences("mypreferences", Activity.MODE_PRIVATE);
    	
        SharedPreferences.Editor myEditor = myPrefs.edit();
        String userName = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.Password)).getText().toString();
        myEditor.putString("username", userName);
        myEditor.putString("password", password);
        myEditor.apply();
    }

}
