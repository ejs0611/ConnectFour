import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectFourTest {
    private ConnectFour game;
    private ConnectFour gameTwo;

    @BeforeEach
    public void setUp(){
        game = new ConnectFour(4);
        gameTwo = new ConnectFour(5);
    }

    @Test
    public void testConstructor(){
        assertEquals(4, game.getRqrdNumConnectedPieces(), "rqrd connect");
        assertEquals(8, game.getGameSize(), "gamesize");
        assertEquals(1, game.getPlayerOne().getName(), "player 1");
        assertEquals(2, game.getPlayerTwo().getName(), "player 2");
        assertEquals(1, game.getCurrentPlayer().getName(), "current player");
        
    }

    @Test
    public void testCheckConnectFourVertical(){
        for(int i = 0; i < 3; i++){
            game.placePiece(1);
            game.placePiece(2);
        }
        game.placePiece(1);
        assertTrue(game.checkConnectFour(), "checkConnectFour vertical");
    }

    @Test
    public void testCheckConnectFourHorizontal(){
        for(int i = 0; i < 3; i++){
            game.placePiece(i);
            game.placePiece(i);
        }
        game.placePiece(3);
        assertTrue(game.checkConnectFour(), "checkConnectFour horizontal");
    }

    @Test
    public void testCheckConnectFourDiagonal(){
        game.placePiece(0);
        game.placePiece(1);
        game.placePiece(2);
        game.placePiece(3);
        game.placePiece(1);
        game.placePiece(2);
        game.placePiece(3);
        game.placePiece(4);
        game.placePiece(2);
        game.placePiece(3);
        game.placePiece(3);
        assertTrue(game.checkConnectFour(), "checkConnectFour diagonal");
    }

    @Test
    public void testCheckConnectFourDiagonalTwo() {
        game.placePiece(7);
        game.placePiece(6);
        game.placePiece(6);
        game.placePiece(5);
        game.placePiece(4);
        game.placePiece(5);
        game.placePiece(5);
        game.placePiece(4);
        game.placePiece(3);
        game.placePiece(4);
        game.placePiece(4);
        assertTrue(game.checkConnectFour(), "checkConnectFour diagonal");
    }

    @Test 
    public void testAllOccupied() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                game.placePiece(j);
            }
        }
        assertTrue(game.allOccupied(), "check if board is full");
    }

    @Test public void testGameSizeOfFive() {
        for(int i = 0; i < 4; i++){
            gameTwo.placePiece(i);
            gameTwo.placePiece(i);
        }
        gameTwo.placePiece(4);
        assertTrue(gameTwo.checkConnectFour(), "checkConnectFour horizontal");
    }
}
