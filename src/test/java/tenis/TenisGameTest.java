package tenis;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.kata.tenis.TenisGame;

import tenis.mock.PrintScoreMock;

public class TenisGameTest {

	@Test
	public void simplCaseWithoutGameWinnerOk() {
		PrintScoreMock printScore= new PrintScoreMock();
		TenisGame tenisGame = new TenisGame(printScore);
		tenisGame.displayScore("AB");
		List<String> expected= Arrays.asList(
				"Player A : 15 / Player B : 0",
				"Player A : 15 / Player B : 15"
				);
		assertEquals(expected,printScore.getPrints());
	}
	
	@Test
	public void AShouldWinTheGame() {
		PrintScoreMock printScore= new PrintScoreMock();
		TenisGame tenisGame = new TenisGame(printScore);
		tenisGame.displayScore("ABAAA");
		List<String> expected= Arrays.asList(
				"Player A : 15 / Player B : 0",
				"Player A : 15 / Player B : 15",
				"Player A : 30 / Player B : 15",
				"Player A : 40 / Player B : 15",
				"Player A wins the game"
				);
		assertEquals(expected,printScore.getPrints());
	}
	
	@Test
	public void BShouldWinTheGame() {
		PrintScoreMock printScore= new PrintScoreMock();
		TenisGame tenisGame = new TenisGame(printScore);
		tenisGame.displayScore("ABABBB");
		List<String> expected= Arrays.asList(
				"Player A : 15 / Player B : 0",
				"Player A : 15 / Player B : 15",
				"Player A : 30 / Player B : 15",
				"Player A : 30 / Player B : 30",
				"Player A : 30 / Player B : 40",
				"Player B wins the game"
				);
		assertEquals(expected,printScore.getPrints());
	}
	
	@Test
	public void AShouldWinAfterDeuce() {
		PrintScoreMock printScore= new PrintScoreMock();
		TenisGame tenisGame = new TenisGame(printScore);
		tenisGame.displayScore("ABABBABAAA");
		List<String> expected= Arrays.asList(
				"Player A : 15 / Player B : 0",
				"Player A : 15 / Player B : 15",
				"Player A : 30 / Player B : 15",
				"Player A : 30 / Player B : 30",
				"Player A : 30 / Player B : 40",
				"Player A : 40 / Player B : 40",
				"Player A : 40 / Player B : Adventage",
				"Player A : 40 / Player B : 40",
				"Player A : Adventage / Player B : 40",
				"Player A wins the game"
				);
		assertEquals(expected,printScore.getPrints());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ShouldThrowIllegaleInput() {
		PrintScoreMock printScore= new PrintScoreMock();
		TenisGame tenisGame = new TenisGame(printScore);
		tenisGame.displayScore("ABAC");
	}

}
