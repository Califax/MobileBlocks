package com.game.mobileblocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.game.Units.Block;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private static final String TAG = GamePanel.class.getSimpleName();
	private GameThread thread; 
	private List<Block> blockList = new ArrayList<Block>();
	private final int TOTAL_BLOCKS = 10;
	private int height, width;
	
	public GamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// create blocks and load bitmap
	
		// create the game loop thread
		thread = new GameThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
		this.height = this.width = 10;
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
			if(blockList.size() < TOTAL_BLOCKS)
			{
				//TODO write random algorithm to determine color or bitmap
				int sizeTo = TOTAL_BLOCKS -blockList.size();
				Random r = new Random();
				for(int i = 0; i < sizeTo; i++)
				{
					int xRand = r.nextInt(this.height/2);
					int yRand = r.nextInt(this.width);
					blockList.add(new Block(xRand,yRand, 50,50,0,2,Color.CYAN));
				}
			}
			for (Block block : blockList) {
				block.update();
			}
		}
		
	}
	
	public boolean onTouchEvent(MotionEvent event)
	{
		boolean retVal = false;
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			synchronized (blockList) {
				for (Block block : blockList) {
					retVal = block.isCollision((int)event.getX(), (int)event.getY());
					if(retVal)
					{
						blockList.remove(block);
						break;
					}
				}
			}
		}
		return false;

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


	public void updateSize(int w, int h) {
		this.height = h;
		this.width  = w;
		
	}
}
