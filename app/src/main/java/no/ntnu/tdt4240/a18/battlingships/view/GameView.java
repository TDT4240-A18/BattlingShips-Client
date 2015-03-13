package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import no.ntnu.tdt4240.a18.battlingships.R;

public class GameView extends Activity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        map = new MapView();

        setContentView(R.layout.activity_game_view);
    }

    /** Called when the user clicks the "Ending View" button */
    public void endGame(View view) {
        Intent intent = new Intent(this, EndingView.class);
        startActivity(intent);
    }

}
