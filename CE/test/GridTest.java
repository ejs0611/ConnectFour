import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest {

    /** grid */
    private Grid grid;

    /** 
     * set up
     */
    @BeforeEach
    public void setUp(){
        grid = new Grid(4);
    }

    /** test game size */
    @Test
    public void testGameSize(){
        assertEquals(8, grid.getGameSize());
    }


}
