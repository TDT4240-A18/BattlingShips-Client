package no.ntnu.tdt4240.a18.battlingships.view;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class EndingView extends Activity {

    private ShipController aController;
    TextView winReason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ending_view);
        aController = (ShipController) getApplicationContext();
        winReason = (TextView) findViewById(R.id.fullscreen_content);
        winReason.setText(aController.getBoard().getWinReason());

    }

    public void end(View view){
        aController.getPlayer().setUsername("");
        finish();
        System.exit(1);
    }

}
