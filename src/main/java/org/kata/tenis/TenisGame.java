package org.kata.tenis;

public class TenisGame {	 
	PrintScore printScore;
	
	Player playerA;
	Player playerB;
	
	public TenisGame(PrintScore printScore) {
		this.printScore = printScore;
		playerA = new Player("A");
		playerB = new Player("B");
	}


	public void displayScore(String s) {

		for (String ballWinner : s.split("")) {
			if (ballWinner.equalsIgnoreCase("A")) computeScore(playerA, playerB);
			if (ballWinner.equalsIgnoreCase("B")) computeScore(playerB, playerA);
		}

	}

	public void computeScore(Player ballWinner, Player oppenent) {
		ballWinner.scores();
		printScore.print(String.format("Player A : %s / Player B : %s", playerA.getTranslatedScore(), playerB.getTranslatedScore()));
	}
	
}
