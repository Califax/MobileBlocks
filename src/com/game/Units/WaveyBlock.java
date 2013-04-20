package com.game.Units;

import android.graphics.Bitmap;

public class WaveyBlock extends Block 
{
	
	private boolean isForward;
	private int count;
	public WaveyBlock(int x, int y, int width, int height, int deltaX,
			int deltaY, Bitmap b) {
		super(x, y, width, height, deltaX, deltaY, b);
		
		this.isForward = true;
		// TODO Auto-generated constructor stub
	}
	
	public WaveyBlock(int x, int y, int width, int height, int deltaX,
			int deltaY, int color) {
		super(x, y, width, height, deltaX, deltaY, color);
		// TODO Auto-generated constructor stub
		this.isForward = true;
	}
	
	@Override
	public void update(long delta) {
		
		this.y += (delta * deltaY) / 1000;
		if(isForward)
		{
			this.x += (delta * deltaX) / 1000;
			count++;
			if(count == 10) isForward = false;
		}
		else
		{
			this.x -= (delta * deltaX) / 1000;
			count--;
			if(count == 0) isForward = true;
		}
	}
	
}
