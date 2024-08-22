import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlayerTest {
    /** player zero */
    private Player playerZero;

    /** player one */
    private Player playerOne;

    /** player two */
    private Player playerTwo;

    /**
     * Create players for testing
     */
    @BeforeEach
    public void setUp() {
        playerZero = new Player();
        playerOne = new Player(1);
        playerTwo = new Player(2);
    }

    /**
     * test get name
     */
    @Test
    public void testGetName(){
        assertEquals(0, playerZero.getName(), "player zero");
        assertEquals(1, playerOne.getName(), "player one");
        assertEquals(2, playerTwo.getName(), "player two");
    }

    /** 
     * test num games won
     */
    @Test
    public void testNumGamesWon(){
        playerOne.increaseNumGamesWon();
        assertEquals(1, playerOne.getNumGamesWon(), "player one games won");
    }

    /**
     * test num pieces placed
     */
    @Test
    public void testNumPiecesPlaced(){
        playerTwo.increaseNumPiecesPlaced();
        assertEquals(1, playerTwo.getNumOfPiecesPlaced(), "player two num pieces placed");
    }

    /**
     * test max num of connected pieces
     */
    @Test
    public void testMaxNumOfConnectedPieces(){
        playerTwo.setMaxNumOfConnectedPieces(3);
        assertEquals(3, playerTwo.getMaxNumOfConnectedPieces(), "player Two maxNumberOfConnectedPieces");
    }

    /**
     * test equals
     */
    @Test
    public void testEquals(){
        assertTrue(playerOne.equals(playerOne));
        assertTrue(playerTwo.equals(playerTwo));
        assertTrue(playerZero.equals(new Player()));
        assertFalse(playerOne.equals(playerTwo));
    }
}
