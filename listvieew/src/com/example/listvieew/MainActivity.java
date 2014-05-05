package com.example.listvieew;

import android.os.Bundle;
import android.app.Activity;
//import android.view.ContextMenu;
//import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.AdapterView;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
	String TAG = "MainActivity";
	myAdapter productAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView)findViewById(R.id.listView1);
        productAdapter = new myAdapter(this);
        mListView.setAdapter(productAdapter);
        registerForContextMenu(mListView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /*
    @Override
    public void onCreateContextMenu(ContextMenu cMenu, View view, ContextMenuInfo item){
    	MenuInflater mInflater =getMenuInflater();
    	mInflater.inflate(R.menu.row_menu,cMenu);
    }
   
    @Override
    public boolean onContextItemSelected(MenuItem mItem){
    	int mItemId=mItem.getItemId();
    	switch(mItemId){
    	case R.id.option1:{
    		 Intent myintent =new Intent(this,spinner_activity.class);	
    	        startActivity(myintent);
    	        return true;
    	}
    		
    	}
    	return super.onContextItemSelected(mItem);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mItem){
    	int mId=mItem.getItemId();
    	switch(mId){
    		case R.id.action_proceed:{
    			Intent mIntent = new Intent(this,spinner_activity.class);
    			startActivity(mIntent);
    			return true;
    		}
    		
    	}
    	return super.onOptionsItemSelected(mItem);
    }
    */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View listRow, int position, long Id) {
    	Log.d(TAG, "Item #"+position+" has been tapped");
        Intent myintent =new Intent(this,spinner_activity.class);	
        startActivity(myintent);
    }
    
    private class myAdapter extends BaseAdapter{
    	Context mContext;
    	TreeMap<String, String> myMap;
    	LayoutInflater mInflater;
    	List<String> mList;
    	
    	public myAdapter(Context myContext) {
    		mContext = myContext;
    		myMap = new TreeMap<String, String>();
    		myMap.put("product1", "1");
    		myMap.put("product2", "434");
    		myMap.put("product3", "56");
    		myMap.put("product4", "1235");
    		myMap.put("product5", "1234");
    		myMap.put("product6", "1423");
    		myMap.put("product7", "1566");
    		myMap.put("product8", "1656");
    		myMap.put("product9", "1545");
    		myMap.put("product10", "134");
    		myMap.put("product11", "1423");
    		myMap.put("product12", "1566");
    		myMap.put("product13", "1656");
    		myMap.put("product14", "1545");
    		myMap.put("product15", "134");
    		myMap.put("product16", "1423");
    		myMap.put("product17", "1566");
    		myMap.put("product18", "1656");
    		myMap.put("product19", "1545");
    		myMap.put("product20", "134");
    		myMap.put("product21", "1423");
    		myMap.put("product22", "1566");
    		myMap.put("product23", "1656");
    		myMap.put("product24", "1545");
    		myMap.put("product25", "134");
    		myMap.put("product26", "1423");
    		myMap.put("product27", "1566");
    		myMap.put("product28", "1656");
    		myMap.put("product29", "1545");
    		myMap.put("product30", "134");
    		mList = new LinkedList<String>(myMap.keySet());
    		mInflater = ((Activity)mContext).getLayoutInflater();
    	}
    	
    	@Override
    	public int getCount() {
    		return myMap.size();
    	}
    	
    	@Override
    	public View getView(int position, View mView, ViewGroup mGroup){
    		myHolder holder1 = null;
    		if (mView == null) {
    			Log.d("My Adapter","new Row");
    			mView = mInflater.inflate(R.layout.layout_row_list, mGroup, false);
    			holder1 = new myHolder();
    			holder1.costText = (TextView)mView.findViewById(R.id.productPrice);
    			holder1.productText = (TextView)mView.findViewById(R.id.productLabel);
    			mView.setTag(holder1);
    		}
    		else {
    			holder1 = (myHolder)mView.getTag();
    		}
    		Log.d("myadapter","Showing row# "+position);
    		String tempKey = mList.get(position);
    		String value = myMap.get(tempKey);
    		holder1.costText.setText(value);
    		holder1.productText.setText(tempKey);
    		return mView;
    	}
    	
    	@Override
    	public long getItemId(int id) {
    		return id;
    	}
    	
    	@Override
    	public Object getItem(int id) {
    		return null;
    	}
    }
    
    private class myHolder {
    	public TextView productText;
    	public TextView costText;
    }
    
}
