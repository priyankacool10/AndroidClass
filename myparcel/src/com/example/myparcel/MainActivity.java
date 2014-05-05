package com.example.myparcel;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void sendData(View view) {
    	data myObj = new data(12, 45.4f, "Hello from first activity");
    	myparcel mParcel = new myparcel(myObj);
    	Intent mIntent = new Intent(this, reciever.class);
    	mIntent.putExtra("myparcel", mParcel);
    	startActivity(mIntent);
    }
    
}
