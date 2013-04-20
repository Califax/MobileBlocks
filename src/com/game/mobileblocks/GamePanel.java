package com.game.mobileblocks;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.game.Units.Block;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private static final String TAG = GamePanel.class.getSimpleName();
	private GameThread thread; 
	private List<Block> blockList = new ArrayList<Block>();
	
	public GamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// create blocks and load bitmap
	
		// create the game loop thread
		thread = new GameThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
		blockList.add(new Block(10, 10, 50,50,20,20,Color.CYAN));
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
		synchronized (blockList) {
			for (Block block : blockList) {
				block.update();
			}
		}
		
	}
	
	public void render(Canvas canvas)
	{
		canvas.drawColor(Color.BLUE);
		synchronized (blockList) {
			for (Block block : blockList) {
				block.draw(canvas);
			}
		}
	}
}
