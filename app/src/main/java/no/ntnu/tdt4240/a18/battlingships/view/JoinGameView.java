package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

public class JoinGameView extends Activity {
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
    public void begin(View view) {
        Intent intent = new Intent(this, MapView.class);
        startActivity(intent);
        /*
        String[] values = aController.getNet().getPlayerlist();
        valuelist.clear();
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();   */
    }
}
