/**
 * The Connect4GUI class contains the code for the graphical user interface for the game.
 * It also contains the main method and the code for the initial GUI that appears on launch
 * which gives the user the option to play the game in the console or with a GUI.
 */
package ui;

/**
 * @author James Arsenault
 * @version 2.0 3/21/20
 */

import core.Connect4;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Connect4GUI extends Application implements EventHandler<ActionEvent> {
    
    public static void main(String[] args) {
        launch(args);
    }

    private final int size = 100;
    private final int rows = 6;
    private final int cols = 7;
    private int row;

    private Connect4 guiGame = new Connect4();

    private Stage window;
    private Scene interfaceScene;
    private Scene playingScene;
    private BorderPane interfaceLayout = new BorderPane();
    private BorderPane playingLayout = new BorderPane();
    private BorderPane gameOverLayout = new BorderPane();

    private Button console;
    private Button gui;
    private Button quit;

    /**
     * This method creates the empty game board by making a rectangle and
     * cutting 42 circles out of it.
     * 
     * @return game board object
     */
    public Shape makeBoard() {
        Shape gameboard = new Rectangle((cols + 1) * size, (rows + 1) * size);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Circle circle = new Circle(size / 2);
                circle.setCenterX(size / 2);
                circle.setCenterY(size / 2);
                circle.setTranslateX(i * (size + 5) + size / 4);
                circle.setTranslateY(j * (size + 5) + size / 4);
                gameboard = Shape.subtract(gameboard, circle);
            }
        }
        gameboard.setFill(Color.rgb(44, 44, 255, 1));
        return gameboard;
    }

    /**
     * This method is used to create the board columns
     * 
     * @param column - indicates the column number, starting at 0 and going up to 6
     * @return rectangular column
     */
    public Rectangle makeColumns(int column) {
        Rectangle r = new Rectangle(size, (rows + 2) * size);
        r.setTranslateX(column * (size + 5) + size / 4);
        r.setFill(Color.rgb(0, 0, 0, .1));
        r.setFill(Color.TRANSPARENT);
        r.setOnMouseEntered(e -> r.setFill(Color.rgb(255, 255, 0, .5)));
        r.setOnMouseExited(e -> r.setFill(Color.TRANSPARENT));
        r.setOnMouseClicked(e -> {
            if (guiGame.isColumnFull(column) == false) {
                row = makeMoveGUI(column + 1);
                Shape piece = makePiece(column * (size + 5), row * 105);
                playingLayout.getChildren().add(piece);
            }
            checkWin();
        });

        return r;
    }

    /**
     * This method is used to create the piece at the given position
     * 
     * @param positionX - indicates x position of piece
     * @param positionY - indicates y position of piece
     * @return piece object
     */
    public Shape makePiece(int positionX, int positionY) {
        Circle piece = new Circle(50);
        piece.setCenterX(size / 2);
        piece.setCenterY(size / 2);
        piece.setTranslateX(size / 4 + positionX);
        piece.setTranslateY(size / 4 + positionY);
        if (guiGame.getTurn() == 1) {
            piece.setFill(Color.rgb(0, 0, 0, 1));
        } else {
            piece.setFill(Color.rgb(255, 0, 0, 1));
        }
        return piece;
    }

    /**
     * This method is used to make the moves on the game board.
     * 
     * @param col
     */
    public int makeMoveGUI(int col) {
        int column = col - 1;
        if (guiGame.isColumnFull(column) == false) {
            guiGame.makeMoveGUI(column);
            return guiGame.getRow();
        }
        return 0;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Connect4");
        Label interfaceChoice = new Label("Please select your preferred interface.");
        interfaceLayout = new BorderPane();
        new BorderPane();
        playingLayout = new BorderPane();
        Shape board = makeBoard();
        playingLayout.getChildren().add(board);

        console = new Button();
        gui = new Button();
        quit = new Button();
        quit.setOnMouseClicked(e -> window.close());

        console.setText("Console-Based");
        gui.setText("      GUI      ");
        quit.setText("      Quit      ");
        console.setOnAction(this);
        gui.setOnAction(this);

        interfaceLayout.setTop(interfaceChoice);
        interfaceLayout.setLeft(console);
        interfaceLayout.setRight(gui);

        BorderPane.setAlignment(interfaceChoice, Pos.CENTER);
        BorderPane.setMargin(console, new Insets(55, 55, 55, 55));
        BorderPane.setMargin(gui, new Insets(55, 55, 55, 55));
        
        gameOverLayout = new BorderPane();
        gameOverLayout.setCenter(quit);

        interfaceScene = new Scene(interfaceLayout, 400, 180);

        window.setScene(interfaceScene);
        window.show();
    }

    /**
     * This method handles the initial button click for console-based or gui,
     * and then creates the game based on the selection.
     * 
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == console) {
            Connect4TextConsole object = new Connect4TextConsole();
            window.close();
            object.text();
        }

        for(int i = 0; i < 7; i++) {
            Rectangle r = makeColumns(i);
            playingLayout.getChildren().add(r);
        }

        playingScene = new Scene(playingLayout, 780, 680);
        window.setScene(playingScene);
    }

    /**
     * This method implements the conditional win checks from the Connect4 class
     */
    public void checkWin() {
        if (guiGame.checkWinVertical() == true ||
                guiGame.checkWinHorizontal() == true ||
                guiGame.checkWinDiagonalLowToHigh() == true ||
                guiGame.checkWinDiagonalHighToLow()) {
            if (guiGame.getTurn() == 1) {
                Label gameOverAnnouncement = new Label("Black wins");
                gameOverLayout.setTop(gameOverAnnouncement);
                BorderPane.setAlignment(gameOverAnnouncement, Pos.CENTER);
                Scene gameOverScene = new Scene(gameOverLayout, 400, 180);
                window.setScene(gameOverScene);
            }
            else {
                Label gameOverAnnouncement = new Label("Red wins");
                gameOverLayout.setTop(gameOverAnnouncement);
                BorderPane.setAlignment(gameOverAnnouncement, Pos.CENTER);
                Scene gameOverScene = new Scene(gameOverLayout, 400, 180);
                window.setScene(gameOverScene);
            }
        }
        else if (guiGame.isFull() == true) {
            Label gameOverAnnouncement = new Label("The game was a tie");
            gameOverLayout.setTop(gameOverAnnouncement);
            BorderPane.setAlignment(gameOverAnnouncement, Pos.CENTER);
            Scene gameOverScene = new Scene(gameOverLayout, 400, 180);
            window.setScene(gameOverScene);
        }
    }
}