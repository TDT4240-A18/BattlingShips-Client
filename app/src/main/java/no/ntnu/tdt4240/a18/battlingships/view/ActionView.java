package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;


public class ActionView extends Activity {

    private boolean shoot=false;
    private boolean move=false;
    private Button ulButton;
    private Button upButton;
    private Button urButton;
    private Button leftButton;
    private Button cancelButton;
    private Button rightButton;
    private Button dlButton;
    private Button downButton;
    private Button drButton;
    private ShipController aController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
        aController = (ShipController) getApplicationContext();
        move=false;
        shoot=false;

        ulButton = (Button) findViewById(R.id.ulButton);
        upButton = (Button) findViewById(R.id.upButton);
        urButton= (Button) findViewById(R.id.urButton);
        leftButton= (Button) findViewById(R.id.leftButton);
        cancelButton= (Button) findViewById(R.id.cancelButton);
        rightButton= (Button) findViewById(R.id.rightButton);
        dlButton= (Button) findViewById(R.id.dlbutton);
        downButton= (Button) findViewById(R.id.downButton);
        drButton= (Button) findViewById(R.id.drButton);

    }

    public void mapView(View view){
        Intent intent = new Intent(this, MapView.class);
        startActivity(intent);

    }
    public void shoot(View view){
        shoot=true;
        move=false;
        ulButton.setText("UpperLeft");
        ulButton.setBackgroundColor(Color.RED);
        upButton.setText("Up");
        upButton.setBackgroundColor(Color.RED);
        urButton.setText("UpperRight");
        urButton.setBackgroundColor(Color.RED);
        leftButton.setText("Left");
        leftButton.setBackgroundColor(Color.RED);
        rightButton.setText("Right");
        rightButton.setBackgroundColor(Color.RED);
        dlButton.setText("DownLeft");
        dlButton.setBackgroundColor(Color.RED);
        downButton.setText("Down");
        downButton.setBackgroundColor(Color.RED);
        drButton.setText("DownRight");
        drButton.setBackgroundColor(Color.RED);
        cancelButton.setText("Cancel");
    }
    public void move(View view){
        shoot=false;
        move=true;
        shoot=true;
        move=false;
        ulButton.setText("UpperLeft");
        ulButton.setBackgroundColor(Color.GREEN);
        upButton.setText("Up");
        upButton.setBackgroundColor(Color.GREEN);
        urButton.setText("UpperRight");
        urButton.setBackgroundColor(Color.GREEN);
        leftButton.setText("Left");
        leftButton.setBackgroundColor(Color.GREEN);
        rightButton.setText("Right");
        rightButton.setBackgroundColor(Color.GREEN);
        dlButton.setText("DownLeft");
        dlButton.setBackgroundColor(Color.GREEN);
        downButton.setText("Down");
        downButton.setBackgroundColor(Color.GREEN);
        drButton.setText("DownRight");
        drButton.setBackgroundColor(Color.GREEN);
        cancelButton.setText("Cancel");
    }
    public void cancel(View view){
        if(shoot||move){
            shoot=false;
            move=false;
            ulButton.setText("");
            ulButton.setBackgroundColor(Color.BLUE);
            upButton.setText("");
            upButton.setBackgroundColor(Color.BLUE);
            urButton.setText("");
            urButton.setBackgroundColor(Color.BLUE);
            leftButton.setText("");
            leftButton.setBackgroundColor(Color.BLUE);
            rightButton.setText("");
            rightButton.setBackgroundColor(Color.BLUE);
            dlButton.setText("");
            dlButton.setBackgroundColor(Color.BLUE);
            downButton.setText("");
            downButton.setBackgroundColor(Color.BLUE);
            drButton.setText("");
            drButton.setBackgroundColor(Color.BLUE);
            cancelButton.setText("");
        }
    }
    //Doing actions
    /*
    public void upLeft(View view){
        if(shoot||move){
            action(-1,-1, shoot, move);
        }
    }
    public void upRight(View view){
        if(shoot||move) {
            action(1, -1, shoot, move);
        }
    }
    public void up(View view){
        if(shoot||move) {
            action(0, -1, shoot, move);
        }
    }
    public void left(View view){
        if(shoot||move) {
            action(-1, 0, shoot, move);
        }
    }
    public void right(View view){
        if(shoot||move) {
            action(1, 0, shoot, move);
        }
    }
    public void downLeft(View view){
        if(shoot||move) {
            action(-1, 1, shoot, move);
        }
    }
    public void downRight(View view){
        if(shoot||move) {
            action(1, 1, shoot, move);
        }
    }
    public void down(View view){
        if(shoot||move) {
            action(0, 1, shoot, move);
        }
    }
    public void idle(View view){
        action(0,0,false,false);
    }
    */



}
