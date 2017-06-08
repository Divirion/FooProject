package audelaurent.schottentotten.Controler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import audelaurent.schottentotten.R;

/**
 * Created by Aude on 05/06/2017.
 */

public class HandViewHolder extends RecyclerView.ViewHolder {
    public TextView cardhand;


    public HandViewHolder(View view) {
        super(view);
        cardhand = (TextView) view.findViewById(R.id.cardhand);
    }
}