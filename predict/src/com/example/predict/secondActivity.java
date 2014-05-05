package com.example.predict;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class secondActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondlayout);
		Intent myIntent = getIntent();
		if (myIntent.hasExtra("myExtra")){
			TextView mText = (TextView)findViewById(R.id.textview2);
			mText.setText(myIntent.getStringExtra("myExtra"));
		}
	}
}
