package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

public class MapView extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_map_view);
        final ShipController aController = (ShipController) getApplicationContext();
    }

    /** Called when the user clicks the "Ending View" button */
    public void endGame(View view) {
        Intent intent = new Intent(this, EndingView.class);
        startActivity(intent);
    }

    public void goToAction(View view){
        Intent intent = new Intent(this, ActionView.class);
        startActivity(intent);
    }

}
