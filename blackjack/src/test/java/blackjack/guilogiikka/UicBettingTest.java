/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.guilogiikka;

import blackjack.data.Player;
import blackjack.logiikka.Betting;
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
public class UicBettingTest {
    private UicBetting uic;
    private Betting b;
    private Player p;
    
    public UicBettingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        uic = new UicBetting();
        b = new Betting();
        p = new Player("Jonne", 100);
        b.bet(10);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void betMoreWorks() {
        uic.betMore(b, 5, p);
        assertEquals(15, b.getBet());
        assertEquals(95, p.getMoney(), 0.01);
    }
    
    @Test
    public void getBetWorks() {
        assertEquals(10, uic.getBet(b));
    }
    
    @Test
    public void clearBetWorks() {
        uic.clearBet(b, p);
        assertEquals(0, uic.getBet(b));
        assertEquals(110, p.getMoney(), 0.01);
    }
    
    @Test
    public void setBetToZeroWorks() {
        uic.setBetToZero(b);
        assertEquals(0, uic.getBet(b));
    }
    
    @Test
    public void doubleBetWorks() {
        uic.doubleBet(b, p);
        assertEquals(90, p.getMoney(), 0.01);
        assertEquals(20, uic.getBet(b));
    }

}

