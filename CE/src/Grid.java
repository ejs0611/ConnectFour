/** 
 * The Connect Four class contains handles the logic behind the game.
 * @author Lawrence Stephenson
 * @author Eric Smith
 * @author Sriman Bhadri
 * @author Trung Le
 * @version 1222022
 */
public class Grid {
    
    /** 2D piece array for the game board */
    private Piece[][] gameBoard;

    /** required number of pieces connected to win */
    private int requiredNumConnectedPieces;

    /** the size of the board */
    private int gameSize;

    /**
     * Constructor for the grid class
     * @param rqrdNumPiecesConnected number of pieces needed connected to win
     */
    public Grid(int rqrdNumPiecesConnected) {
        this.requiredNumConnectedPieces = rqrdNumPiecesConnected;
        
        // double the size of rqrdNumPieces connected for the grid size
        this.gameSize = rqrdNumPiecesConnected * 2;
        gameBoard = new Piece[gameSize][gameSize];

        // fill gameBoard with pieces
        for (int i = 0; i < gameSize; i++) {
            for (int a = 0; a < gameSize; a++) {
                gameBoard[i][a] = new Piece();
            }
        } 
    }

    /** clear the grid and set each piece to its default value */
    public void wipeGrid(){
        for (int i = 0; i < gameSize; i++) {
            for (int a = 0; a < gameSize; a++) {
                gameBoard[i][a] = new Piece();
            }
        } 
    }

    /**
     * Getter method for the size of the game board
     * @return gameSize
     */
    public int getGameSize() {
        return this.gameSize;
    }

    /**
     * Getter method for the 2D piece array game board
     * @return gameBoard
     */
    public Piece[][] getGameBoard() {
        return this.gameBoard;
    }

    /** 
     * testing a toString method 
     * @return "test"
     */
    public String toString() {
        String gameBoardString = "";

        for (int i = 0; i < gameSize; i++) {
            for (int a = 0; a < gameSize; a++) {
                gameBoardString = "test";
            }
        }
        return "test";
    }
}
