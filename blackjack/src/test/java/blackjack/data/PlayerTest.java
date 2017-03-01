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
        p = new Player("Jonne", 15.0);

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
    public void constructorSetsHandValueWithAceRight() {
        assertEquals(0, p.getHandValueWithAce());
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
    public void addCardWorks() {
        Card c = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        p.addCard(c);
        assertEquals(9, p.getHandValue());
        assertEquals(1, p.getDealtCards().size());
        assertEquals(9, p.getHandValueWithAce());
        
    }
    
    @Test
    public void addAceWorksWhenAceFirstCard() {
        Card c = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        p.addCard(c);
        assertEquals(1, p.getHandValue());
        assertEquals(1, p.getDealtCards().size());
        assertEquals(11, p.getHandValueWithAce());
    }
    
    @Test
    public void addAceWorksWhenSumOverEleven() {
        Card c1 = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        p.addCard(c1);
        p.addCard(c1);
        p.addCard(c3);
        assertEquals(19, p.getHandValue());
        assertEquals(3, p.getDealtCards().size());
        assertEquals(19, p.getHandValueWithAce());
    }
    
    @Test
    public void addAceTwice() {
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        p.addCard(c3);
        p.addCard(c3);
        assertEquals(2, p.getHandValue());
        assertEquals(2, p.getDealtCards().size());
        assertEquals(12, p.getHandValueWithAce());
    }
    @Test
    public void addCards() {
        Card c1 = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        Card c2 = new Card("4", "clubs", 4, new ImageIcon("4_of_clubs"));
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        p.addCard(c2);
        p.addCard(c1);
        p.addCard(c3);
        assertEquals(14, p.getHandValue());
        assertEquals(3, p.getDealtCards().size());
        assertEquals(14, p.getHandValueWithAce());
        
    }
    
    @Test
    public void biggestValidHandTest() {
        Card c2 = new Card("4", "clubs", 4, new ImageIcon("4_of_clubs"));
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        
        p.addCard(c2);
        p.addCard(c3);
        int h1 = p.getHandValue();	
        int h2 = p.getHandValueWithAce();
        assertEquals(h2, p.getHighestValidHand());
    }
    
  

    
    public void getHandValueTotalWorks() {
        Card c1 = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        p.addCard(c1);
        Card c2 = new Card("5", "clubs", 5, new ImageIcon("5_of_clubs"));
        p.addCard(c2);
        assertEquals(14, p.getHandValue());
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
    public void clearDealtCardsAndHandValueToZeroWorks() {
        Card c = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
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
