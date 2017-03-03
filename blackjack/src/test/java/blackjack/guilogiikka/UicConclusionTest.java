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
import javax.swing.ImageIcon;
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
public class UicConclusionTest {

    private UicConclusion uic;
    private UicDealing deal;
    private Player p;
    private Player c;
    private Betting b;
    private Dealer d;

    public UicConclusionTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        uic = new UicConclusion();
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
    public void playerHasEnoughMoneyWorksTrue() {
        assertTrue(uic.checkPlayerHasEnoughMoneyToBet(p, 10));
    }

    @Test
    public void playerHasEnoughMoneyWorksFalse() {
        assertFalse(uic.checkPlayerHasEnoughMoneyToBet(p, 105));
    }

    @Test
    public void handValueUnderTwentyTwoWorks() {
        p.getHand().addCard(new Card("8", "clubs", 8, new ImageIcon()));
        p.getHand().addCard(new Card("9", "clubs", 9, new ImageIcon()));
        assertTrue(uic.checkIfHandValueUnderTwentyTwo(p));
    }

    @Test
    public void handValueUnderTwentyTwoWorksWhenOver() {
        p.getHand().addCard(new Card("8", "clubs", 8, new ImageIcon()));
        p.getHand().addCard(new Card("9", "clubs", 9, new ImageIcon()));
        p.getHand().addCard(new Card("7", "clubs", 7, new ImageIcon()));
        assertFalse(uic.checkIfHandValueUnderTwentyTwo(p));
    }

    @Test
    public void handIsBlackJackWorks() {
        p.getHand().addCard(new Card("A", "clubs", 1, new ImageIcon()));
        p.getHand().addCard(new Card("K", "clubs", 10, new ImageIcon()));
        assertTrue(uic.handIsBlackJack(p));
    }

    @Test
    public void handIsBlackJackWorksWhenNotbj() {
        p.getHand().addCard(new Card("A", "clubs", 1, new ImageIcon()));
        p.getHand().addCard(new Card("5", "clubs", 5, new ImageIcon()));
        assertFalse(uic.handIsBlackJack(p));
    }

    @Test
    public void playerWinsWorks() {
        p.getHand().addCard(new Card("A", "clubs", 1, new ImageIcon()));
        c.getHand().addCard(new Card("5", "clubs", 5, new ImageIcon()));
        assertTrue(uic.playerWins(p, c));
    }

    @Test
    public void playerWinsWorksWhenpLoses() {
        c.getHand().addCard(new Card("A", "clubs", 1, new ImageIcon()));
        p.getHand().addCard(new Card("5", "clubs", 5, new ImageIcon()));
        assertFalse(uic.playerWins(p, c));
    }

    @Test
    public void gameIsDrawWorks() {
        p.getHand().addCard(new Card("5", "clubs", 5, new ImageIcon()));
        c.getHand().addCard(new Card("5", "clubs", 5, new ImageIcon()));

        assertTrue(uic.gameIsDraw(p, c));
    }

    @Test
    public void gameIsDrawWorksWhenNotDraw() {
        p.getHand().addCard(new Card("5", "clubs", 5, new ImageIcon()));
        c.getHand().addCard(new Card("4", "clubs", 4, new ImageIcon()));

        assertFalse(uic.gameIsDraw(p, c));
    }

    @Test
    public void getPlayerMoneyWorks() {
        assertEquals(100, uic.getPlayerMoney(p), 0.01);
    }
}
