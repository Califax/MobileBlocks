package com.game.mobileblocks;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import android.graphics.Color;

public class ColorPicker {
	Random rand;
	int[] colorArr = {Color.GREEN, Color.BLUE, Color.RED};
	
	public int randomColor() {
		rand = new Random();
		return (colorArr[rand.nextInt(colorArr.length)]);
	}
}
