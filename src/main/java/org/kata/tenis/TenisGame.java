package org.kata.tenis;

public class TenisGame {	 
	private static final int WINING_SCORE = 3;

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
		if(hasWonTheGame(ballWinner.getScore(),oppenent.getScore())) {
			printScore.print(String.format("Player %s wins the game", ballWinner.getName()));
		}
		else if(oppenentHasAdventage(ballWinner.getScore(),oppenent.getScore())){
			oppenent.looseAdventage();
			printScore.print(String.format("Player A : %s / Player B : %s", playerA.getTranslatedScore(), playerB.getTranslatedScore()));
		}
		else {
			ballWinner.scores();			
			printScore.print(String.format("Player A : %s / Player B : %s", playerA.getTranslatedScore(), playerB.getTranslatedScore()));
		}
	}


	private boolean hasWonTheGame(int winnerScore, int oppenentScore) {
		return (winnerScore>=WINING_SCORE && oppenentScore<WINING_SCORE) 
				|| (winnerScore>=WINING_SCORE && winnerScore>oppenentScore) ;
	}
	private boolean oppenentHasAdventage(int winnerScore, int oppenentScore) {
		return winnerScore>=WINING_SCORE && oppenentScore>winnerScore;
	}
	
}
