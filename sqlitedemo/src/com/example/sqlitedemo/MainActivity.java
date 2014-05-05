package com.example.sqlitedemo;

import android.app.Activity;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends Activity {
	
	myhelper sqlHelper = new myhelper(this, myhelper.tab1, null, myhelper.database_version);
	String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
    }
    
    public void onInsert(View view) {
    	String name = ((EditText)findViewById(R.id.name)).getText().toString();
    	String rollno = ((EditText)findViewById(R.id.rollNo)).getText().toString();
    	
 
    	SQLiteDatabase myDb = sqlHelper.getWritableDatabase();
    	ContentValues content = new ContentValues();
    	content.put(myhelper.name, name);
    	content.put(myhelper.rollno, Integer.parseInt(rollno));
    	myDb.insert(myhelper.tab1, null, content);
    }
    
    
    public void onRead(View view) {
    	SQLiteDatabase myDb = sqlHelper.getReadableDatabase();
    	String rollno = ((EditText)findViewById(R.id.rollNo)).getText().toString();
    	
    	Cursor myCursor = myDb.rawQuery("SELECT * FROM "+myhelper.tab1+" WHERE "+myhelper.rollno+"="+rollno, null);
    	if ( myCursor != null ) {
    		myCursor.moveToFirst();
    		do {
    			Log.d(TAG, myCursor.getInt(0)+", "+myCursor.getString(1)+", "+myCursor.getInt(2));
    		}while(myCursor.moveToNext());
    	}
    }
    
    public void onUpdate(View view) {
    	SQLiteDatabase myDb = sqlHelper.getWritableDatabase();
    	String rollno = ((EditText)findViewById(R.id.rollNo)).getText().toString();
    	String name = ((EditText)findViewById(R.id.name)).getText().toString();
    	if (rollno.length()>0 && name.length() > 0) {
    		ContentValues newRow = new ContentValues();
    		newRow.put(myhelper.name, name);
    		int num = myDb.update(myhelper.tab1, newRow, myhelper.rollno+"="+rollno, null);
    		Log.d(TAG, "number of rows affected: "+num+" for rollno: "+rollno);
    	}
    }
    
    public void onDelete(View view) {
    	SQLiteDatabase myDb = sqlHelper.getWritableDatabase();
    	String rollno = ((EditText)findViewById(R.id.rollNo)).getText().toString();
    	if (rollno.length()>0) {
    		
    		int num = myDb.delete(myhelper.tab1, myhelper.rollno+"="+rollno, null);
    		Log.d(TAG,"Number of rows affected: "+num+" for rollno: "+rollno);
    	}
    }

}
