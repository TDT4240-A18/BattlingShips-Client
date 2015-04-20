package no.ntnu.tdt4240.a18.battlingships.view;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

import android.app.Activity;
import android.os.Bundle;


public class EndingView extends Activity {

    private ShipController aController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ending_view);
        ShipController aController = (ShipController) getApplicationContext();
        //TODO set victory/loss message of who won

    }

}
