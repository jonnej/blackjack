/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import blackjack.data.Player;
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
        p = new Player("Jonne", 100);
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    @Test
    public void getCardValueTotalWorks() {
        assertEquals(p.getCardValueTotal(),0);
    }

    @Test
    public void addToSumWorks() {
        p.addToSum(10);
        assertEquals(p.getCardValueTotal(),10);
    }
}
