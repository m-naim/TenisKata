package org.kata.tenis.exeptions;

public class GameEndedExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GameEndedExeption() {
        super("Game Alredy finished, no player can win the ball");
    }
}
