
/** 
 * Piece object for the Connect Four game. Holds information about the player that places it
 * @author Lawrence Stephenson
 * @author Eric Smith
 * @author Sriman Bhadri
 * @author Trung Le
 * @version 1222022
 */

public class Piece {

    /**
     * Private variable to initialize a Player object, which will be used throughout the code
     */
    private Player player;

    /**
     * Constructor variable that creates a Piece object
     */
    Piece () {
        this.player = new Player();
    }

    /**
     * Constructor variable that creates a Piece object with a given parameter
     * @param player the Player object that is placing the Piece on the Grid
     */
    Piece (Player player) {
        this.player = player;
    }

     /**
     * Method that returns the Player object
     * @return the Player object that was declared in the constructor method
     */   
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Method that sets the initialized private variable to a given Player object
     * @param player the Player who will be assigned to this piece
     */   
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Method that returns the Piece's player
     * @return the name of this Piece's player as a String value
     */   
    public String toString() {
        return this.player.toString();
    }
} 