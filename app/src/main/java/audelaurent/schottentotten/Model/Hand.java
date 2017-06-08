package audelaurent.schottentotten.Model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Aude on 01/06/2017.
 */

public class Hand {
    private static final String TAG = "Hand";
    private ArrayList<ClanCard> hand;
    private int maxCard;

    public Hand (){
        hand = new ArrayList<>();
        maxCard = 6;

        hand.add(new ClanCard(Color.GRAY, 6));
        hand.add(new ClanCard(Color.GREEN, 1));
        hand.add(new ClanCard(Color.BLUE, 2));
        hand.add(new ClanCard(Color.RED, 3));
        hand.add(new ClanCard(Color.YELLOW, 6));
        hand.add(new ClanCard(Color.PURPLE, 5));
    }

    public ArrayList<ClanCard> getHand() {
        return hand;
    }

    public void setHand(ArrayList<ClanCard> hand) {
        this.hand = hand;
    }

    public int getMaxCard() {
        return maxCard;
    }

    public void setMaxCard(int maxCard) {
        this.maxCard = maxCard;
    }

    /**
     * Add a card to the playerHand if there not maxCard cards yet
     * @param card the card to add
     * @return 0 if the size were under 3 and the card has been added, 1 otherwise
     */
    public int addCard(ClanCard card){
        //TODO instead of return int, exception ?
        if (hand.size() < maxCard ){
            hand.add(card);
            Log.d(TAG, "card added: " + card + "to playerHand " + this);
            return 0;
        } else {
            Log.d(TAG, "playerHand full, card cannot be added");
            return 1;
        }
    }

    /**
     * Delete the card card from the playerHand
     * @param card the card to remove
     * @return 0 if the card has been found and removed, 1 otherwise
     */
    public int removeCard(ClanCard card){
        int res = 1;
        for (ClanCard c: hand){
            if(c.getValue() == card.getValue() && c.getColor() == c.getColor()){
                hand.remove(c);
                res = 0;
                break;
            }
        }
        return res;
    }

}
