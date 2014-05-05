package com.example.progress;

import android.app.Activity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.Handler;
import android.view.View;
import android.util.Log;

import android.widget.Button;

public class MainActivity extends Activity {

	ProgressDialog mProgressDialog;
	int iProgress;
	int mProgress=0;
	Handler progressHandler;
	String TAG = "MainActivity";
	Button mbutton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton = (Button)findViewById(R.id.button1);
    }
    
    public void startDialog(View view) {
    	mProgressDialog = new ProgressDialog(view.getContext());
    	mProgressDialog.setCancelable(true);
    	mProgressDialog.setTitle("Loading");
    	mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    	mProgressDialog.setMax(100);
    	mProgressDialog.setProgress(0);
    	mProgressDialog.show();
    	iProgress = 0;
    	progressHandler = new Handler();
    	new Thread(new Runnable() {
    		public void run() {
    			while (true) {
    				iProgress = getProgress();
        			try {
        				Thread.sleep(700);
        			}
        			catch (InterruptedException e) {
        				e.printStackTrace();
        			}
        			mProgressDialog.setProgress(iProgress);
        			
        			progressHandler.post(new Runnable() {
        				public void run() {
        					mbutton.setText("running");
        				}
        			});
        			Log.d(TAG, "Progress is at: "+iProgress);
        			if (iProgress == 100) {
        				mProgressDialog.dismiss();
        				iProgress = 0;
        				mProgress = 0;
        				break;
        			}
    			}	
    		}
    	}).start();
    }
    
    private int getProgress() {
    	
    	while (mProgress < 1000) {
    		Log.d(TAG, "Mprogress is: "+mProgress);
    		mProgress++;
    		if (mProgress == 200) {
    			return 10;
    		}
    		else if (mProgress == 300) {
    			return 20;
    		}
    		else if (mProgress == 400 ) {
    			return 30;
    		}
    		else if (mProgress == 500 ) {
    			return 50;
    		}
    		else if (mProgress == 600) {
    			return 60;
    		}
    		else if (mProgress == 700) {
    			return 70;
    		}
    		else if (mProgress == 800 ) {
    			return 80;
    		}
    		else if (mProgress == 900) {
    			return 90;
    		}
    		
    		
    	}
    	return 100;
    }

   
    
}
