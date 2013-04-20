package com.game.Units;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;

import com.game.mobileblocks.GamePanel;

public class Bins {
	List<Bin> bins;
	Bin blueBin = new Bin(0, GamePanel.height-5, (GamePanel.width / 3) - 10, 5, 0, 0, Color.BLUE);
	Bin redBin = new Bin(blueBin.getX() + blueBin.getWidth()+20, GamePanel.height-5, (GamePanel.width / 3) - 10, 5, 0, 0, Color.RED);
	Bin greenBin = new Bin(redBin.getX() + redBin.getWidth()+20, GamePanel.height-5, (GamePanel.width / 3) - 10, 5, 0, 0, Color.GREEN);
	
	public Bins() {
		bins = new ArrayList<Bin>();
		bins.add(blueBin);
		bins.add(redBin);
		bins.add(greenBin);
	}
	
	public List<Bin> getBins() {
		return bins;
	}
	public void drawBins(Canvas canvas) {
		for (Bin bin: bins) {
			bin.draw(canvas);
		}
	}
	public int collisionCheck(Block currBlock) {
		for (Bin b : bins) {
			if (currBlock.isCollisionBlock(b.getX(), b.getY(), b.getWidth(), b.getHeight())) {
				return b.getColor();
			}
		}
		return -1;
	}
	 
	
}
