package audelaurent.schottentotten.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aude on 28/05/2017.
 */

public class Combination {
    private static final String TAG = "Combination";
    private ArrayList<ClanCard> combin;
    private TypeCombination type;

    public Combination() {
        combin = new ArrayList<>();
        type = TypeCombination.INCOMPLETE;

    }

    public TypeCombination getType() {
        return type;
    }

    public void setType(TypeCombination type) {
        this.type = type;
    }

    public ArrayList<ClanCard> getCombin() {
        return combin;
    }

    public void setCombin(ArrayList<ClanCard> combin) {
        this.combin = combin;
    }

    /**
     * Add a card to the combination if there not 3 cards yet
     * @param card the card to add
     * @return 0 if the size were under 3 and the card has been added, 1 otherwise
     */
    public int addCard(ClanCard card){
        //TODO instead of return int, exception ?
        if (combin.size() < 3 ){
            combin.add(card);
            Log.d(TAG, "card added: " + card + "to combination " + this);
            return 0;
        } else {
            Log.d(TAG, "combination full, card cannot be added");
            return 1;
        }
    }

    /**
     * Clear the combination
     */
    public void clearCombination(){
        combin.clear();
    }

    /**
     * Compute and return the best combination between
     * @param other The other combination
     * @return The best combination or null if the two combination are equal
     */
    public Combination bestCombin(Combination other){
        this.computeType();
        other.computeType();
        TypeCombination t1 = this.getType();
        TypeCombination t2 = other.getType();

        if(t1.compareTo(t2) < 0) {
            return this;
        } else if(t1.compareTo(t2) > 0) {
            return other;
        } else if(t1.compareTo(t2)== 0){
            int s1 = this.getSum();
            int s2 = other.getSum();
            int v1 = this.getCombin().get(0).getValue();
            int v2 = other.getCombin().get(0).getValue();
            switch(t1){
                case INCOMPLETE:
                    if (s1 > s2) return this;
                    else if (s1 < s2 ) return other;
                    break;
                case SUM:
                    if (s1 > s2) return this;
                    else if (s1 < s2 ) return other;
                    break;
                case STRAIGHT:
                    if(v1 > v2 ) return this;
                    else if(v1 < v2 ) return other;
                    break;
                case FLUSH:
                    if (s1 > s2) return this;
                    else if (s1 < s2 ) return other;
                    break;
                case THREEKIND:
                    if(v1 > v2 ) return this;
                    else if(v1 < v2 ) return other;
                    break;
                case STRAIGHTFLUSH:
                    if(v1 > v2 ) return this;
                    else if(v1 < v2 ) return other;
                    break;
            }
        }

        //TODO first to complete the combination
        return null;

    }

    /**
     * Compute the sum of the cards of the combination
     * @return the sum of the cards of the combination
     */
    private int getSum (){
        int sum =0;
        for(ClanCard c: combin)
            sum += c.getValue();
        return sum;
    }

    /**
     * Determine if the combination is a Flush
     * @return boolean whether the combination is a Flush
     */
    private boolean isFlush(){
        return (combin.get(0).getColor() == combin.get(1).getColor() && combin.get(0).getColor() == combin.get(2).getColor());
    }

    /**
     * Determine if the combination is a Straight
     * @return boolean whether the combination is a Straight
     */
    private boolean isStraight (){
        return (combin.get(2).getValue() == combin.get(1).getValue()+1 && combin.get(1).getValue() == combin.get(0).getValue()+1);
    }

    /**
     * Determine if the combination is a 3-of-a-kind
     * @return boolean whether the combination is a 3-of-a-kind
     */
    private boolean isThreeKind(){
        return (combin.get(2).getValue() == combin.get(1).getValue() && combin.get(1).getValue() == combin.get(0).getValue());
    }

    /**
     * Determine if the combination is a StraightFlush
     * @return boolean whether the combination is a StraightFlush
     */
    private boolean isStraightFlush(){
        return (this.isStraight() && this.isFlush());
    }

    /**
     * Compute the type of the combination and stock it into typecombination
     */
    public void computeType(){
        Collections.sort(combin, new ValueCardComparator());
        if(combin.size() <3 ) this.setType(TypeCombination.INCOMPLETE);
        else if(this.isStraightFlush()) this.setType(TypeCombination.STRAIGHTFLUSH);
        else if(this.isThreeKind()) this.setType(TypeCombination.THREEKIND);
        else if (this.isFlush()) this.setType(TypeCombination.FLUSH);
        else if (this.isStraight()) this.setType(TypeCombination.STRAIGHT);
        else this.setType(TypeCombination.SUM);

    }

}
