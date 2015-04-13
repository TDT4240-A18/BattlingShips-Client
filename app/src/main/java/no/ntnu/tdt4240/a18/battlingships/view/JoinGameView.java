package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

public class JoinGameView extends Activity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game_view);
        final ShipController aController = (ShipController) getApplicationContext();
        listView = (ListView) findViewById(R.id.listView);

        String[] values = new String[]{"Ahaha", "BALAL", "testat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listView.setAdapter(adapter);
    }
}
