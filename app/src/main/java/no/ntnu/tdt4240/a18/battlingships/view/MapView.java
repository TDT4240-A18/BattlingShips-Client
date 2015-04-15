package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

public class MapView extends Activity {

    public static final int DISPLAYED_MSGS_CNT = 3;

    private ArrayList<String> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        addMessage(this.getString(R.string.game_JoinMessage));

        //final ShipController aController = (ShipController) getApplicationContext();
    }

    /** Called when the user clicks the "Ending View" button */
    public void endGame(View view) {
        Intent intent = new Intent(this, EndingView.class);
        startActivity(intent);
    }

    public void goToAction(View view){
        Intent intent = new Intent(this, ActionView.class);
        startActivity(intent);
    }

    private void addMessage(String newMsg) {
        if (newMsg == null) { return; }

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss]");
        messages.add(df.format(c.getTime()) + ' ' + newMsg);

        LinearLayout msgLayout = (LinearLayout)findViewById(R.id.gameLog);
        msgLayout.removeAllViewsInLayout();

        int displayed_msgs_cnt = 0;

        for (int emptyLines = DISPLAYED_MSGS_CNT - messages.size();
             emptyLines > 0;
             emptyLines--, displayed_msgs_cnt++) {

            TextView tv = new TextView(getApplicationContext());
            msgLayout.addView(tv);
        }

        for (int msg_index = messages.size() - 1;
             displayed_msgs_cnt < DISPLAYED_MSGS_CNT;
             msg_index--, displayed_msgs_cnt++) {

            TextView tv = new TextView(getApplicationContext());
            tv.setTextColor(Color.rgb(0, 255, 30));
            tv.setText(messages.get(msg_index));
            msgLayout.addView(tv);
        }
    }

}
