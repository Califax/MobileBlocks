package com.game.mobileblocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.game.Units.Block;
import com.game.Units.BouncyBlock;
import com.game.Units.WaveyBlock;

public class Level {

	private int maxSpeed;
	private int minSpeed;
	private int maxBlocksPerRow;
	private int blockGenSpeed;
	private int gameWidth;
	private int creationSpeed;
	
	private List<Block> blockList;
	private Random rand;
	private ColorPicker colorPicker = new ColorPicker();
	private int blockWidth = 50;
	private int blockHeight = 50;
	
	public Level(int gameWidth) {
		this(5, 1, 3, 5, gameWidth);
	}
	
	public Level(int maxSpeed, int minSpeed, int maxBlocksPerRow,
			int blockGenSpeed, int gameWidth) {
		this.maxSpeed = maxSpeed;
		this.minSpeed = minSpeed;
		this.maxBlocksPerRow = maxBlocksPerRow;
		this.blockGenSpeed = blockGenSpeed;
		this.gameWidth = gameWidth;
		this.creationSpeed = 500;
	}
	
	public int getCreationSpeed()
	{
		return creationSpeed;
	}
	
	public List<Block> randomBlocks() {
		rand = new Random();
		Block currBlock;
		
		blockList = new ArrayList<Block>();
		for (int i = 0; i < rand.nextInt(maxBlocksPerRow); i++) {
			int r = rand.nextInt(3);
			if( r == 1)
				currBlock = new Block(rand.nextInt(gameWidth - blockWidth),0, colorPicker.randomColor());
			else if(r == 2)
				currBlock = new BouncyBlock(rand.nextInt(gameWidth - blockWidth),rand.nextInt(5), 50, 50,2,3,colorPicker.randomColor());
			else
				currBlock = new WaveyBlock(rand.nextInt(gameWidth - blockWidth),rand.nextInt(5), 50, 50,2,3,colorPicker.randomColor());
			//currBlock = new Block(rand.nextInt(gameWidth - blockWidth),rand.nextInt(5), 50, 50,2,3,GamePanel.pics.get(0));
			while (collisionCheck(currBlock, blockList)) {
				currBlock = new Block(rand.nextInt(gameWidth - blockWidth),rand.nextInt(5),colorPicker.randomColor());
				//currBlock = new Block(rand.nextInt(gameWidth - blockWidth),rand.nextInt(5), 50, 50,2,3,GamePanel.pics.get(0));

			}
			blockList.add(currBlock);
		}
		return blockList;
	}
	
	public boolean collisionCheck(Block currBlock, List<Block> blockList) {
		for (Block b : blockList) {
			if (currBlock.isCollisionBlock(b.getX(), b.getY(), b.getWidth(), b.getHeight())) {
				return true;
			}
		}
		return false;
	}

	public void update(int score) {
		if (score % 5 == 0) {
			maxSpeed++;
			if(creationSpeed > 100) creationSpeed -=10;
		}
		if (score % 10 == 0) {
			minSpeed++;
		}
		if (score % 10 == 0) {
			blockGenSpeed++;
			maxBlocksPerRow++;
		}
	}
	
	
}
