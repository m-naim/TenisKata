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

}
