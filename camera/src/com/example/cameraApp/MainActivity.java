package com.example.cameraApp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.os.Build;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.net.Uri;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.util.Log;

public class MainActivity extends Activity {

	int mRequestCode = 12;
	String mFileName;
	
	private File getImageFile() throws IOException {
		File imageFile = null;
		
		File externalDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		if (externalDir != null) {
			String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			fileName += "_IMG";
			Log.d("myTag", externalDir.getAbsolutePath()+"/"+fileName);
			imageFile = File.createTempFile(fileName, ".jpg", externalDir);
			Log.d("myTAg", imageFile.getAbsolutePath());
			this.mFileName = "file:"+imageFile.getAbsolutePath();
		}
		
		return imageFile;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
    }
    
    public void onStart(View view) {
    	Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	if (camIntent.resolveActivity(getPackageManager())!=null)  {
    		try {
    			File imageFile = getImageFile();
    			Uri imgUri = Uri.fromFile(imageFile);
    			camIntent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
    			this.startActivityForResult(camIntent, mRequestCode);
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    	}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent content) {
    	if (requestCode == mRequestCode && resultCode == this.RESULT_OK){   	
    		Bundle extras = content.getExtras();
    		Bitmap mBitmap = (Bitmap) extras.get("data");
    		ImageView mImage = (ImageView)findViewById(R.id.thumbnail);
    		mImage.setImageBitmap(mBitmap);
    		startScanner();
    	}
    }
    
    private void startScanner() {
    	Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    	File f = new File(mFileName);
    	Uri fileUri = Uri.fromFile(f);
    	scanIntent.setData(fileUri);
    	this.sendBroadcast(scanIntent);
    }
}
