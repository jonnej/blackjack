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
    public void setNameWorks() {
        p.setName("Janne");
        assertEquals("Janne", p.getName());
    }
    
    @Test
    public void setMoneyWorks() {
        p.setMoney(20);
        assertEquals((double) 20, p.getMoney(), 0.01);
    }
  
    @Test
    public void addCardWorks() {
        Card c = new Card("9", "clubs", 9);
        p.addCard(c);
        assertEquals(9, p.getHandValue());
        assertEquals(1, p.getDealtCards().size());
        
    }

    @Test
    public void getCardValueTotalWorks() {
        Card c1 = new Card("9", "clubs", 9);
        p.addCard(c1);
        Card c2 = new Card("5", "clubs", 5);
        p.addCard(c2);
        assertEquals(14, p.getHandValue());
    }

    @Test
    public void addMoneyWorksWithPositiveDouble() {
        p.addMoney(5);
        assertEquals((double) 20, p.getMoney(), 0.01);
    }
    
    @Test
    public void addMoneyWorksWithZero() {
        p.addMoney(0);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }

    @Test
    public void addMoneyWorksWithNegativeDouble() {
        p.addMoney(-5);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }

    @Test
    public void removeMoneyWorksWithPositiveDoubleWhenEnoughMoney() {
        p.removeMoney(5);
        assertEquals((double) 10, p.getMoney(), 0.01);
    }
    @Test
    public void removeMoneyWorksWithPositiveDoubleWhenNotEnoughMoney() {
        p.removeMoney(20);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithZero() {
        p.removeMoney(0);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }

    @Test
    public void removeMoneyWorksWithNegativeDoubleWhenEnoughMoney() {
        p.removeMoney(-5);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }
    

    @Test
    public void removeMoneyWorksWithPositiveIntegerWhenNotEnoughMoney() {
        p.removeMoney(20);
        assertEquals((double) 15, p.getMoney(), 0.01);
    }

    
    
    @Test
    public void clearDealtCardsAndHandValueToZeroWorks() {
        Card c = new Card("9", "clubs", 9);
        p.addCard(c);
        p.clearDealtCardsAndHandValueToZero();
        assertEquals(0, p.getHandValue());
        assertEquals(0, p.getDealtCards().size());
    }
    
    @Test
    public void toStringWorks() {
        assertEquals("Jonne, rahaa 15.0", "" + p);
    }
}
