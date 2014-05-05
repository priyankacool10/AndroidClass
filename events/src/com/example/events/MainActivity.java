package com.example.events;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;

import android.content.Intent;

public class MainActivity extends Activity {
	String TAG = "mainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void startActivity(View view) {
    	String btnName = ((Button)view).getText().toString();
    	Log.d(TAG, "I got: "+btnName);
    	if (btnName.equals("Tap me!")) {
    		EditText mEditText = (EditText)findViewById(R.id.txtExtra);
    		String data = mEditText.getText().toString();
    		Log.d(TAG, "Start the next activity here");
    		Intent mIntent = new Intent(this, secondActivity.class);
    		mIntent.putExtra("data", data);
    		startActivity(mIntent);
    	}
    	else {
    		Log.d(TAG, "Do nothing!");
    	}
    }
}
