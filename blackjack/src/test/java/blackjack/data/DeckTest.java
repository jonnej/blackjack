package blackjack.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class DeckTest {
    private Deck deck;
    public DeckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        deck = new Deck();
        deck.createDeck();
    }
    
    @After
    public void tearDown() {
    }
    
//    @Test
//    public void createDeckWorks() {
//        
//    }
    
//    @Test
//    public void getCardWorks() {
//        
//    }
}