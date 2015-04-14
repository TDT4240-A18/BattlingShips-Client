package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
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
import no.ntnu.tdt4240.a18.battlingships.model.NetworkInterface;

public class JoinGameView extends Activity {
    ListView listView;
    EditText name;
    ShipController aController;
    ArrayAdapter<String> adapter;
    ArrayList<String> valuelist;
    Button begin;
    NetworkInterface net;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game_view);
        aController = (ShipController) getApplicationContext();
        net = NetworkInterface.getInstance(getApplicationContext());
        begin = (Button) findViewById(R.id.button5);
        name =(EditText) findViewById(R.id.editText1);
        listView = (ListView) findViewById(R.id.listView);
        String[] values = new String[]{net.getPlayerlist()};
        valuelist = new ArrayList<String>();
        valuelist.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,valuelist);
        listView.setAdapter(adapter);
        if (!aController.getPlayer().toString().equals(valuelist.get(0))){
            //begin.setVisibility(View.INVISIBLE);
        }
    }

    public void joinGame(View view){
        String username = name.getText().toString();
        if(null!=username&&username.length()>0){
            aController.getPlayer().setUsername(username);
            net.join(username);
            //adapter.add(testa);
            //listView.setAdapter(adapter);
        }
    }
    public void getReady(View view){
        net.ready(aController.getPlayer().toString());
    }
    public void begin(View view) {
        String[] values = new String[]{net.getPlayerlist()};
        valuelist.clear();
        valuelist.addAll(Arrays.asList(values));
        adapter.notifyDataSetChanged();
        if (aController.getNet().creator() == aController.getPlayer().toString()) {
            //begin game
        } else {
        //give message?? you are not the creator
        }
    }
}
