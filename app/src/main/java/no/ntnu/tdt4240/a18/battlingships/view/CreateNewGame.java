package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import no.ntnu.tdt4240.a18.battlingships.BuildConfig;
import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;
import no.ntnu.tdt4240.a18.battlingships.model.NetworkInterface;

public class CreateNewGame extends Activity {

    private String username = null;
    private Integer playerCnt = null;
    private ShipController aController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);
        aController = (ShipController) getApplicationContext();
    }

    public void createGame(View view) {

        username = ((EditText) findViewById(R.id.username)).getText().toString();
        /*if (BuildConfig.DEBUG) {
            System.out.println("Clicked Create a game.");
            System.out.println("Username: \"" + username + '"');
        }

        playerCnt = Integer.parseInt(((EditText) findViewById(R.id.playerCnt)).getText().toString());
        if (BuildConfig.DEBUG) {
            System.out.println("Number of players: " + playerCnt);
            System.out.println();
        }*/
        aController.getNet().create(username);
        aController.getPlayer().setUsername(username);
        Intent intent = new Intent(this, JoinGameView.class);
        startActivity(intent);
    }

}
