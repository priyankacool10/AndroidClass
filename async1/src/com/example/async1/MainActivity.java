package com.example.async1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView)findViewById(R.id.output);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //This function is called when button is clicked.
    public void startTask(View view) {
    	myAsyncTask mTask = new myAsyncTask();
    	mTask.execute("abc","10","Hello world");
    }
    
    private class myAsyncTask extends AsyncTask<String, Integer, Void> {
    	String mTAG = "myAsyncTask";
    	
    	@Override
    	protected void onPreExecute() {
    		Log.d(mTAG, "Hello from onPreExecute");
    		output.setText("Hello from onPreExecute");
    	}
    	
    	@Override
    	protected Void doInBackground(String...arg) {
    		
    		//Added sleep so that you can see Hello from onPreExecute and after that Inside doInBackground clearly.
    		try{
    			Thread.sleep(5000);
    		}
    		catch(InterruptedException e)
    		{
    			
    			e.printStackTrace();
    		}
    		
    		Log.d(mTAG, "Just started doing stuff in background");
    		//New thread is created because this function can't update UI Thread.
    		runOnUiThread(new Thread() {
    			public void run() {
    				TextView output = (TextView) findViewById(R.id.output);
    				output.setText("Inside doInBackground");
    			}
    		});
    		
    		//Showing arguments passed to it by execute() method.
    		Log.d(mTAG, "I got "+arg.length+" arguments and they are: ");
    		for (int i = 0 ; i < arg.length ; i++ ) {
    			Log.d(mTAG, (i+1)+" => "+arg[i]);
    		}
    		
    		//Continuous BackGround Work
    		for(int i=0;i<10;i++){
    		try {
    			Thread.sleep(5000);
    		}
    		catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		publishProgress(i+1); // It calls onProgressUpdate Method.
    		}
    		
    		return null;
    	}
    	
    	//@Override
    	protected void onProgressUpdate(Integer ... a){
    			Log.d(mTAG,"Progress is "+a[0]+" % done.");
    			output.setText(a[0]+"% done");
    		
    	}
    	
    	@Override
    	protected void onPostExecute(Void a) {
    		Log.d(mTAG, "Inside onPostExecute");
    		output.setText("Work Done!");
    	}
    }
    
}
