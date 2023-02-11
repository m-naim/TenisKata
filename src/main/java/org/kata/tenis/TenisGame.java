package org.kata.tenis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


	public void displayScore(String input) {
		Pattern pattern = Pattern.compile("[A-B]*", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		if(!matcher.matches()) {
			throw new IllegalArgumentException("Illegal input: " + input);
		}
		String result="";
		for (String ballWinner : input.split("")) {
			if (ballWinner.equalsIgnoreCase("A")) result=computeScore(playerA, playerB);
			if (ballWinner.equalsIgnoreCase("B")) result=computeScore(playerB, playerA);
			printScore.print(result);
		}

	}

	public String computeScore(Player ballWinner, Player oppenent) {
		if(hasWonTheGame(ballWinner.getScore(),oppenent.getScore())) {
			return String.format("Player %s wins the game", ballWinner.getName());
		}
		else if(oppenentHasAdventage(ballWinner.getScore(),oppenent.getScore())){
			oppenent.looseAdventage();
		}
		else {
			ballWinner.scores();			
		}
		return String.format("Player A : %s / Player B : %s", playerA.getTranslatedScore(), playerB.getTranslatedScore());
	}

	private boolean hasWonTheGame(int winnerScore, int oppenentScore) {
		return (winnerScore>=WINING_SCORE && oppenentScore<WINING_SCORE) 
				|| (winnerScore>=WINING_SCORE && winnerScore>oppenentScore) ;
	}
	private boolean oppenentHasAdventage(int winnerScore, int oppenentScore) {
		return winnerScore>=WINING_SCORE && oppenentScore>winnerScore;
	}
	
}
