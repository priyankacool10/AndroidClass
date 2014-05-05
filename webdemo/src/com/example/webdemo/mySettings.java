package com.example.webdemo;
import android.net.Uri;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.content.Intent;
import android.content.Context;

public class mySettings extends WebViewClient {
	Context mContext;
	
	public mySettings(Context mContext) {
		this.mContext = mContext;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		if (Uri.parse(url).getHost().equals("www.xyz.com")) {
			return false;
		}
		Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		mContext.startActivity(myIntent);
		return true;
	}
}
