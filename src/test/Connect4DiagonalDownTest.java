package test;

import static org.junit.Assert.*;
import org.junit.Test;
import core.Connect4;

public class Connect4DiagonalDownTest {

	@Test
	public void test() {
		Connect4 winnerPlayerX = new Connect4();
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(1);
		winnerPlayerX.makeMove(0);
		winnerPlayerX.makeMove(1);
		winnerPlayerX.makeMove(1);
		winnerPlayerX.makeMove(2);
		winnerPlayerX.makeMove(2);
		winnerPlayerX.makeMove(6);
		winnerPlayerX.makeMove(3);
		winnerPlayerX.printBoard();
		assertTrue(winnerPlayerX.checkWinDiagonalHighToLow());
		
		Connect4 winnerPlayerO = new Connect4();
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(0);
		winnerPlayerO.makeMoveGUI(1);
		winnerPlayerO.makeMoveGUI(1);
		winnerPlayerO.makeMoveGUI(2);
		winnerPlayerO.makeMoveGUI(1);
		winnerPlayerO.makeMoveGUI(6);
		winnerPlayerO.makeMoveGUI(3);
		winnerPlayerO.makeMoveGUI(6);
		winnerPlayerO.makeMoveGUI(2);
		winnerPlayerO.printBoard();
		assertTrue(winnerPlayerO.checkWinDiagonalHighToLow());
	}

}
