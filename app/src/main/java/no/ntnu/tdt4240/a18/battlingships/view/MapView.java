package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private ShipController aController;
    private Button x0y0;
    private Button x0y1;
    private Button x0y2;
    private Button x0y3;
    private Button x1y0;
    private Button x1y1;
    private Button x1y2;
    private Button x1y3;
    private Button x2y0;
    private Button x2y1;
    private Button x2y2;
    private Button x2y3;
    private Button x3y0;
    private Button x3y1;
    private Button x3y2;
    private Button x3y3;

    private Button[][] allButtons;

    private Boolean[][]visible;
    private String[][]board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        aController = (ShipController) getApplicationContext();
        visible = aController.getPlayer().getVisibility();
        board = aController.getBoard().getBoard();
        x0y0 = (Button) findViewById(R.id.button0_0);
        allButtons[0][0]=x0y0;
        x0y1 = (Button) findViewById(R.id.button0_1);
        allButtons[0][1]=(x0y1);
        x0y2 = (Button) findViewById(R.id.button0_2);
        allButtons[0][2]=(x0y2);
        x0y3 = (Button) findViewById(R.id.button0_3);
        allButtons[0][3]=(x0y3);
        x1y0 = (Button) findViewById(R.id.button1_0);
        allButtons[1][0]=(x1y0);
        x1y1 = (Button) findViewById(R.id.button1_1);
        allButtons[1][1]=(x1y1);
        x1y2 = (Button) findViewById(R.id.button1_2);
        allButtons[1][2]=(x1y2);
        x1y3 = (Button) findViewById(R.id.button1_3);
        allButtons[1][3]=(x1y3);
        x2y0 = (Button) findViewById(R.id.button2_0);
        allButtons[2][0]=(x2y0);
        x2y1 = (Button) findViewById(R.id.button2_1);
        allButtons[2][1]=(x2y1);
        x2y2 = (Button) findViewById(R.id.button2_2);
        allButtons[2][2]=(x2y2);
        x2y3 = (Button) findViewById(R.id.button2_3);
        allButtons[2][3]=(x2y3);
        x3y0 = (Button) findViewById(R.id.button3_0);
        allButtons[3][0]=(x3y0);
        x3y1 = (Button) findViewById(R.id.button3_1);
        allButtons[3][1]=(x3y1);
        x3y2 = (Button) findViewById(R.id.button3_2);
        allButtons[3][2]=(x3y2);
        x3y3 = (Button) findViewById(R.id.button3_3);
        allButtons[3][3]=(x3y3);

        updateBoard();
        addMessage(this.getString(R.string.game_JoinMessage));
        scaleMapTiles();

        //final ShipController aController = (ShipController) getApplicationContext();
    }


    public void updateBoard(){
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                //set fog if player is alive, if not then allow player to see everything
                if (visible[i][j]==false && aController.getPlayer().getAlive()==true){
                    allButtons[i][j].setBackgroundColor(Color.GRAY);
                }
                else{
                    if (board[i][j]==null){
                        allButtons[i][j].setBackgroundColor(Color.BLUE);
                    }
                    else{
                        if (board[i][j].split(":")[0]==aController.getPlayer().toString()){
                            allButtons[i][j].setBackgroundColor(Color.GREEN);
                            allButtons[i][j].setText(board[i][j]);
                        }
                        else{
                            allButtons[i][j].setBackgroundColor(Color.RED);
                            allButtons[i][j].setText(board[i][j]);
                        }
                    }
                }
            }
        }
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

    /**
     * This function scales all the buttons to the screen size with keeping tiles squared.
     *
     * For now it should stretch buttons to max size according to width only! So it can overflow!
     */
    private void scaleMapTiles() {
        LinearLayout gameMap = (LinearLayout)findViewById(R.id.gameMap);
        int size = gameMap.getWidth()/4;

        for (int i = 0; i < gameMap.getChildCount(); i++) {
            LinearLayout row = (LinearLayout)gameMap.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                Button btn = (Button)row.getChildAt(j);
                btn.setWidth(size);
                btn.setHeight(size);
            }
        }

    }

}
