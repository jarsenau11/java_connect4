/**
 * The Connect4TextConsole class utilizes the Connect4 class to create a
 * game board and play the game, while preventing invalid moves and
 * detecting when the game is over
 */
package ui;

import java.util.Scanner;

import core.Connect4;

/**
 * @author James Arsenault
 * @version 3.0 3/20/20
 */
public class Connect4TextConsole {
    public void text() {
        
        String colString;
        int col;
        Scanner scan = new Scanner(System.in);

        Connect4 game = new Connect4();
        game.printBoard();

        System.out.println("Start game.");
        System.out.println("Player X - your turn. Choose a column number from 1-7.");
        while (game.checkWinVertical() == false &&
                game.checkWinHorizontal() == false &&
                game.checkWinDiagonalLowToHigh() == false &&
                game.checkWinDiagonalHighToLow() == false &&
                game.isFull() == false) {
            colString = scan.next();
            if (colString.equals("1") || colString.equals("2") ||
                    colString.equals("3") || colString.equals("4") ||
                    colString.equals("5") || colString.equals("6") ||
                    colString.equals("7")) {
                col = Integer.valueOf(colString) - 1;
                if (game.isColumnFull(col) == false) {
                    game.makeMove(col);
                    game.printBoard();
                }
                else {
                    System.out.println("This column is full, please try another.");
                }
            }
            else {
                System.out.println("Please choose a number between 1 and 7.");
            }
        }

        if (game.isFull() == true) {
            System.out.println("The game was a tie.");
        }
        else if (game.getTurn() == 1) {
            System.out.println("Player O Won the Game");
        }
        else {
            System.out.println("Player X Won the Game");
        }
        scan.close();

    }
}
