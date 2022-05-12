package test;

import static org.junit.Assert.*;
import org.junit.Test;
import core.Connect4;

public class Connect4IsFullTest {

	@Test
	public void test() {
		Connect4 fullGame = new Connect4();
		fullGame.makeMoveGUI(0);
		fullGame.makeMoveGUI(0);
		fullGame.makeMoveGUI(0);
		fullGame.makeMoveGUI(0);
		fullGame.makeMoveGUI(0);
		fullGame.makeMoveGUI(0);
		fullGame.makeMoveGUI(1);
		fullGame.makeMoveGUI(1);
		fullGame.makeMoveGUI(1);
		fullGame.makeMoveGUI(1);
		fullGame.makeMoveGUI(1);
		fullGame.makeMoveGUI(1);
		fullGame.makeMoveGUI(2);
		fullGame.makeMoveGUI(2);
		fullGame.makeMoveGUI(2);
		fullGame.makeMoveGUI(2);
		fullGame.makeMoveGUI(2);
		fullGame.makeMoveGUI(2);
		fullGame.makeMoveGUI(6);
		fullGame.makeMoveGUI(3);
		fullGame.makeMoveGUI(3);
		fullGame.makeMoveGUI(3);
		fullGame.makeMoveGUI(3);
		fullGame.makeMoveGUI(3);
		fullGame.makeMoveGUI(3);
		fullGame.makeMoveGUI(4);
		fullGame.makeMoveGUI(4);
		fullGame.makeMoveGUI(4);
		fullGame.makeMoveGUI(4);
		fullGame.makeMoveGUI(4);
		fullGame.makeMoveGUI(4);
		fullGame.makeMoveGUI(5);
		fullGame.makeMoveGUI(5);
		fullGame.makeMoveGUI(5);
		fullGame.makeMoveGUI(5);
		fullGame.makeMoveGUI(5);
		fullGame.makeMoveGUI(5);
		fullGame.makeMoveGUI(6);
		fullGame.makeMoveGUI(6);
		fullGame.makeMoveGUI(6);
		fullGame.makeMoveGUI(6);
		fullGame.makeMoveGUI(6);
		fullGame.printBoard();
		assertTrue(fullGame.isFull());
		
		Connect4 notFullGame = new Connect4();
		notFullGame.printBoard();
		assertFalse(notFullGame.isFull());
	}
}
