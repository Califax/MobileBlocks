package com.game.Units;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Block {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private int deltaX;
	private int deltaY;
	private int color;
	private RectF r;
	private Bitmap bitmap;
	private Paint paint;
	
	private Block(int x, int y, int width, int height, int deltaX, int deltaY)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public Block(int x, int y, int width, int height, int deltaX, int deltaY,
			int color) {
		
		this(x, y, width,height,deltaX,deltaY);
		this.color = color;
		this.paint = new Paint();
		paint.setColor(this.color);
	}
	
	
	public Block(int x, int y, int color) {
		this(x, y, 10, 10, 10, 10, color);
	}
	
	public Block(int x, int y, int width, int height, int deltaX, int deltaY,Bitmap b ) {
		this(x, y, width,height,deltaX,deltaY);
		this.bitmap = b;
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDeltaX() {
		return deltaX;
	}
	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}
	public int getDeltaY() {
		return deltaY;
	}
	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	public void update() {
		this.x += deltaX;
		this.y += deltaY;
	}
	
	public void draw(Canvas canvas) {
		if(bitmap != null)
			canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
		else
			canvas.drawRect(x, y, x+width, y+height,paint);
		
	}
	
	

}
