/** 
 * Player object for the Connect Four game. Holds information regarding the two players
 * @author Lawrence Stephenson
 * @author Eric Smith
 * @author Sriman Bhadri
 * @author Trung Le
 * @version 1222022
 */
public class Player {

    /** Name of the player */
    private int name;

    /** Number of pieces placed by palyer */
    private int numOfPiecesPlaced;

    /** Maximum number of pieces a player has connected */
    private int maxNumOfConnectedPieces;

    /** Number of times a player has won */
    private int numGamesWon;

    /** Default constructor for the Player class */
    Player() {
        this.name = 0;
        this.numOfPiecesPlaced = 0;
        this.maxNumOfConnectedPieces = 0;
        this.numGamesWon = 0;
    }

    /**
     * Constructor for player class that takes a name
     * @param name of the player
     */
    Player (int name) {
        this.name = name;
        this.numOfPiecesPlaced = 0;
        this.maxNumOfConnectedPieces = 0;
        this.numGamesWon = 0;
    }

    /** Resets the players pieces placed and max number of connected pieces */
    public void newRound() {
        this.numOfPiecesPlaced = 0;
        this.maxNumOfConnectedPieces = 0;
    }

    /** 
     * Method for determining if two player objects are equal 
     * @param o object to be compared against
     * @return whether this object is equal to o
     */
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.name == player.getName();
        }
        return false;
    }

    /** Increase players num of pieces placed by one */
    public void increaseNumPiecesPlaced() {
        this.numOfPiecesPlaced++;
    }

    /**
     * Set the players max number of connected pieces
     * @param maxConnectedPieces max number of connected pieces
     */
    public void setMaxNumOfConnectedPieces(int maxConnectedPieces) {
        this.maxNumOfConnectedPieces = maxConnectedPieces;
    }

    /**
     * Getter method for the number of pieces a player has placed
     * @return numPiecesPlaced
     */
    public int getNumOfPiecesPlaced() {
        return this.numOfPiecesPlaced;
    }

    /**
     * Getter method for max number of connected pieces a player has
     * @return maxNumConnectedPieces
     */
    public int getMaxNumOfConnectedPieces() {
        return this.maxNumOfConnectedPieces;
    }
    
    /**
     * Getter method for number of games a player has won
     * @return numGamesWon
     */
    public int getNumGamesWon() {
        return this.numGamesWon;
    }

    /**
     * Getter method for players name
     * @return name
     */
    public int getName() {
        return this.name;
    }

    /** Increase players number of games won  by one */
    public void increaseNumGamesWon() {
        this.numGamesWon++;
    }
    
    /** 
     * Returns the players name as a String 
     * @return Player name as String
     */
    public String toString() {
        return Integer.toString(name);
    }
}
