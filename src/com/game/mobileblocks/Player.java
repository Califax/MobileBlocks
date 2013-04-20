package com.game.mobileblocks;

public class Player {
	
	private int score;
	private int lives;
	
	public int getScore() {
		return score;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}	
	public void incScore() {
		score++;
	}
	
	public void decLives() {
		lives--;
	}
	
	public Player(int score, int lives) {
		this.score = score;
		this.lives = lives;
	}
	
	
	
}
