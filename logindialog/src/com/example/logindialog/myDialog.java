package com.example.logindialog;

import android.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class myDialog extends DialogFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstnaceState) {
		View v = inflater.inflate(R.layout.dialog_layout, group, false);
		Button btnOk = (Button)v.findViewById(R.id.okButton);
		btnOk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myDialog.this.dismiss();
			}
		});
		return v;
	}
}
