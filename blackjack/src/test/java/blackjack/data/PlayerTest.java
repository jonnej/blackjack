package blackjack.data;

import blackjack.data.*;
import javax.swing.ImageIcon;
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

    @Before
    public void setUp() {
        p = new Player("Jonne", 15.0, new Hand());

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
    public void constructorSetsHandRight() {
        assertEquals(0, p.getHand().getDealtCards().size());
    }

    @Test
    public void getMoneyWorks() {
        assertEquals(15.0, p.getMoney(),0.01);
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
    public void addMoneyWorksWithPositiveDouble() {
        double alku = 15.0;
        p.addMoney(5.0);
        assertEquals(alku + 5.0, p.getMoney(), 0.1);
    }
    
    @Test
    public void addMoneyWorksWithZero() {
        double alku = 15.0;
        p.addMoney(0.0);
        assertEquals(alku, p.getMoney(), 0.1);
    }

    @Test
    public void addMoneyWorksWithNegativeDouble() {
        double alku = 15.0;
        p.addMoney(-5.0);
        assertEquals(alku, p.getMoney(), 0.1);
    }

    @Test
    public void removeMoneyWorksWithPositiveDoubleWhenEnoughMoney() {
        double alku = p.getMoney();
        p.removeMoney(5);
        assertEquals(alku - 5, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithPositiveDoubleWhenNotEnoughMoney() {
        double alku = p.getMoney();
        p.removeMoney(20);
        assertEquals(alku, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithZero() {
        double alku = p.getMoney();
        p.removeMoney(0);
        assertEquals(alku, p.getMoney(), 0.01);
    }

    @Test
    public void removeMoneyWorksWithNegativeDoubleWhenEnoughMoney() {
        double alku = p.getMoney();
        p.removeMoney(-5);
        assertEquals(alku, p.getMoney(), 0.01);
    }
    
    @Test
    public void removeMoneyWorksWithPositiveIntegerWhenNotEnoughMoney() {
        double alku = p.getMoney();
        p.removeMoney(20);
        assertEquals(alku, p.getMoney(), 0.01);
    }
   
    @Test
    public void toStringWorks() {
        assertEquals("Jonne, rahaa 15.0", "" + p);
    }
}
