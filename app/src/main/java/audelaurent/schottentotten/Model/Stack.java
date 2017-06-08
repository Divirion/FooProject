package audelaurent.schottentotten.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aude on 28/05/2017.
 */

public class Stack {

    private static final String TAG = "Stack";
    ArrayList<ClanCard> clanStack = new ArrayList<>();


    public Stack() {
    }

    public ArrayList<ClanCard> getClanStack() {
        return clanStack;
    }

    public void setClanStack(ArrayList<ClanCard> clanStack) {
        this.clanStack = clanStack;
    }

    /**
     * Add all the cards to the stack and shuffle them
     */
    public void initializeStacks(){
        for(Color col: Color.values()){
            for (int i=0; i<9; i++){
                clanStack.add(new ClanCard(col, i+1));
            }
        }
        Collections.shuffle(clanStack);
        Log.d(TAG, "stack shuffled" + clanStack);
    }

    /**
     * Return the first card on the stack and delete it from the stack
     * @param stack the stack where to pick a card
     * @return the card picked i.e. the first card on the stack
     */
    public Card pickCard( ArrayList<? extends Card> stack){
        if(!stack.isEmpty()){
            Card temp = stack.get(0);
            stack.remove(0);
            Log.d(TAG, "card removed:" + temp);
            return temp;
        } else {
            return null;
        }
    }

}
