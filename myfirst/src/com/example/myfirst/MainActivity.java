package com.example.myfirst;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends Activity {
	static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"Activity loaded");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void click(View view){
    	
    	Log.d(TAG,"button has been clicked");
    	TextView mTextView = (TextView)findViewById(R.id.textView1);
    	EditText mEditText = (EditText)findViewById(R.id.editText1);
    	if(mEditText.getText().toString().length()==0)
    		{	Log.d(TAG,"string empty");
    			mTextView.setText("Please enter text in Edit Text");
    		}
    	else
    		mTextView.setText(mEditText.getText().toString());
    	
    }
}
