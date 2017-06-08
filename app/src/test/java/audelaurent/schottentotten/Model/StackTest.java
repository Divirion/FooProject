package audelaurent.schottentotten.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static audelaurent.schottentotten.Model.Color.BLUE;
import static audelaurent.schottentotten.Model.Color.GRAY;
import static audelaurent.schottentotten.Model.Color.YELLOW;
import static org.junit.Assert.*;

/**
 * Created by Aude on 28/05/2017.
 */
public class StackTest {

    Stack stackTest;

    @Before
    public void setUp() throws Exception {
        stackTest = new Stack();
    }

    @Test
    public void initializeStacks() throws Exception {
        stackTest.initializeStacks();
        assertNotNull(stackTest.getClanStack());
        assert(stackTest.getClanStack().size() == 54);
    }

    @Test
    public void pickCard() throws Exception {
        stackTest.initializeStacks();
        Card cardExcpected = stackTest.getClanStack().get(0);
        Card cardReturned = stackTest.pickCard(stackTest.getClanStack());
        assertEquals(cardExcpected, cardReturned);
        assertFalse(stackTest.getClanStack().contains(cardExcpected));
    }

}