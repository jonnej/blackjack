package blackjack.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void createDeckWorks() {
        deck.createDeck();
        List<Card> list = deck.getDeckList();
        Set<Integer> set = new HashSet(list);
        assertEquals(list.size(), set.size());
    }
    
    @Test
    public void getCardWorks() {      
        Deck helpDeck = new Deck();
        helpDeck.createDeck();
        deck.createDeck();
        for (int i = 0; i < deck.getDeckList().size(); i++) {
            assertEquals(""+ helpDeck.getDeckList().get(i),"" + deck.getCard(i));
        }
    }
}
