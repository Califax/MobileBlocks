package com.game.Units;

public class BlockContainer {
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	
	public BlockContainer(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}	
	
	public BlockContainer(int x, int y, int width, int height, int color) {
		this(x, y, width, height);
		this.color = color;
	}
	
	
}
