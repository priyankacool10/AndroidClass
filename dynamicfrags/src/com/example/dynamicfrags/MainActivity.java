package com.example.dynamicfrags;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.app.FragmentTransaction;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);        
    }
    
    public void onStart(View view) {
    	frag1 obj = new frag1();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.frame1, obj);
        ft.addToBackStack(null);
        ft.commit();
    }
    
    public void onReplace(View view) {
    	frag2 obj = new frag2();
    	FragmentTransaction ft = getFragmentManager().beginTransaction();
    	ft.add(R.id.frame2, obj);
    	ft.addToBackStack(null);
    	ft.commit();
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

}
