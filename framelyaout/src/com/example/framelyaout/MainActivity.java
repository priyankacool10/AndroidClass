package com.example.framelyaout;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Menu;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mylayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void myonclick(View view) {
		Log.d("MainActivity", "Handle onclick here");
	} 

}
