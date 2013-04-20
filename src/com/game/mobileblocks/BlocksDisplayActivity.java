package com.game.mobileblocks;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class BlocksDisplayActivity extends Activity {
	//DrawView drawView;
	
	    /*@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        drawView = new DrawView(this);
	        drawView.setBackgroundColor(Color.WHITE);
	        setContentView(drawView);

	    }*/
	    String TAG = "BlocksDisplayActivity";
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // requesting to turn the title OFF
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        // making it full screen
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        // set our MainGamePanel as the View
	        setContentView(new GamePanel(this));
	        Log.d(TAG, "View added");
	    }

		@Override
		protected void onDestroy() {
			Log.d(TAG, "Destroying...");
			super.onDestroy();
		}

		@Override
		protected void onStop() {
			Log.d(TAG, "Stopping...");
			super.onStop();
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blocks_display, menu);
		return true;
	}

}
