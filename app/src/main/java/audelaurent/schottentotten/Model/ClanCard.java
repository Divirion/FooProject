package audelaurent.schottentotten.Model;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import audelaurent.schottentotten.R;

/**
 * Created by Aude on 28/05/2017.
 */

public class ClanCard extends Card{
    protected int value;
    protected Color color;

    public ClanCard(Color color, int value) {
        this.value = value;
        this.color = color;


    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
