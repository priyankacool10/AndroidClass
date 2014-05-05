package com.example.predict;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.text.util.Linkify;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.textView1);
        Linkify.addLinks(tv, Linkify.ALL);
        AutoCompleteTextView mAutoView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1 ,new String[] {"delhi","delhi2","bangalore","mumbai","pune"});
        mAutoView.setAdapter(myAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void gotonext(View view) {
    	Intent secondIntent = new Intent(this, secondActivity.class);
    	secondIntent.putExtra("myExtra", "Hello from first activity");
    	startActivity(secondIntent);
    }
    
}
