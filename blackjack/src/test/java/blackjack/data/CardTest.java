package blackjack.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import blackjack.data.Card;
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
    }
    
    @After
    public void tearDown() {
    }
    
    

    @Test
    public void constructorWorksRight() {
        Card card = new Card("3", "clubs", 3);
        
        assertEquals("3", card.getName());
        assertEquals("clubs", card.getSuit());
        assertEquals(3, card.getValue());
    }
    
    @Test
    public void toStringWorks() {
        Card card = new Card("3", "clubs", 3);
        String s = card.toString();
        
        assertEquals("3 of clubs", s);
    }
}
