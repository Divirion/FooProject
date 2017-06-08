package audelaurent.schottentotten.Controler;

import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;

import audelaurent.schottentotten.R;

/**
 * Created by Aude on 05/06/2017.
 */

public class BoardClickListener implements View.OnClickListener, View.OnLongClickListener, View.OnDragListener {
    private static final String TAG = "BoardClickListener";

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick board RV");


    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event){
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:

                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);


                // Invalidates the view to force a redraw
                v.invalidate();

                // Returns true. DragEvent.getResult() will return true.
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                break;
            default:
                break;
        }
        return false;
    }
}
