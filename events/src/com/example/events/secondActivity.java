package com.example.events;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class secondActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent mIntent = getIntent();
		TextView mTextOutput = (TextView)findViewById(R.id.output);
		mTextOutput.setText(mIntent.getStringExtra("data"));
	}
}
