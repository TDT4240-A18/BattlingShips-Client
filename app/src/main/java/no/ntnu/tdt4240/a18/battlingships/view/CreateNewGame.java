package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

public class CreateNewGame extends Activity {
    private ShipController aController;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);
        aController = (ShipController) getApplicationContext();
        name = (EditText) findViewById(R.id.editText);
    }

    public void createGame(View view) {
        Intent intent = new Intent(this, GameView.class);
        startActivity(intent);
    }

}
