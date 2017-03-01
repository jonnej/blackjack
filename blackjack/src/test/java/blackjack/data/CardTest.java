package blackjack.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import blackjack.data.Card;
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
public class CardTest {

    private ImageIcon ic;

    public CardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.ic = new ImageIcon("3_of_clubs");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorWorksRight() {
        Card card = new Card("3", "clubs", 3, ic);

        assertEquals("3", card.getName());
        assertEquals("clubs", card.getSuit());
        assertEquals(3, card.getValue());
    }
    
    @Test
    public void constructorSetsImageIcon() {
        Card card = new Card("3", "clubs", 3, ic);
        
        assertTrue(card.getImageIcon() != null);
    }

    @Test
    public void toStringWorks() {
        Card card = new Card("3", "clubs", 3, ic);
        String s = card.toString();

        assertEquals("3 of clubs", s);
    }
}
