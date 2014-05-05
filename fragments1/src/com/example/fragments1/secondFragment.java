package com.example.fragments1;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;

public class secondFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInsanceState) {
		View mView = inflater.inflate(R.layout.fraglayout2, group, false);
		return mView;
	}

}
