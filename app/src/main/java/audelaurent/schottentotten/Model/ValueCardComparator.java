package audelaurent.schottentotten.Model;

import java.util.Comparator;

/**
 * Created by Aude on 29/05/2017.
 */

class ValueCardComparator implements Comparator<ClanCard> {
    @Override
    public int compare(ClanCard card1, ClanCard card2) {
        int card1value = card1.getValue();
        int card2value = card2.getValue();

        if (card1value > card2value) {
            return 1;
        } else if (card1value < card2value) {
            return -1;
        } else {
            return 0;
        }
    }

}
