package test;

import static org.junit.Assert.*;
import org.junit.Test;
import core.Connect4;

public class Connect4ColumnFullTest {

    @Test
    public void test() {
        Connect4 gameTrue = new Connect4();
        gameTrue.makeMoveGUI(0);
        gameTrue.makeMoveGUI(0);
        gameTrue.makeMoveGUI(0);
        gameTrue.makeMoveGUI(0);
        gameTrue.makeMoveGUI(0);
        gameTrue.makeMoveGUI(0);
        gameTrue.printBoard();
        assertTrue(gameTrue.isColumnFull(0));

        Connect4 gameFalse = new Connect4();
        gameFalse.makeMoveGUI(0);
        gameFalse.printBoard();
        assertFalse(gameFalse.isColumnFull(0));
    }
}
