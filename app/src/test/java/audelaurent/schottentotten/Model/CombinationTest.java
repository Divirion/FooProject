package audelaurent.schottentotten.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aude on 29/05/2017.
 */
public class CombinationTest {
    Combination combin1 ;
    Combination combin2 ;

    @Before
    public void setUp() throws Exception {
        combin1 = new Combination();
        combin2 = new Combination();
    }

    @Test
    public void bestCombin() throws Exception {
        Combination res;

        //Test combin1 != combin2 && combin1 > combin2
        makeCombin(combin1, TypeCombination.STRAIGHTFLUSH);
        makeCombin(combin2, TypeCombination.THREEKIND);
        res = combin1.bestCombin(combin2);
        assertEquals(res, combin1);

        //Test combin& != combin2 && combin1 < combin2
        makeCombin(combin1, TypeCombination.SUM);
        makeCombin(combin2, TypeCombination.FLUSH);
        res = combin1.bestCombin(combin2);
        assertEquals(res, combin2);

        //Test combin1 == combin2 == SUM && sum of combin1 == sum of combin2
        makeCombin(combin1, TypeCombination.SUM);
        makeCombin(combin2, TypeCombination.SUM);
        res = combin1.bestCombin(combin2);
        assertEquals(res, null);

        //Test combin1 == combin2 == SUM && sum of combin1 < sum of combin2
        combin1.clearCombination();
        combin1.addCard(new ClanCard(Color.YELLOW, 1));
        combin1.addCard(new ClanCard(Color.GREEN, 2));
        combin1.addCard(new ClanCard(Color.BLUE, 4));
        combin2.clearCombination();
        combin2.addCard(new ClanCard(Color.YELLOW, 5));
        combin2.addCard(new ClanCard(Color.GREEN, 8));
        combin2.addCard(new ClanCard(Color.BLUE, 7));
        res = combin1.bestCombin(combin2);
        assertEquals(res, combin2);

        //Test combin1 == combin2 == STRAIGHT && combin1 >  combin2
        combin1.clearCombination();
        combin1.addCard(new ClanCard(Color.YELLOW, 6));
        combin1.addCard(new ClanCard(Color.GREEN, 7));
        combin1.addCard(new ClanCard(Color.BLUE, 8));
        combin2.clearCombination();
        combin2.addCard(new ClanCard(Color.YELLOW, 2));
        combin2.addCard(new ClanCard(Color.GREEN, 3));
        combin2.addCard(new ClanCard(Color.BLUE, 4));
        res = combin1.bestCombin(combin2);
        assertEquals(res, combin1);

        //Test combin1 == combin2 == FLUSH && combin1 <  combin2
        combin1.clearCombination();
        combin1.addCard(new ClanCard(Color.YELLOW, 1));
        combin1.addCard(new ClanCard(Color.GREEN, 1));
        combin1.addCard(new ClanCard(Color.BLUE, 1));
        combin2.clearCombination();
        combin2.addCard(new ClanCard(Color.YELLOW, 4));
        combin2.addCard(new ClanCard(Color.GREEN, 4));
        combin2.addCard(new ClanCard(Color.BLUE, 4));
        res = combin1.bestCombin(combin2);
        assertEquals(res, combin2);


    }

    @Test
    public void addCard() throws Exception {
        assertEquals(combin1.getCombin().size(), 0);
        int code = combin1.addCard(new ClanCard(Color.YELLOW, 3));
        assertEquals(combin1.getCombin().size(), 1);
        assertEquals(code, 0);

        code = combin1.addCard(new ClanCard(Color.GRAY, 1));
        assertEquals(combin1.getCombin().size(), 2);
        assertEquals(code, 0);

        code = combin1.addCard(new ClanCard(Color.GREEN, 3));
        assertEquals(combin1.getCombin().size(), 3);
        assertEquals(code, 0);

        code = combin1.addCard(new ClanCard(Color.BLUE, 6));
        assertEquals(combin1.getCombin().size(), 3);
        assertEquals(code, 1);
    }

    @Test
    public void computeType() throws Exception {

        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.INCOMPLETE);

        makeCombin(combin1, TypeCombination.FLUSH);
        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.FLUSH);

        makeCombin(combin1, TypeCombination.INCOMPLETE);
        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.INCOMPLETE);

        makeCombin(combin1, TypeCombination.THREEKIND);
        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.THREEKIND);

        makeCombin(combin1, TypeCombination.STRAIGHTFLUSH);
        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.STRAIGHTFLUSH);

        makeCombin(combin1, TypeCombination.STRAIGHT);
        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.STRAIGHT);

        makeCombin(combin1, TypeCombination.SUM);
        combin1.computeType();
        assertEquals(combin1.getType(), TypeCombination.SUM);

    }

    private void makeCombin (Combination combin, TypeCombination type){
        combin.clearCombination();
        switch(type){
            case INCOMPLETE:
                combin.addCard(new ClanCard(Color.YELLOW, 3));
                combin.addCard(new ClanCard(Color.GREEN, 3));
                break;
            case SUM:
                combin.addCard(new ClanCard(Color.YELLOW, 3));
                combin.addCard(new ClanCard(Color.GREEN, 5));
                combin.addCard(new ClanCard(Color.BLUE, 7));
                break;
            case STRAIGHT:
                combin.addCard(new ClanCard(Color.YELLOW, 5));
                combin.addCard(new ClanCard(Color.GREEN, 3));
                combin.addCard(new ClanCard(Color.BLUE, 4));
                break;
            case FLUSH:
                combin.addCard(new ClanCard(Color.YELLOW, 1));
                combin.addCard(new ClanCard(Color.YELLOW, 9));
                combin.addCard(new ClanCard(Color.YELLOW, 7));
                break;
            case THREEKIND:
                combin.addCard(new ClanCard(Color.YELLOW, 3));
                combin.addCard(new ClanCard(Color.GREEN, 3));
                combin.addCard(new ClanCard(Color.GRAY, 3));
                break;
            case STRAIGHTFLUSH:
                combin.addCard(new ClanCard(Color.YELLOW, 8));
                combin.addCard(new ClanCard(Color.YELLOW, 9));
                combin.addCard(new ClanCard(Color.YELLOW, 7));
                break;
        }
    }

}