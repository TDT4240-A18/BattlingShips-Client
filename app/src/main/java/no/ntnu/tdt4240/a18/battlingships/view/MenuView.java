package no.ntnu.tdt4240.a18.battlingships.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by EirikZimmer on 17/03/2015.
 */

public class MenuView extends View{
    private Paint paint =new Paint();

    public MenuView(Context context) {
        super(context);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
    }


    public void draw(android.graphics.Canvas canvas){
        canvas.drawRect(new Rect(50,50,50,50),paint);
    }
    public void update(float dt) {

    }
}
