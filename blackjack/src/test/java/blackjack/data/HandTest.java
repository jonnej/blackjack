/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.data;

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
public class HandTest {

    private Hand h;

    public HandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        h = new Hand();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsHandValueRight() {
        assertEquals(0, h.getHandValue());
    }

    @Test
    public void constructorSetsHandValueWithAceRight() {
        assertEquals(0, h.getHandValueWithAce());
    }

    @Test
    public void addCardWorks() {
        Card c = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        h.addCard(c);
        assertEquals(9, h.getHandValue());
        assertEquals(1, h.getDealtCards().size());
        assertEquals(9, h.getHandValueWithAce());

    }

    @Test
    public void addAceWorksWhenAceFirstCard() {
        Card c = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        h.addCard(c);
        assertEquals(1, h.getHandValue());
        assertEquals(1, h.getDealtCards().size());
        assertEquals(11, h.getHandValueWithAce());
    }

    @Test
    public void addAceWorksWhenSumOverEleven() {
        Card c1 = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        h.addCard(c1);
        h.addCard(c1);
        h.addCard(c3);
        assertEquals(19, h.getHandValue());
        assertEquals(3, h.getDealtCards().size());
        assertEquals(19, h.getHandValueWithAce());
    }

    @Test
    public void addAceTwice() {
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        h.addCard(c3);
        h.addCard(c3);
        assertEquals(2, h.getHandValue());
        assertEquals(2, h.getDealtCards().size());
        assertEquals(12, h.getHandValueWithAce());
    }

    @Test
    public void addCards() {
        Card c1 = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        Card c2 = new Card("4", "clubs", 4, new ImageIcon("4_of_clubs"));
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));
        h.addCard(c2);
        h.addCard(c1);
        h.addCard(c3);
        assertEquals(14, h.getHandValue());
        assertEquals(3, h.getDealtCards().size());
        assertEquals(14, h.getHandValueWithAce());

    }

    @Test
    public void biggestValidHandTest() {
        Card c2 = new Card("4", "clubs", 4, new ImageIcon("4_of_clubs"));
        Card c3 = new Card("A", "clubs", 1, new ImageIcon("A_of_clubs"));

        h.addCard(c2);
        h.addCard(c3);
        int h1 = h.getHandValue();
        int h2 = h.getHandValueWithAce();
        assertEquals(h2, h.getHighestValidHand());
    }

    public void getHandValueTotalWorks() {
        Card c1 = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        h.addCard(c1);
        Card c2 = new Card("5", "clubs", 5, new ImageIcon("5_of_clubs"));
        h.addCard(c2);
        assertEquals(14, h.getHandValue());
    }

    @Test
    public void clearDealtCardsAndHandValueToZeroWorks() {
        Card c = new Card("9", "clubs", 9, new ImageIcon("9_of_clubs"));
        h.addCard(c);
        h.clearDealtCardsAndHandValueToZero();
        assertEquals(0, h.getHandValue());
        assertEquals(0, h.getDealtCards().size());
    }

}
