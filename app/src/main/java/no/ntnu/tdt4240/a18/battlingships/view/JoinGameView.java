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

public class JoinGameView extends Activity {
    ListView listView;
    EditText name;
    ShipController aController;
    ArrayAdapter<String> adapter;
    ArrayList<String> valuelist;
    Button begin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game_view);
        aController = (ShipController) getApplicationContext();
        begin = (Button) findViewById(R.id.button5);
        name =(EditText) findViewById(R.id.editText1);
        listView = (ListView) findViewById(R.id.listView);

        String[] values = new String[]{"Ahaha", "BALAL", "testat","adad"};
        valuelist = new ArrayList<String>();
        valuelist.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,valuelist);
        listView.setAdapter(adapter);
        if (!aController.getPlayer().toString().equals(valuelist.get(0))){
            begin.setVisibility(View.INVISIBLE);
        }
    }

    public void joinGame(View view){
        String testa = name.getText().toString();
        if(null!=testa&&testa.length()>0){
            aController.getPlayer().setUsername(testa);
            valuelist.add(testa);
            adapter.notifyDataSetChanged();
            //adapter.add(testa);
            //listView.setAdapter(adapter);
        }
    }
    public void getReady(View view){
        aController.getNet().imReady(aController.getPlayer().toString());
    }
    public void begin(View view) {
        if (aController.getNet().creator() == aController.getPlayer().toString()) {
            //begin game
        } else {
        //give message?? you are not the creator
        }
    }
}
