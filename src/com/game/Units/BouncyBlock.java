package com.game.Units;

import java.util.Random;

import com.game.mobileblocks.GamePanel;

import android.graphics.Bitmap;

public class BouncyBlock extends Block 
{
	
	private boolean isLeft;
	private int count;
	Random r = new Random();
	public BouncyBlock(int x, int y, int width, int height, int deltaX,
			int deltaY, Bitmap b) {
		super(x, y, width, height, deltaX, deltaY, b);
		this.isLeft = r.nextBoolean();
		// TODO Auto-generated constructor stub
	}
	
	public BouncyBlock(int x, int y, int width, int height, int deltaX,
			int deltaY, int color) {
		super(x, y, width, height, deltaX, deltaY, color);
		// TODO Auto-generated constructor stub
		this.isLeft = r.nextBoolean();
	}
	
	@Override
	public void update(long delta) 
	{
		if(isLeft)
		{
			this.x -= (delta * deltaX) / 1000;
			if(x <= 0)
			{
				isLeft = false;
			}
		}
		else
		{
			this.x += (delta * deltaX) / 1000;
			if(x+width > GamePanel.width-1)
				isLeft = true;
		}
		if(y+height < GamePanel.height-1)
		this.y += (delta * deltaY) / 1000;

	}
	
}
