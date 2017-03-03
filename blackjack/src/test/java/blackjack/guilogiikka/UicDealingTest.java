/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.guilogiikka;

import blackjack.data.Card;
import blackjack.data.Player;
import blackjack.logiikka.Betting;
import blackjack.logiikka.Dealer;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonne
 */
public class UicDealingTest {

    private UicDealing uic;
    private Player p;
    private Player c;
    private Betting b;
    private Dealer d;

    public UicDealingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        uic = new UicDealing();
        p = new Player("Jonne", 100);
        c = new Player("Casino", 100);
        b = new Betting();
        d = new Dealer("Jana");
        d.createDeck();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorWorks() {
        assertEquals(0, uic.getPosition());
    }
    
    @Test
    public void setPositionZero() {
        uic.dealCard(p, d);
        uic.setPositionZero();
        assertEquals(0, uic.getPosition());
    }

    @Test
    public void startBettingWorks() {
        uic.dealCard(p, d);
        uic.dealCard(c, d);
        p.setInsurance(true);
        uic.startBetting(p, c, d, b);
        assertFalse(p.getInsurance());
        assertEquals(0, p.getHand().getDealtCards().size());
        assertEquals(0, c.getHand().getDealtCards().size());
        assertEquals(0, uic.getPosition());

    }

    @Test
    public void addCardImageWorks() {
        JPanel jp = new JPanel();
        uic.addCardImage(p, jp, d);
        assertEquals(1, jp.getComponentCount());
    }

    @Test
    public void dealCardWorks() {
        uic.dealCard(p, d);
        assertEquals(1, p.getHand().getDealtCards().size());
    }
    
    @Test
    public void dealCardReturnsImageIcon() {
        ImageIcon ic = d.getDeck().getCard(0).getImageIcon();
        assertEquals(ic, uic.dealCard(p, d));
        
    }

    @Test
    public void getHandValueWorks() {
        uic.dealCard(p, d);
        assertEquals(1, uic.getHandValue(p));
    }

    @Test
    public void getBiggestValidHandValueWorks() {
        uic.dealCard(p, d);
        uic.dealCard(p, d);
        assertEquals(13, uic.getBiggestValidHandValue(p));
    }

    @Test
    public void printHandValueWithoutAce() {
        uic.dealCard(c, d);
        uic.dealCard(p, d);
        uic.dealCard(p, d);

        assertEquals("5", uic.printHandValue(p));
    }

    @Test
    public void printHandValueWithAceLowerThanTwentyTwo() {
        uic.dealCard(p, d);
        uic.dealCard(p, d);

        assertEquals("3/13", uic.printHandValue(p));
    }

    @Test
    public void printHandValueWithAceOverTwentyTwo() {
        for (int i = 0; i < 5; i++) {
            uic.dealCard(p, d);
        }
        assertEquals("15", uic.printHandValue(p));
    }
}
