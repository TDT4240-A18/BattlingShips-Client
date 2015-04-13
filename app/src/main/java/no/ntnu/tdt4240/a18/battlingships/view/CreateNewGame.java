package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import no.ntnu.tdt4240.a18.battlingships.R;

public class CreateNewGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);
    }

    public void createGame(View view) {
        Intent intent = new Intent(this, GameView.class);
        startActivity(intent);
    }

}
