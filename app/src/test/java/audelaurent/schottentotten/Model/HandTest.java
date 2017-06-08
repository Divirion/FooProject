package audelaurent.schottentotten.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aude on 01/06/2017.
 */
public class HandTest {
    Hand hand;

    @Before
    public void setUp() throws Exception {
        hand = new Hand();
    }

    @Test
    public void addCard() throws Exception {
        int res;

        //Test the addition of 1 card
        ClanCard card = new ClanCard(Color.YELLOW, 6);
        assertEquals(hand.getHand().size(), 0);
        res = hand.addCard(card);
        assertEquals(hand.getHand().size(), 1);
        assertEquals(res, 0);
        assertTrue(hand.getHand().contains(card));

        //Test the addition of a 2nd card
        card = new ClanCard(Color.GRAY, 5);
        res = hand.addCard(card);
        assertEquals(hand.getHand().size(), 2);
        assertEquals(res, 0);
        assertTrue(hand.getHand().contains(card));

        //Populate the playerHand
        res = hand.addCard(new ClanCard(Color.BLUE, 5));
        assertEquals(res, 0);
        res = hand.addCard(new ClanCard(Color.GRAY, 9));
        assertEquals(res, 0);
        res = hand.addCard(new ClanCard(Color.GREEN, 1));
        assertEquals(res, 0);
        res = hand.addCard(new ClanCard(Color.GRAY, 2));
        assertEquals(res, 0);
        assertEquals(hand.getHand().size(), 6);

        //Test when the playerHand is full
        card = new ClanCard(Color.RED, 3);
        res = hand.addCard(card);
        assertEquals(res, 1);
        assertEquals(hand.getHand().size(), 6);
        assertFalse(hand.getHand().contains(card));
    }

    @Test
    public void removeCard() throws Exception {
        int res;

        //Populate the playerHand
        res = hand.addCard(new ClanCard(Color.BLUE, 5));
        res = hand.addCard(new ClanCard(Color.GRAY, 9));
        res = hand.addCard(new ClanCard(Color.GREEN, 1));
        res = hand.addCard(new ClanCard(Color.RED, 9));
        res = hand.addCard(new ClanCard(Color.BLUE, 4));
        assertEquals(hand.getHand().size(), 5);

        ClanCard card = new ClanCard(Color.GREEN, 1);
        res = hand.removeCard(card);
        assertEquals(res, 0);
        assertEquals(hand.getHand().size(), 4);
        assertFalse(hand.getHand().contains(card));

        res = hand.removeCard(new ClanCard(Color.BLUE, 1));
        assertEquals(res, 1);


    }

}