/**
 * The Connect4 class provides all of the game logic implemented by the
 * Connect4TextConsole and Connect4GUI classes.
 */
package core;

/**
 * @author James Arsenault
 * @version 4.0 3/23/20
 */
public class Connect4 {

    private String[][] game;
    private int turn;
    private boolean win = false;
    private int tempRow;
    
    /**
     * The Connect4() constructor is used to create an empty 6 by 7 array for
     * storing piece data.
     */
    public Connect4() {
        game = new String[6][7];
        turn = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                game[i][j] = " ";
            }
        }
    }

    /**
     * The printBoard() method prints a simply formatted board along with any
     * piece data (or empty spaces) that is stored in the game object.
     */
    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                System.out.print("" + game[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

    /**
     * The makeMove(int column) method is used for making moves for each player.
     * It uses nested for loops to find the first empty space (indicated by " ")
     * in the designated column, and inserts the piece which corresponds to the
     * player making the move (X or O). It also prints the message indicating
     * whose turn it is.
     * 
     * @param column - taken as user input and used to determine which column
     *               to insert their piece.
     */
    public void makeMove(int column) {
        if (turn == 1) {
            for (int i = 5; i >= 0; i--) {
                if (game[i][column].equals(" ")) {
                    game[i][column] = "X";
                    tempRow = i;
                    break;
                }
            }
            System.out.println("Player O - your turn. Choose a column number"
                    + " from 1-7.");
            turn = 2;
        } 
        else {
            for (int i = 5; i >= 0; i--) {
                if (game[i][column].equals(" ")) {
                    game[i][column] = "O";
                    tempRow = i;
                    break;
                }
            }
            turn = 1;
            System.out.println("Player X - your turn. Choose a column number"
                    + " from 1-7.");
        }
    }

    /**
     * The makeMoveGUI method is used to make moves in the GUI class and does
     * not print messages to console.
     * 
     * @param column
     */
    public void makeMoveGUI(int column) {
        if (turn == 1) {
            for (int i = 5; i >= 0; i--) {
                if (game[i][column].equals(" ")) {
                    game[i][column] = "X";
                    tempRow = i;
                    break;
                }
            }
            turn = 2;
        }
        else {
            for (int i = 5; i >= 0; i--) {
                if (game[i][column].equals(" ")) {
                    game[i][column] = "O";
                    tempRow = i;
                    break;
                }
            }
            turn = 1;
        }
    }

    /**
     * The isFull() method checks to see if the board is full, and if it is, prints
     * that the game is a tie and returns true. If an empty space (" ") is found,
     * it will return false.
     * 
     * @return true if the board is full, false if it is not full
     */
    public boolean isFull() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (game[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * The checkWinHorizontal method checks if there are 4 in a row horizontally.
     * 
     * @return true if there are 4 in a row horizontally, false if not.
     */
    public boolean checkWinHorizontal() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (!game[i][j].equals(" ") &&
                        game[i][j].equals(game[i][j + 1]) &&
                        game[i][j].equals(game[i][j + 2]) &&
                        game[i][j].equals(game[i][j + 3])) {
                    win = true;
                    return win;
                }
                else {
                    win = false;
                }
            }
        }
        return win;
    }

    /**
     * The checkWinVertical() method checks if there are 4 in a row vertically.
     * 
     * @return true if it finds 4 in a row vertically, false if it does not.
     */
    public boolean checkWinVertical() {
        boolean win = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (!game[i][j].equals(" ") &&
                        game[i][j].equals(game[i + 1][j]) &&
                        game[i][j].equals(game[i + 2][j]) &&
                        game[i][j].equals(game[i + 3][j])) {
                    win = true;
                    return win;
                }
                else {
                    win = false;
                }
            }
        }
        return win;
    }

    /**
     * The checkWinDiagonalHighToLow() method checks to see if there are 4 in
     * a row diagonally from upper left to lower right.
     * 
     * @return true if it finds 4 in a row diagonally from upper left to
     *         to lower right, false if it does not.
     */
    public boolean checkWinDiagonalHighToLow() {
        boolean win = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (!game[i][j].equals(" ") &&
                        game[i][j].equals(game[i + 1][j + 1]) &&
                        game[i][j].equals(game[i + 2][j + 2]) &&
                        game[i][j].equals(game[i + 3][j + 3])) {
                    win = true;
                    return win;
                }
                else {
                    win = false;
                }
            }
        }
        return win;
    }

    /**
     * The checkWinDiagonalLowToHigh() method checks to see if there are 4 in a
     * row diagonally from lower left to upper right.
     * 
     * @return true if it finds 4 in a row diagonally from lower left to upper
     *         right, false if it does not.
     */
    public boolean checkWinDiagonalLowToHigh() {
        boolean win = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (!game[i][j].equals(" ") &&
                        game[i][j].equals(game[i + 1][j - 1]) &&
                        game[i][j].equals(game[i + 2][j - 2]) &&
                        game[i][j].equals(game[i + 3][j - 3])) {
                    win = true;
                    return win;
                }
                else {
                    win = false;
                }
            }
        }
        return win;
    }

    /**
     * The isColumnFull(int column) method checks to see if a column is full.
     * It is used to prevent players from selecting a full column when making a move.
     * 
     * @param column - an int represents the column of the board
     *                 that is tested for being full.
     * @return true if the column is full, false if it is not.
     */
    public boolean isColumnFull(int column) {
        if (game[0][column].equals(" ")) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * The getTurn method checks which player's turn it is and is used in
     * to announce a winner based on whose turn it is.
     * 
     * @return turn.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * This method is utilized in the connect4GUI class to help with
     * placing the pieces.
     * 
     * @return tempRow.
     */
    public int getRow() {
        return tempRow;
    }
}
