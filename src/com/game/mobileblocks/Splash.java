package com.game.mobileblocks;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	private MediaPlayer splash_sound;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
//		splash_sound = MediaPlayer.create(this,R.raw.startup);
//		splash_sound.start();
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(2000);
				} 
				catch(InterruptedException e) 
				{
					e.printStackTrace();
				}
				finally 
				{
					                                 
					Intent StartScreen = new Intent("com.game.mobileblocks.BlocksDisplayActivity");
					startActivity(StartScreen);
				}
			}
		};
		timer.start();

	}
	
	protected void onPause() {
		super.onPause();
		//splash_sound.release();
		finish();
	}


}