package edu.fitchburgstate.staylor.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Stephen Taylor on 4/21/15.
 */
public class WorldView extends View {
    /**
     * this constructor used when WorldView inflated from xml file
     * @param c
     * @param attrs
     * @param x
     */
    public WorldView(Context c, AttributeSet attrs, int x){
        super(c,attrs,x);
    }
    /**
     * this constructor used when WorldView inflated from xml file
     * @param c
     * @param attrs
     */
    public WorldView(Context c, AttributeSet attrs){
        super(c,attrs);
    }

    /**
     * some variables to describe the moving circle.
     */
    float bx = 100; // center of circle
    float by = 150;
    int br = 40;  // radius
    boolean first = true;
    Paint paint = new Paint();

    public void onDraw(Canvas c){
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        c.drawCircle(bx, by, br, paint);

    }

    public boolean insideCircle(float x, float y) {
        if ((bx-x)*(bx-x) + (by-y)*(by-y) <= br*br) return true;
        return false;
    }
}
