package com.example.fragments1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.util.Log;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;

public class firstfragment extends Fragment {
	
	public interface ifacedatasend {
		public void onDataRecieve(String data);
	}
	
	ifacedatasend mInstance;
	EditText source;
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup mGroup, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.fraglayout1, mGroup, false);
		source = (EditText)mView.findViewById(R.id.textSource);
		Button mButton = (Button)mView.findViewById(R.id.button1);
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mInstance.onDataRecieve(source.getText().toString()); 
			}
		});
		Log.d("frag1","Ui Inflated");
		return mView;
	}
	
	@Override
	public void onAttach(Activity container) {
		super.onAttach(container);
		if (container instanceof ifacedatasend){
			mInstance = (ifacedatasend) container;
		}
		else {
			throw new ClassCastException(" - Activity does not implement the interface");
		}
	}
}
