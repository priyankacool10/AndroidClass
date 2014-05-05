package com.example.notifications;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.app.NotificationManager;

public class resultActivity extends Activity {

	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_layout);
		TextView output = (TextView)findViewById(R.id.output);
		Intent myIntent = getIntent();
		int myNotificationId = myIntent.getIntExtra("myNotificationId", -1);
		if (myNotificationId != -1)
		{
			NotificationManager myManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			myManager.cancel(myNotificationId);
		}
		output.setText("Data sent by first activity: "+myIntent.getIntExtra("AnyValue", -1));
		
	}
	
}
