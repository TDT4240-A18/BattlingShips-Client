package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

        // TODO: need to find the playerlist somewhere else, maybe directly from the response
        String[] values = null;// aController.getNet().getPlayerlist();
        valuelist = new ArrayList<String>();
        valuelist.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, valuelist);
        listView.setAdapter(adapter);
        if (!aController.getPlayer().toString().equals("")) {
            join.setVisibility(View.INVISIBLE);
        }
        HTTPRequest.addListener(this);
    }

    public void joinGame(View view) {
        String username = name.getText().toString();
        if (null != username && username.length() > 0) {
            aController.getNet().join(username);
            if (!valuelist.contains(username + " : false") && !valuelist.contains(username + " : true")) {
                aController.getPlayer().setUsername(username);
                join.setVisibility(View.INVISIBLE);
            }
            //adapter.add(testa);
            //listView.setAdapter(adapter);
        }
    }

    public void getReady(View view) {
        aController.getNet().ready(aController.getPlayer().toString());
    }


    //TODO: remove the button altogether when it is no longer needed
    public void begin(View view) {
        Intent intent = new Intent(this, MapView.class);
        startActivity(intent);
        /*
        String[] values = aController.getNet().getPlayerlist();
        valuelist.clear();
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();   */
    }

    //listeners:


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
    @Override public void newPlayerJoined(String list) {
        String[] values = list.substring(1, list.length() - 1).split(",");
        valuelist.clear();
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
        // TODO:
        //set board as the board
        //find own position and then create the ship inside player
        //set visibilty for player

        //move to MapView
        Intent intent = new Intent(this, MapView.class);
        startActivity(intent);

    }

    /**
     * which player is on action: the player can do an action
     * <p/>
     * player name + board
     *
     * @param jsonObject
     */
    @Override public void onAction(JSONObject jsonObject) {

    }

    /**
     * a player is dead
     *
     * @param name : name of the player
     */
    @Override public void aPlayerDead(String name) {

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

    }

    /**
     * all responses from the server
     *
     * @param jsonObject
     */
    @Override public void response(JSONObject jsonObject) {

    }

    @Override protected void onDestroy() {
        aController.getNet().leave(aController.getPlayer().toString());
        super.onDestroy();
    }
}
