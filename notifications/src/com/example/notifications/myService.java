package com.example.notifications;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.util.Log;


public class myService extends Service {
	String tag = "myService";
	int count;
	private myBinder thisBinder = new myBinder();
	private String myData;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return thisBinder;
	}
	
	@Override
	public int onStartCommand(Intent myIntent, int flags, int startId) {
		Log.d(tag, "Service has recieved onStartCommand");
		count++;
		new Thread() {
			public void run() {
				Log.d("serviceThread"+count,"Doing some long running task");
				try 
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				
				Log.d("serviceThread"+count,"Done");
			}
			
		}.start();
		myData = "hello world from service";
		return START_NOT_STICKY;
	}
	
	@Override
	public void onCreate(){
		Log.d(tag, "Service now in memory");
		super.onCreate();
	}
	
	@Override
	public void onDestroy(){
		Log.d(tag, "Service is going out of memory");
		super.onDestroy();
	}
	
	public String getData() {
		return myData;
	}
	
	public class myBinder extends Binder
	{
		
		public myService getService()
		{
			return myService.this;
		}
	}

}
