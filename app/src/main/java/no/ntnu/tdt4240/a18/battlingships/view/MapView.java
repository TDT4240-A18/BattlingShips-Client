package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;
import no.ntnu.tdt4240.a18.battlingships.model.ActionListener;
import no.ntnu.tdt4240.a18.battlingships.model.HTTPRequest;

public class MapView extends Activity implements ActionListener {

    public static final int DISPLAYED_MSGS_CNT = 3;

    private ArrayList<String> messages = new ArrayList<>();
    private ShipController aController;
    private Button action;
    private int deadPlayers=0;

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

    private Button[][] allButtons = {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}};

    private Boolean[][] visible;
    private String[][] board;

    private String currentPlayer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        aController = (ShipController) getApplicationContext();
        visible = aController.getPlayer().getVisibility();
        board = aController.getBoard().getBoard();
        action = (Button) findViewById(R.id.actionButton);
        action.setVisibility(View.INVISIBLE);

        x0y0 = (Button) findViewById(R.id.button0_0);
        allButtons[0][0] = x0y0;
        x0y1 = (Button) findViewById(R.id.button0_1);
        allButtons[0][1] = (x0y1);
        x0y2 = (Button) findViewById(R.id.button0_2);
        allButtons[0][2] = (x0y2);
        x0y3 = (Button) findViewById(R.id.button0_3);
        allButtons[0][3] = (x0y3);
        x1y0 = (Button) findViewById(R.id.button1_0);
        allButtons[1][0] = (x1y0);
        x1y1 = (Button) findViewById(R.id.button1_1);
        allButtons[1][1] = (x1y1);
        x1y2 = (Button) findViewById(R.id.button1_2);
        allButtons[1][2] = (x1y2);
        x1y3 = (Button) findViewById(R.id.button1_3);
        allButtons[1][3] = (x1y3);
        x2y0 = (Button) findViewById(R.id.button2_0);
        allButtons[2][0] = (x2y0);
        x2y1 = (Button) findViewById(R.id.button2_1);
        allButtons[2][1] = (x2y1);
        x2y2 = (Button) findViewById(R.id.button2_2);
        allButtons[2][2] = (x2y2);
        x2y3 = (Button) findViewById(R.id.button2_3);
        allButtons[2][3] = (x2y3);
        x3y0 = (Button) findViewById(R.id.button3_0);
        allButtons[3][0] = (x3y0);
        x3y1 = (Button) findViewById(R.id.button3_1);
        allButtons[3][1] = (x3y1);
        x3y2 = (Button) findViewById(R.id.button3_2);
        allButtons[3][2] = (x3y2);
        x3y3 = (Button) findViewById(R.id.button3_3);
        allButtons[3][3] = (x3y3);

        updateBoard();
        addMessage(this.getString(R.string.game_JoinMessage));
        scaleMapTiles();
        HTTPRequest.addListener(this);
    }

    //updates the colors for the buttons
    public void updateBoard() {
        board = aController.getBoard().getBoard();
        visible = aController.getPlayer().getVisibility();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //set fog if player is alive, if not then allow player to see everything
                if (visible[i][j] == false && aController.getPlayer().getDead() == false) {
                    allButtons[i][j].setBackgroundColor(Color.GRAY);
                } else {
                    System.out.println(board[i][j]);
                    if (board[i][j].equals("null")) {
                        allButtons[i][j].setBackgroundColor(Color.BLUE);
                        allButtons[i][j].setText("");
                    } else {
                        if (board[i][j].equals(aController.getPlayer().toString())) {
                            allButtons[i][j].setBackgroundColor(Color.GREEN);
                            allButtons[i][j].setText(board[i][j]);
                        } else {
                            allButtons[i][j].setBackgroundColor(Color.RED);
                            allButtons[i][j].setText(board[i][j]);
                        }
                    }
                }
            }
        }
    }

    /**
     * Called when the user clicks the "Ending View" button
     */
    public void endGame(View view) {
        System.out.println(aController.getPlayer().getShip().getPosX() + " , " + aController.getPlayer().getShip().getPosY());
    }

    public void goToAction(View view) {
        Intent intent = new Intent(this, ActionView.class);
        startActivity(intent);
    }

    private void addMessage(String newMsg) {
        if (newMsg == null) { return; }

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss]");
        messages.add(df.format(c.getTime()) + ' ' + newMsg);

        LinearLayout msgLayout = (LinearLayout) findViewById(R.id.gameLog);
        msgLayout.removeAllViewsInLayout();

        int displayed_msgs_cnt = 0;

        for (int emptyLines = DISPLAYED_MSGS_CNT - messages.size(); emptyLines > 0;
             emptyLines--, displayed_msgs_cnt++) {

            TextView tv = new TextView(getApplicationContext());
            msgLayout.addView(tv);
        }

        for (int msg_index = messages.size() - 1; displayed_msgs_cnt < DISPLAYED_MSGS_CNT;
             msg_index--, displayed_msgs_cnt++) {

            TextView tv = new TextView(getApplicationContext());
            tv.setTextColor(Color.rgb(0, 255, 30));
            tv.setText(messages.get(msg_index));
            msgLayout.addView(tv);
        }
    }

    /**
     * This function scales all the buttons to the screen size with keeping tiles squared.
     * <p/>
     * For now it should stretch buttons to max size according to width only! So it can overflow!
     */
    private void scaleMapTiles() {
        LinearLayout gameMap = (LinearLayout) findViewById(R.id.gameMap);
        int size = gameMap.getWidth() / 4;

        for (int i = 0; i < gameMap.getChildCount(); i++) {
            LinearLayout row = (LinearLayout) gameMap.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                Button btn = (Button) row.getChildAt(j);
                btn.setWidth(size);
                btn.setHeight(size);
            }
        }

    }

    /*
    @Override protected void onDestroy() {
        aController.getNet().leave(aController.getPlayer().toString());
        super.onDestroy();
    }
    */
    /**
     * tell if there is a game at the server
     *
     * @param b
     */
    @Override public void isThereAgame(boolean b) {}

    /**
     * a new player joined the game
     *
     * @param list
     */
    @Override public void joinedPlayers(String list) {}

    /**
     * list of players ready status
     *
     * @param list (playerName:boolean)
     */
    @Override public void readyStatus(String list) {}

    /**
     * report that the game is start now:
     * <p/>
     * report only once when the game start.
     *
     * @param board : initial board
     */
    @Override public void gameStarted(String board) {}

    /**
     * which player is on action: the player can do an action
     * <p/>
     * player name + board
     *
     * @param playerName
     * @param board
     */
    @Override public void onPlayer(String playerName, String board) {
        //        //TODO set current player
        if (!currentPlayer.equals(playerName.split(":")[0])) {
            currentPlayer = playerName.split(":")[0];
            String[] test = board.substring(1).split(":");
            String[][] tempBoard = {{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}};
            String[] test3;
            for (int i = 0; i < 4; i++) {
                test3 = test[i].substring(1, test[i].length() - 2).split(";");
                for (int j = 0; j < 4; j++) {
                    tempBoard[i][j] = test3[j];
                    if (tempBoard[i][j].equals(aController.getPlayer().toString())) {
                        //find own position and then create the ship inside player
                        aController.getPlayer().createShip(j, i);
                    }
                }
            }
            aController.getBoard().setBoard(tempBoard);
            addMessage(currentPlayer + "! It is your turn");
            aController.getPlayer().canSee();
            updateBoard();
        }

                if (aController.getPlayer().toString().equals(playerName.split(":")[0])){
                    action.setVisibility(View.VISIBLE);
                }
                else {action.setVisibility(View.INVISIBLE);}
                //set board as new board and update visibility
    }

    /**
     * tell the current game state
     * <p/>
     * game state based on sum of players actions
     * <p/>
     * first move start with 1
     *
     * @param state
     */
    @Override public void gameState(int state) {

    }

    /**
     * a player list with active players:
     * <p/>
     * <li>players not dead</li> <li>players not left the game</li>
     *
     * @param activePlayers
     */
    @Override public void activePlayerList(String activePlayers) {

    }

    /**
     * a player list with inactive players:
     * <p/>
     * <li>players are dead</li> <li>players that left the game</li>
     *
     * @param inactivePlayers
     */
    @Override public void inactivePlayerList(String inactivePlayers) {
        //TODO: check if player is in list, set iDied if that is the case and send a message
        if (deadPlayers == inactivePlayers.substring(1, inactivePlayers.length()-1).split(",").length){
            String[] players = inactivePlayers.substring(1, inactivePlayers.length() - 1).split(",");
            if (aController.getPlayer().getDead() == false) {
                boolean iDead = false;
                for (int b = 0; b < players.length; b++) {
                    if (players[b].split(":")[0].equals(aController.getPlayer().toString())) {
                        iDead = true;
                        aController.getPlayer().iDied();
                        addMessage("Too bad "+ aController.getPlayer().toString() + ", you have died");
                        break;
                    }
                }
                if (!iDead){
                    addMessage("Oh my, " + players[players.length-1].split(":")[0] + " has died");
                }
            }
            else{ addMessage("Oh my, " + players[players.length-1].split(":")[0] + " has died");}
        }
    }


    //    @Override public void aPlayerDead(String name) {
    //        if (aController.getPlayer().toString() == name){
    //            aController.getPlayer().iDied();
    //            addMessage("Oh noes D: Seems your ship got sunk");
    //        }
    //    }

    /**
     * game Finished
     *
     * @param reason : why game is gameFinished
     */
    @Override public void gameFinished(String reason) {
        //TODO go to the endingscreen with a message saying who won
        aController.getBoard().setWinReason(reason);
        Intent intent = new Intent(this, EndingView.class);
        startActivity(intent);
    }

    /**
     * the join result for a player to join the game
     *
     * @param result
     */
    @Override public void joinResult(String result) {

    }

    /**
     * all responses from the server
     *
     * @param jsonObject
     */
    @Override public void response(JSONObject jsonObject) {

    }
}
