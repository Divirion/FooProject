package audelaurent.schottentotten.Model;

import java.util.ArrayList;

/**
 * Created by Aude on 01/06/2017.
 */

public class Board {
    private static final String TAG = "Board";
    private ArrayList<Combination> stones;
    public static int nb_of_stones = 9;

    public Board (){
        stones = new ArrayList<>(nb_of_stones);
        for (int i=0; i<nb_of_stones; i++){
            stones.add(new Combination());
        }
    }

    public ArrayList<Combination> getStones() {
        return stones;
    }

    public void setStones(ArrayList<Combination> stones) {
        this.stones = stones;
    }
}
