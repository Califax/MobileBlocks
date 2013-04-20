package com.game.Units;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class Bin extends Block {

	public Bin(int x, int y, int width, int height, int deltaX,
			int deltaY, Bitmap b) {
		super(x, y, width, height, deltaX, deltaY, b);
	}
	
	public Bin(int x, int y, int width, int height, int deltaX,
			int deltaY, int color) {
		super(x, y, width, height, deltaX, deltaY, color);
	}
	
	@Override
	public void update(long delta) { }
	
	
	
	
}
