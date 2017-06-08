package audelaurent.schottentotten.Controler;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Typeface;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import audelaurent.schottentotten.GameActivity;

/**
 * Created by Aude on 05/06/2017.
 */

public class HandClickListener implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, View.OnDragListener {
    private static final String TAG = "HandClickListener";
    float dX, dY;

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick hand RV");

    }

    @Override
    public boolean onLongClick(View v) {

        ClipData.Item item = new ClipData.Item(v.getTag().toString());
        Log.d(TAG, "tag dragged " + v.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        ClipData dragData = new ClipData((CharSequence)v.getTag().toString(), new String[]{ ClipDescription.MIMETYPE_TEXT_PLAIN } , item);


        // Instantiates the drag shadow builder.
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

        // Starts the drag

        v.startDrag(dragData,  // the data to be dragged
                myShadow,  // the drag shadow builder
                null,      // no need to use local data
                0          // flags (not currently used, set to 0)
        );

       /* v.startDragAndDrop(dragData,myShadow,null,0);*/
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event){
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(TAG, " ---- Drag Started ----");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(TAG, " ---- Drag Exited ----");
                break;
            case DragEvent.ACTION_DROP:

                Log.d(TAG, " ---- Drag Dropped ----");
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);


                // Invalidates the view to force a redraw
                v.invalidate();

                // Returns true. DragEvent.getResult() will return true.
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                //Log.d(TAG, " ---- Drag Ended ----");
                //Log.d(TAG,"Id is " + v.getId());
                break;
            default:
                break;
        }
        return false;
    }


}