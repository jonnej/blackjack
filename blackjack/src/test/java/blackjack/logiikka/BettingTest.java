
package blackjack.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BettingTest {
    private Betting bet;
    public BettingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.bet = new Betting();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructorWorks() {
        assertEquals(0, bet.getBet());
        assertEquals(0, bet.getInsurance(), 0.01);
    }
    
    @Test
    public void setBetWorks() {
        bet.setBet(5);
        assertEquals(5, bet.getBet());
    }
    
    @Test
    public void setInsuranceWorks() {
        bet.setBet(5);
        bet.setInsurance();
        assertEquals(2.5, bet.getInsurance(), 0.01);
    }
    
    @Test
    public void betOneMoreWorks() {
        bet.betOneMore();
        assertEquals(1, bet.getBet());
    }
    
    @Test
    public void betOneLessWorks() {
        bet.setBet(5);
        bet.betOneLess();
        assertEquals(4, bet.getBet());
    }
    
    @Test
    public void betOneLessWorksWhenBetIsZero() {
        bet.betOneLess();
        assertEquals(0, bet.getBet());
    }
    
    @Test
    public void betAmountWorks() {
        bet.bet(5);
        assertEquals(5, bet.getBet());
    }
    
    @Test
    public void doubleBetWorks() {
        bet.bet(5);
        bet.doubleBet();
        assertEquals(10, bet.getBet());
    }
    
    
}
