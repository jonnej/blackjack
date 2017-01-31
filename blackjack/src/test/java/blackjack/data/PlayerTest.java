package blackjack.data;



import blackjack.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joju
 */
public class PlayerTest {

    Player p;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new Player("Jonne", 15);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsNameRight() {
        assertEquals("Jonne", p.getName());
    }

    @Test
    public void constructorSetsMoneyRight() {
        assertEquals((double) 15, p.getMoney(), 0.01);
    }

    @Test
    public void constructorSetsHandValueRight() {       
        assertEquals(0, p.getHandValue());
    }

    @Test
    public void addToHandValueWorks() {
        Card c = new Card("9", "clubs", 9);
        p.addToHandValue(c);
        assertEquals(9, p.getHandValue());
    }

    @Test
    public void getCardValueTotalWorks() {
        Card c1 = new Card("9", "clubs", 9);
        p.addToHandValue(c1);
        Card c2 = new Card("5", "clubs", 5);
        p.addToHandValue(c2);
        assertEquals(14, p.getHandValue());
    }

    @Test
    public void addMoneyWorksWithPositiveInteger() {
        p.addMoney(5);
        assertEquals((double) 20, p.getMoney(), 0.01);
    }

    @Test
    public void addMoneyWorksWithNegativeInteger() {
        p.addMoney(-5);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithPositiveInteger() {
        p.removeMoney(5);
        assertEquals((double) 10, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithNegativeInteger() {
        p.removeMoney(-5);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithPositiveIntegerWhenNotEnoughMoney() {
        p.removeMoney(20);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }
    
     @Test
    public void removeMoneyWorksWithNegativeIntegerWhenNotEnoughMoney() {
        p.removeMoney(-20);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }
}
