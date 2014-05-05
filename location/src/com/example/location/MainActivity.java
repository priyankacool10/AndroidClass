package com.example.location;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.Location;
import android.location.LocationListener;
import android.widget.TextView;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends Activity implements LocationListener {
	TextView txtLongitude, txtLatitude;
	LocationManager mLocationManager;
	Criteria mCriteria;
	String mProvider;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        txtLongitude = (TextView)findViewById(R.id.longitude);
        txtLatitude = (TextView)findViewById(R.id.latitude);
        LocationManager mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        boolean gpsEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (!gpsEnabled && !isNetworkEnabled) {
        	Intent settings = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        	startActivity(settings);
        }
        else {
        	mCriteria = new Criteria();
            mProvider = mLocationManager.getBestProvider(mCriteria, false);
            Log.d("TAG", mProvider);
            mLocationManager.requestLocationUpdates(mProvider, 400, 1, this);
            Location loc = mLocationManager.getLastKnownLocation(mProvider);
            if ( loc != null) {
            	onLocationChanged(loc);
            }
            else {
            	Log.d("TAG", "Unable to get location");
            }
        }
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	if (mLocationManager != null)
    		mLocationManager.requestLocationUpdates(mProvider, 400, 1, this);
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	if (mLocationManager != null) {
    		mLocationManager.removeUpdates(this);
    	}
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

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Log.d("myTag","lat: "+location.getLatitude());
		txtLongitude.setText(location.getLongitude()+"");
		txtLatitude.setText(location.getLatitude()+"");
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
