package com.example.restoreinstance;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.view.View;
import android.util.Log;
import android.app.FragmentTransaction;

public class mainActivity extends Activity {
	
	myfragment mFrag;
	String TAG = "mainActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_main);
		Spinner mSpinner = (Spinner)findViewById(R.id.mSpinner);
		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[] {"abc","def","ghi","jkl"});
		mSpinner.setAdapter(mAdapter);
		
		mFrag = (myfragment)getFragmentManager().findFragmentByTag("myFrag");
		
		
		if (mFrag == null ) {
			mFrag = new myfragment();
			FragmentTransaction mTransaction = getFragmentManager().beginTransaction();
			mTransaction.add(R.id.fragFrame, mFrag, "myFrag");
			mTransaction.addToBackStack(null);
			mTransaction.commit();
		}
		else {
			mFrag.restoreData();
		}
		
		if (savedInstanceState != null) {
			String mStr = savedInstanceState.getString("output");
			int position = savedInstanceState.getInt("spinnerPosition");
			EditText mEditText = (EditText)findViewById(R.id.input);
			mEditText.setText(mStr);
			mSpinner.setSelection(position);
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedState) {
		super.onSaveInstanceState(savedState);
		EditText mEditText = (EditText)findViewById(R.id.input);
		String mStr = mEditText.getText().toString();
		Spinner mSpinner = (Spinner)findViewById(R.id.mSpinner);
		savedState.putString("output", mStr);
		savedState.putInt("spinnerPosition", mSpinner.getSelectedItemPosition());
		if (mFrag != null )
			mFrag.saveData();
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedState) {
		super.onRestoreInstanceState(savedState);
	}
	
	public void printFragment(View view) {
		Log.d(TAG, "Text: "+((EditText)findViewById(R.id.fragInput)).getText());
	}

}
