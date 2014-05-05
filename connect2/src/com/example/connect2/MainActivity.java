package com.example.connect2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ((Button)findViewById(R.id.button1)).setVisibility(View.GONE);
    }
    
    public void onConnect(View view) {
    	new Thread(){
    		public void run(){
    			HttpClient myClient = new DefaultHttpClient();
    	    	HttpPost post = new HttpPost("http://192.168.0.128/login.php");
    	    	try {
    	    		List<NameValuePair> myArgs = new ArrayList<NameValuePair>();
    	    		myArgs.add(new BasicNameValuePair("username", "priyanka"));
    	    		myArgs.add(new BasicNameValuePair("password", "pk"));
    	    		post.setEntity(new UrlEncodedFormEntity(myArgs));
    	    		HttpResponse myResponse = myClient.execute(post);
    	    		BufferedReader br = new BufferedReader( new InputStreamReader(myResponse.getEntity().getContent()));
    	    		String line = "";
    	    		while ((line = br.readLine()) != null)
    	    		{
    	    			Log.d("mytag", line);
    	    			if (line.equals("MySql Connection Established You r logged in"))
    	    			{
    	    				
    	    			}
    	    			else 
    	    			{
    	    				
    	    			}
    	    		}
    	    	}
    	    	catch (IOException e) {
    	    		e.printStackTrace();
    	    	}
    		}
    	}.start();;
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
  

}
