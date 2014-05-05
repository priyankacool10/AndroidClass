package com.example.myparcel;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.content.Intent;

public class reciever extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_reciever);
		TextView txtInt = (TextView)findViewById(R.id.txtInt);
		TextView txtFloat = (TextView)findViewById(R.id.txtFloat);
		TextView txtStr = (TextView)findViewById(R.id.txtStr);
		
		Intent myIntent = getIntent();
		myparcel mParcel = myIntent.getParcelableExtra("myparcel");
		data obj = mParcel.getObject();
		
		txtInt.setText(""+obj.getInt());
		txtFloat.setText(""+obj.getFloat());
		txtStr.setText(obj.getStr());
	}
}
