package com.example.connect;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        
    }
    
    public void onConnect(View view) {
    	HttpClient myClient = new DefaultHttpClient();
    	HttpPost post = new HttpPost("http://localhost/login.php");
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
    		}
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
