import java.util.*;

/** 
 * The Connect Four class contains handles the logic behind the game.
 * @author Lawrence Stephenson
 * @author Eric Smith
 * @author Sriman Bhadri
 * @author Trung Le
 * @version 1222022
 */
public class ConnectFour {
    
    /** Required number of pieces connected to win */
    private int requiredNumConnectedPieces;

    /** The number of rows and columns in the game */
    private int gameSize;

    /** Player object containing info for playerOne */
    private Player playerOne;

    /** Player object containing info for playerTwo */
    private Player playerTwo;

    /** Player object containing the current player */
    private Player currentPlayer;

    /** Grid object containing the game board */
    private Grid grid;

    /**
     * Constructor for making a new ConnectFour game
     * @param rqrdNumConnectedPieces required number of pieces connected to win
     */
    public ConnectFour(int rqrdNumConnectedPieces) {
        this.requiredNumConnectedPieces = rqrdNumConnectedPieces;
        grid = new Grid(requiredNumConnectedPieces);
        playerOne = new Player(1);
        playerTwo = new Player(2);
        currentPlayer = playerOne;
        this.gameSize = grid.getGameSize();
    }
    
    /**
     * Places a piece on the grid in the bottom most available spot of a given column. 
     * @param col column to place a piece
     */
    public void placePiece(int col) {
        int selectedColumn = col;

        // for loop starting at the bottom of the rows in the current game
        for (int i = this.gameSize - 1; i >= 0; i--) {

            //if a piece isnt assigned a player 1 or 2, set the pieces player to current player,
            // and add 1 to that players num pieces placed
            if (grid.getGameBoard()[i][selectedColumn].getPlayer().getName() == 0) { 
                grid.getGameBoard()[i][selectedColumn].setPlayer(this.currentPlayer);
                currentPlayer.increaseNumPiecesPlaced();
                break;
            }
        }
        changeCurrentPlayer();
    }

    /**
     * Checks whether there has been the required number of pieces placed
     * diagonally, horizontally, or vertically for a win
     * @return whether the win condition has been met
     */
    public boolean checkConnectFour() {
        boolean one = checkConnectFourDiagonal();
        boolean two = checkConnectFourHorizontal();
        boolean three = checkConnectFourVertical();

        return one || two || three;
    }

    /**
     * Checks if the correct number of pieces have been placed diagonally
     * @return whether the diagonal win condition has been met
     */
    private boolean checkConnectFourDiagonal() {
        for (int i = 0; i < this.gameSize; i++) { // loop for going down the row. Accounts for (\)
            int row = i;
            int col = 0;
            int cnctdPiecesPlayerOne = 0;
            int cnctdPiecesPlayerTwo = 0;

            while (row < this.gameSize) { // while loop for going down diagonally to the right
                if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerOne)) {
                    cnctdPiecesPlayerTwo = 0;
                    cnctdPiecesPlayerOne++;
                } else if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerTwo)) {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo++;
                } else {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo = 0;
                }

                updatePlayersPiecesConnected(playerOne, cnctdPiecesPlayerOne);
                updatePlayersPiecesConnected(playerTwo, cnctdPiecesPlayerTwo);

                if (cnctdPiecesPlayerOne >= this.requiredNumConnectedPieces) {
                    return true;
                } else if (cnctdPiecesPlayerTwo >= this.requiredNumConnectedPieces) {
                    return true;
                }

                row++;
                col++;
            }

        }

        // for loop for going down the column. Accounts for (\)
        for (int i = 1; i < this.gameSize; i++) { 
            int row = 0;
            int col = i;
            int cnctdPiecesPlayerOne = 0;
            int cnctdPiecesPlayerTwo = 0;

            while (col < this.gameSize) { // while loop for going down diagonally to the right
                if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerOne)) {
                    cnctdPiecesPlayerTwo = 0;
                    cnctdPiecesPlayerOne++;
                } else if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerTwo)) {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo++;
                } else {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo = 0;
                }

                updatePlayersPiecesConnected(playerOne, cnctdPiecesPlayerOne);
                updatePlayersPiecesConnected(playerTwo, cnctdPiecesPlayerTwo);

                if (cnctdPiecesPlayerOne >= this.requiredNumConnectedPieces) {
                    return true;
                } else if (cnctdPiecesPlayerTwo >= this.requiredNumConnectedPieces) {
                    return true;
                }

                row++;
                col++;
            }
        }

        for (int i = 0; i < this.gameSize; i++) { // loop for going down the row. Accounts for (/)
            int row = i;
            int col = gameSize - 1;
            int cnctdPiecesPlayerOne = 0;
            int cnctdPiecesPlayerTwo = 0;

            while (row < this.gameSize) { // while loop for going down diagonally to the right
                if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerOne)) {
                    cnctdPiecesPlayerTwo = 0;
                    cnctdPiecesPlayerOne++;
                } else if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerTwo)) {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo++;
                } else {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo = 0;
                }

                updatePlayersPiecesConnected(playerOne, cnctdPiecesPlayerOne);
                updatePlayersPiecesConnected(playerTwo, cnctdPiecesPlayerTwo);

                if (cnctdPiecesPlayerOne >= this.requiredNumConnectedPieces) {
                    return true;
                } else if (cnctdPiecesPlayerTwo >= this.requiredNumConnectedPieces) {
                    return true;
                }

                row++;
                col--;
            }

        }

        for (int i = this.gameSize - 2; i <= 0; i--) {// loop for going down the column (/)
            int row = 0;
            int col = i;
            int cnctdPiecesPlayerOne = 0;
            int cnctdPiecesPlayerTwo = 0;

            while (col >= 0) { // while loop for going down diagonally to the right
                if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerOne)) {
                    cnctdPiecesPlayerTwo = 0;
                    cnctdPiecesPlayerOne++;
                } else if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerTwo)) {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo++;
                } else {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo = 0;
                }

                updatePlayersPiecesConnected(playerOne, cnctdPiecesPlayerOne);
                updatePlayersPiecesConnected(playerTwo, cnctdPiecesPlayerTwo);

                if (cnctdPiecesPlayerOne >= this.requiredNumConnectedPieces) {
                    return true;
                } else if (cnctdPiecesPlayerTwo >= this.requiredNumConnectedPieces) {
                    return true;
                }

                row++;
                col--;
            }
        }

        return false;
    }

    /**
     * Checks if the correct number of pieces have been placed horizontally
     * @return whether the diagonal win condition has been met
     */
    private boolean checkConnectFourHorizontal() {

        for (int row = 0; row < this.gameSize; row++) { // for loop for the going down the row
            int cnctdPiecesPlayerOne = 0;
            int cnctdPiecesPlayerTwo = 0;
            for (int col = 0; col < this.gameSize; col++) { // for loop for going down the column
                if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerOne)) {
                    cnctdPiecesPlayerTwo = 0;
                    cnctdPiecesPlayerOne++;
                } else if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerTwo)) {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo++;
                } else {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo = 0;
                }

                updatePlayersPiecesConnected(playerOne, cnctdPiecesPlayerOne);
                updatePlayersPiecesConnected(playerTwo, cnctdPiecesPlayerTwo);

                if (cnctdPiecesPlayerOne >= this.requiredNumConnectedPieces) {
                    return true;
                } else if (cnctdPiecesPlayerTwo >= this.requiredNumConnectedPieces) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Checks if the correct number of pieces have been placed vertically
     * @return whether the diagonal win condition has been met
     */
    private boolean checkConnectFourVertical() {

        for (int col = 0; col < this.gameSize; col++) { // for loop for the going down the column
            int cnctdPiecesPlayerOne = 0;
            int cnctdPiecesPlayerTwo = 0;
            for (int row = 0; row < this.gameSize; row++) { // for loop for going down the row
                if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerOne)) {
                    cnctdPiecesPlayerTwo = 0;
                    cnctdPiecesPlayerOne++;
                } else if (grid.getGameBoard()[row][col].getPlayer().equals(this.playerTwo)) {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo++;
                } else {
                    cnctdPiecesPlayerOne = 0;
                    cnctdPiecesPlayerTwo = 0;
                }

                updatePlayersPiecesConnected(playerOne, cnctdPiecesPlayerOne);
                updatePlayersPiecesConnected(playerTwo, cnctdPiecesPlayerTwo);

                if (cnctdPiecesPlayerOne >= this.requiredNumConnectedPieces) {
                    return true;
                } else if (cnctdPiecesPlayerTwo >= this.requiredNumConnectedPieces) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Updates a given players number of connected pieces
     * @param player player to have number of piecesConnected set
     * @param piecesConnected number of a players peices connected
     */
    private void updatePlayersPiecesConnected(Player player, int piecesConnected) {
        if (player.getMaxNumOfConnectedPieces() < piecesConnected) {
            player.setMaxNumOfConnectedPieces(piecesConnected);
        }
    }

    /** 
     * Changes the current player
     */
    public void changeCurrentPlayer() {
        if (currentPlayer.getName() == 1) {
            currentPlayer = playerTwo;
        } else if (currentPlayer.getName() == 2) {
            currentPlayer = playerOne;
        }
    }

    /**
     * Getter method for Player object playerOne
     * @return playerOne
     */
    public Player getPlayerOne() {
        return this.playerOne;
    }

    /**
     * Getter method for Player object playerTwo
     * @return playerTwo
     */
    public Player getPlayerTwo() {
        return this.playerTwo;
    }

    /**
     * Sets the Player object playerOne
     * @param player object for playerOne
     */
    public void setPlayerOne(Player player) {
        this.playerOne = player;
    }

    /**
     * Sets the player object playerTwo
     * @param player object for playerTwo
     */
    public void setPlayerTwo(Player player) {
        this.playerTwo = player;
    }

    /**
     * Getter method for the current player
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Setter mnethod for the current player
     * @param player object currentPlayer
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    /**
     * Getter method for rqrdNumConnectedPieces
     * @return rqrdNumConnectedPieces
     */
    public int getRqrdNumConnectedPieces() {
        return this.requiredNumConnectedPieces;
    }

    /**
     * Getter method for the grid
     * @return grid
     */
    public Grid getGrid() {
        return this.grid;
    }

    /** Increases currentPlayer's score */
    public void increaseCurrentPlayerScore() {
        currentPlayer.increaseNumGamesWon();
    }

    /**
     * Getter method for gameSize of the grid
     * @return gameSize
     */
    public int getGameSize(){
        return grid.getGameSize();
    }

    /**
     * Checks if every spot on the board is occupied
     * @return whether the whole board is occupied
     */
    public boolean allOccupied(){
        for(int i = 0; i < grid.getGameSize(); i++){
            for(int x = 0; x < grid.getGameSize(); x++){
                if(grid.getGameBoard()[i][x].getPlayer().getName() == 0){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Getter method for the number of wins a given player has
     * @param player object to get information from
     * @return player number of games won
     * @throws IllegalArgumentException if the player cannot be found
     */
    public int getPlayerWins(int player){
        if(player == 1){
            return playerOne.getNumGamesWon();
        } else if(player == 2){
            return playerTwo.getNumGamesWon();
        } else {
            throw new IllegalArgumentException("player not found");
        }
    }
}