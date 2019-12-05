package io.github.mariazevedo88.hc.prepkit.sorting.model;

public class Player {
  	
	private String name;
	private int score;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + "," + this.score + "]";
	}
	
}
