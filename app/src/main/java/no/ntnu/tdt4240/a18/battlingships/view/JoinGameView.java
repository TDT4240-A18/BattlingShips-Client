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
        name =(EditText) findViewById(R.id.editText1);
        listView = (ListView) findViewById(R.id.listView);
        name.setText(aController.getPlayer().toString());

        // TODO: need to find the playerlist somewhere else, maybe directly from the response
        String[] values = aController.getNet().getPlayerlist();
        valuelist = new ArrayList<String>();
        valuelist.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,valuelist);
        listView.setAdapter(adapter);
        if (!aController.getPlayer().toString().equals("")){
            join.setVisibility(View.INVISIBLE);
        }
    }

    public void joinGame(View view){
        String username = name.getText().toString();
        if(null!=username&&username.length()>0){
            aController.getNet().join(username);
            if (!valuelist.contains(username+" : false")&& !valuelist.contains(username+" : true")) {
                aController.getPlayer().setUsername(username);
                join.setVisibility(View.INVISIBLE);
            }
            //adapter.add(testa);
            //listView.setAdapter(adapter);
        }
    }
    public void getReady(View view){
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

    public void response(JSONObject JsonObj){

    }

    public void newPlayerJoinedGame(String list){
        String[] values = list.substring(1,list.length()-1).split(",");
        valuelist.clear();
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();
    }

    public void readyStatus(String list){
        String[] values = list.substring(1,list.length()-1).split(",");
        valuelist.clear();
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();
    }

    public void gameStarted(String[][] board){

        // TODO:
        //find own position and then create the ship inside player
        //set visibilty for player
        //set board as the board
        //move to MapView
    }
}
