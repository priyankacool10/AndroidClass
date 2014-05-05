package com.example.webdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView myWebview = (WebView)findViewById(R.id.mWebView);
		myWebview.loadUrl("http://www.google.com");
		WebSettings webSettings = myWebview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		mySettings settings2 = new mySettings(this);
		myWebview.setWebViewClient(settings2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
