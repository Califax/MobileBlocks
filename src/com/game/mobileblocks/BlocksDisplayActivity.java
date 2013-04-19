package com.game.mobileblocks;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class BlocksDisplayActivity extends Activity {
	DrawView drawView;
	
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        drawView = new DrawView(this);
	        drawView.setBackgroundColor(Color.WHITE);
	        setContentView(drawView);

	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.blocks_display, menu);
		return true;
	}

}
