package audelaurent.schottentotten.Controler;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import audelaurent.schottentotten.R;

/**
 * Created by Aude on 04/06/2017.
 */

public class BoardViewHolder extends RecyclerView.ViewHolder {
    public TextView cardup1;
    public TextView cardup2;
    public TextView cardup3;
    public TextView carddown1;
    public TextView carddown2;
    public TextView carddown3;
    public ConstraintLayout constraintLayout;


    public BoardViewHolder(View view) {
        super(view);
        cardup1 = (TextView) view.findViewById(R.id.cardup1);
        cardup2 = (TextView) view.findViewById(R.id.cardup2);
        cardup3 = (TextView) view.findViewById(R.id.cardup3 );
        carddown1 = (TextView) view.findViewById(R.id.carddown1 );
        carddown2 = (TextView) view.findViewById(R.id.carddown2 );
        carddown3 = (TextView) view.findViewById(R.id.carddown3 );
        constraintLayout = (ConstraintLayout) view.findViewById(R.id.borneToFight);
    }
}
