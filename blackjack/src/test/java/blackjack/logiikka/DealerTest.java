/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import blackjack.data.*;

/**
 *
 * @author joju
 */
public class DealerTest {

    private Dealer d;

    public DealerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        d = new Dealer("Jonne");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetNameWorks() {
        assertEquals("Jonne", d.getName());
    }

    // testing that deck has 52 different cards
    @Test
    public void createDeckWorks() {
        d.createDeck();
        List<Card> list = d.getDeck().getDeckList();
        Set<Integer> set = new HashSet(list);
        assertEquals(list.size(), set.size());
    }

    @Test
    public void dealCardWorks() {
        d.createDeck();
        Deck deck = new Deck();
        deck.createDeck();
        for (int i = 0; i < d.deckSize(); i++) {
            assertEquals("" + deck.getCard(i), "" + d.dealCard(i));
        }
    }
    
    @Test
    public void deckSizeWorksWhenEmptyDeck() {
        assertEquals(0, d.deckSize());
    }


}
