package audelaurent.schottentotten.Controler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import audelaurent.schottentotten.GameActivity;
import audelaurent.schottentotten.Model.ClanCard;
import audelaurent.schottentotten.Model.Color;
import audelaurent.schottentotten.Model.Game;
import audelaurent.schottentotten.Model.Hand;
import audelaurent.schottentotten.R;

import static audelaurent.schottentotten.R.layout.hand_list;


/**
 * Created by Aude on 05/06/2017.
 */

public class HandAdapter extends RecyclerView.Adapter<HandViewHolder>  {
    private Hand hand;

    public HandAdapter(Game game) {
        this.hand = game.getThisPlayer().getPlayerHand();
    }

    @Override
    public HandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(hand_list, parent, false);
      /*  HandClickListener hcl = new HandClickListener();
        itemView.setOnClickListener(hcl);
        itemView.setTag("abc");
        itemView.setOnLongClickListener(hcl);
        //itemView.setOnTouchListener(hcl);
        itemView.setOnDragListener(hcl);*/
        return new HandViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HandViewHolder holder, int position) {
        Context cont = holder.cardhand.getContext();
        ClanCard card = hand.getHand().get(position);
        holder.cardhand.setText(""+card.getValue());
        holder.cardhand.setTag(position);
        HandClickListener hcl = new HandClickListener();
        holder.cardhand.setOnClickListener(hcl);
        holder.cardhand.setOnLongClickListener(hcl);
        //itemView.setOnTouchListener(hcl);
        holder.cardhand.setOnDragListener(hcl);

        Drawable background = holder.cardhand.getBackground();
        ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));

    }

    @Override
    public int getItemCount() {
        return hand.getHand().size();
    }

    private int colorEnum2Int(Color c){
        switch(c){
            case YELLOW:
                return R.color.card_yellow;
            case GRAY:
                return R.color.card_gray;
            case GREEN:
                return R.color.card_green;
            case RED:
                return R.color.card_red;
            case BLUE:
                return R.color.card_blue;
            case PURPLE:
                return R.color.card_purple;
        }
        return R.color.card_default;
    }

}
