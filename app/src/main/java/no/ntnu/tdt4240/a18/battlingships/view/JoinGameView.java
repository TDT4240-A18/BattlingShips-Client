package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;
import no.ntnu.tdt4240.a18.battlingships.model.ActionListener;
import no.ntnu.tdt4240.a18.battlingships.model.HTTPRequest;

public class JoinGameView extends Activity implements ActionListener {
    ListView listView;
    EditText name;
    ShipController aController;
    ArrayAdapter<String> adapter;
    ArrayList<String> valuelist;
    Button begin;
    Button join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game_view);
        aController = (ShipController) getApplicationContext();
        begin = (Button) findViewById(R.id.button5);
        join = (Button) findViewById(R.id.button2);
        name = (EditText) findViewById(R.id.editText1);
        listView = (ListView) findViewById(R.id.listView);
        name.setText(aController.getPlayer().toString());
        String[] values = aController.getBoard().getPlayerList();
        valuelist = new ArrayList<String>();
        valuelist.add("Players:Status");
        valuelist.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, valuelist);
        listView.setAdapter(adapter);
        if (!aController.getPlayer().toString().equals("")) {
            join.setVisibility(View.INVISIBLE);
            name.setInputType(InputType.TYPE_NULL);
        }
        HTTPRequest.addListener(this);
    }

    public void joinGame(View view) {
        String username = name.getText().toString();
        if (null != username && username.length() > 0) {
            aController.getNet().join(username);
            aController.getPlayer().setUsername(username);
        } else {
            Toast toast = Toast.makeText(this, "Please enter a name!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }


    public void getReady(View view) {
        if (join.getVisibility()==View.INVISIBLE){
            aController.getNet().ready(aController.getPlayer().toString());
        }
    }

    public void leave(View view) {
        if (join.getVisibility()==View.INVISIBLE){
            aController.getNet().leave(aController.getPlayer().toString());
            aController.getPlayer().setUsername("");
            join.setVisibility(View.VISIBLE);
            name.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        }
    }

    //listeners:


    /**
     * tell if there is a game at the server
     *
     * @param b
     */
    @Override public void isThereAgame(boolean b) {
        //might be redundant to have this check here might wanna test
        //if(!b){
        //    Intent intent = new Intent(this, CreateNewGame.class);
        //    startActivity(intent);
        //}
    }

    /**
     * a new player joined the game
     *
     * @param list
     */
    @Override public void joinedPlayers(String list) {
        String[] values = list.substring(1, list.length() - 1).split(",");
        valuelist.clear();
        valuelist.add("Players:Status");
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();
    }


    /**
     * list of players ready status
     *
     * @param list (playerName:boolean)
     */
    @Override public void readyStatus(String list) {
        String[] values = list.substring(1, list.length() - 1).split(",");
        valuelist.clear();
        valuelist.add("Players:Status");
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();
    }

    /**
     * report that the game is start now:
     * <p/>
     * report only once when the game start.
     *
     * @param board : initial board
     */
    @Override public void gameStarted(String board) {
        String[] test = board.substring(1).split(":");
        String[][] tempBoard = {{null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}};
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
        //set board as the board
        aController.getBoard().setBoard(tempBoard);
        //set visibilty for player
        aController.getPlayer().canSee();
        if (aController.getPlayer().getShip()==null){
            aController.getPlayer().iDied();
        }
        //move to MapView
        if (!aController.getBoard().getGamebegun()) {
            aController.getBoard().setgameBegun();
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }

    }

    /**
     * which player is on action: the player can do an action
     * <p/>
     * player name + board
     *
     * @param playerName
     * @param board
     */
    @Override public void onPlayer(String playerName, String board) {

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

    }

    /**
     * game Finished
     *
     * @param reason : why game is gameFinished
     */
    @Override public void gameFinished(String reason) {

    }

    /**
     * the join result for a player to join the game
     *
     * @param result
     */
    @Override public void joinResult(String result) {

        if (result.equals("success")) {
            join.setVisibility(View.INVISIBLE);
            name.setInputType(InputType.TYPE_NULL);
        }
        else if(result.contains("not join after")){
            aController.getPlayer().iDied();
            aController.getPlayer().setUsername("");
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(this, result, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }

    /**
     * all responses from the server
     *
     * @param jsonObject
     */
    @Override public void response(JSONObject jsonObject) {

    }

    //if the app is exited
    @Override protected void onDestroy() {
        //player leaves the game
        aController.getNet().leave(aController.getPlayer().toString());
        super.onDestroy();
    }

    @Override protected void onResume() {
        HTTPRequest.addListener(this);
        super.onResume();
    }

    @Override protected void onPause() {
        HTTPRequest.removeListener(this);
        super.onPause();
    }
}
