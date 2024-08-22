import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PieceTest {
    /** piece Zero */
    private Piece pieceZero;

    /** piece one */
    private Piece pieceOne;

    /** set up */
    @BeforeEach
    public void setUp(){
        pieceZero = new Piece();
        pieceOne = new Piece(new Player(1));
    }

    /** test Player */
    @Test
    public void testPlayer(){
        assertEquals(0, pieceZero.getPlayer().getName(), "pieceZero");
        assertEquals(1, pieceOne.getPlayer().getName(), "pieceOne");
        pieceZero.setPlayer(new Player(2));
        assertEquals(2, pieceZero.getPlayer().getName(), "pieceZero but its two");
    }

}
