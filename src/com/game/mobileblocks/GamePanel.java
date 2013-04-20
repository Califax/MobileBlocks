package com.game.mobileblocks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private static final String TAG = GamePanel.class.getSimpleName();
	private GameThread thread; 

	public GamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// create blocks and load bitmap
	
		// create the game loop thread
		thread = new GameThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		// TODO Auto-generated method stub
		thread.setRunning(true);
		thread.start();
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		try {
			thread.join();
		} catch (InterruptedException e) {
			// try again shutting down the thread
		}
		
	}
	
	public void update() 
	{

	}
	
	public void render(Canvas canvas)
	{
		canvas.drawColor(Color.BLUE);
		//TODO make draw commands for each object
		//.draw(canvas);
	}
}
