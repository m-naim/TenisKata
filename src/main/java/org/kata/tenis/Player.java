package org.kata.tenis;


public class Player {
	int score;
	String name;

	public Player(String name) {
		super();
		this.score = 0;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void scores() {
		this.score+=1;
	}
	
	public String getTranslatedScore() {
		switch (score) {
		case 4:
			return "Adventage";
		case 3:
			return "40";
		case 2:
			return "30";
		case 1: 
			return "15";
		case 0:
			return "0";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}

	public void looseAdventage() {
		this.score-=1;
	}
}
