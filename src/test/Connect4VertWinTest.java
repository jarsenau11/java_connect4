package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Connect4;

public class Connect4VertWinTest {

	@Test
	public void test() {
		Connect4 winnerPlayerX = new Connect4();
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(1);
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(1);
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(1);
		winnerPlayerX.makeMove(0);
		winnerPlayerX.printBoard();
		assertTrue(winnerPlayerX.checkWinVertical());
		
		Connect4 winnerPlayerO = new Connect4();
		winnerPlayerO.makeMoveGUI(6);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(1);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(1);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(1);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.printBoard();
		assertTrue(winnerPlayerO.checkWinVertical());
	}

}
