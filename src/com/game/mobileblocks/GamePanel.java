package com.game.mobileblocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.game.Units.Bins;
import com.game.Units.Block;
import com.game.Units.WaveyBlock;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private static final String TAG = GamePanel.class.getSimpleName();
	private GameThread thread; 
	private List<Block> blockList = new ArrayList<Block>();
	private final int TOTAL_BLOCKS = 10;
	public static int height, width;
	private long last;
	private ColorPicker colorPicker = new  ColorPicker();
	private Player player;
	private Level level;
	private Bins bins;
	private final String score = "Score: ";
	private final String lives = "Lives: ";
	private String score_plus = "";
	private String lives_plus = "";
	private Paint p;
	private final int paintSize = 40;
	
	public GamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// create blocks and load bitmap
		// create the game loop thread
		thread = new GameThread(getHolder(), this);

		// make the GamePanel focusable so it can handle events
		setFocusable(true);
		
		p = new Paint();
		p.setColor(Color.CYAN);
		p.setTextSize(paintSize);
		player = new Player(0,3);
	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

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

	public void update() {
		if (player.getLives() <= 0) {
			// TODO: Defeat screen
		}
		synchronized (blockList) {
			if (System.currentTimeMillis() - last > 1000) {
				if(blockList.size() < TOTAL_BLOCKS)
				{
					genRandomBlocks();
				}
				last = System.currentTimeMillis();
			}
			List<Block> blocksToRemove = new ArrayList<Block>();
			for (Block block : blockList) {
				block.update(2000);
				
				if (block.getY() + block.getHeight() > height - 6) {
					if (bins.collisionCheck(block) == block.getColor()) {
						player.incScore(); 
					}
					else {
						player.decLives();
					}
					blocksToRemove.add(block);
				}
			}
			for (Block block : blocksToRemove) {
				blockList.remove(block);
			}
		}

	}
	
	public void genRandomBlocks() {
		for (Block block : level.randomBlocks()) {
			this.blockList.add(block);
		}
	}
	
	public boolean onTouchEvent(MotionEvent event)
	{
		boolean retVal = false;
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			synchronized (blockList) {
				for (Block block : blockList) {
//					retVal = block.isCollision((int)event.getX(), (int)event.getY());
					retVal = block.isCollisionBlock((int)event.getX(), (int)event.getY(), 20, 20);
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
		canvas.drawColor(Color.BLACK);
		score_plus = score + player.getScore();
		lives_plus = lives + player.getLives();
		canvas.drawText(score_plus, 0,paintSize, p);
		canvas.drawText(lives_plus, 3*width/4,paintSize, p);
		synchronized (blockList) {
			for (Block block : blockList) {
				block.draw(canvas);
			}
		}
		bins.drawBins(canvas);
	}


	public void updateSize(int w, int h) {
		this.height = h;
		this.width  = w;
		level = new Level(width);
		bins = new Bins();
	}
	
}
