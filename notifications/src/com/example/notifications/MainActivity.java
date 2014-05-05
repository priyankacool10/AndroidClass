package com.example.notifications;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends Activity {
	
	Intent serviceIntent;
	myService serviceInstance;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        
        
    }

    public void onShow(View view) {
    	NotificationCompat.Builder myNotificationBuilder = new NotificationCompat.Builder(this);
    	myNotificationBuilder.setSmallIcon(R.drawable.ic_launcher);
    	myNotificationBuilder.setContentTitle("First Notification");
    	myNotificationBuilder.setContentText("This is a test notification");
    	int notificationid = 3452;
    	
    	Intent myIntent = new Intent(this, resultActivity.class);
    	myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	myIntent.putExtra("AnyValue", 12345);
    	myIntent.putExtra("myNotificationId", notificationid);
    	PendingIntent myPendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    	
    	myNotificationBuilder.setContentIntent(myPendingIntent);
    	
    	
    	NotificationManager myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	myManager.notify(notificationid, myNotificationBuilder.build());
    }
    
    public void onServiceStart(View view) {
    	serviceIntent = new Intent(this, myService.class);
        startService(serviceIntent);
        bindService(serviceIntent, mConnection, BIND_AUTO_CREATE);
    }
    
    public void onStopService(View view) {
    	
    	unbindService(mConnection);
    	stopService(serviceIntent);
    }
    
    public void onShowOutput(View view) 
    {
    	TextView output = (TextView)findViewById(R.id.output);
    	if (serviceInstance == null)
    	{
    		output.setText("Not connected to service yet");
    	}
    	else
    	{
    		output.setText(serviceInstance.getData());
    	}
    }
    
    private ServiceConnection mConnection = new ServiceConnection() {
    	
    	@Override
    	public void onServiceConnected(ComponentName className, IBinder binder)
    	{
    		myService.myBinder temp = (myService.myBinder) binder;
    		serviceInstance = temp.getService();
    	}
    	
    	@Override
    	public void onServiceDisconnected(ComponentName className) 
    	{
    		Log.d("mytag", "Disconnecting");
    		serviceInstance = null;
    	}
    };

}