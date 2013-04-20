package com.game.Units;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class Bin extends Block {

	static final ArrayList<Bin> bins = new ArrayList<Bin>(4);
	public Bin(int x, int y, int width, int height, int deltaX,
			int deltaY, Bitmap b) {
		super(x, y, width, height, deltaX, deltaY, b);
		
		// TODO Auto-generated constructor stub
	}
	
	public Bin(int x, int y, int width, int height, int deltaX,
			int deltaY, int color) {
		super(x, y, width, height, deltaX, deltaY, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(long delta) { }
	
	private static void initList()
	{
		//bins.add(0,new Bin(color, color, color, color, color, color, bitmap))
	}
	
	
}
