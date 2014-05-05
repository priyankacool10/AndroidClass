package com.example.restoreinstance;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

public class myfragment extends Fragment {
	myData myObj = new myData();
	EditText myInput;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.layout_fragment, group, false);
		myInput = (EditText)v.findViewById(R.id.fragInput);
		return v;
	}
	
	public void saveData() {
		myObj.myString = myInput.getText().toString();
	}
	
	public void restoreData() {
		myInput.setText(myObj.myString);
	}
	
	public class myData {
		public String myString;
	}
}
