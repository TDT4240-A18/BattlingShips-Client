package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
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
    public void shoot(){
        shoot=true;
        move=false;
        ulButton.setText("UpperLeft");
        upButton.setText("Up");
        urButton.setText("UpperRight");
        leftButton.setText("Left");
        rightButton.setText("Right");
        dlButton.setText("DownLeft");
        downButton.setText("Down");
        drButton.setText("DownRight");
        cancelButton.setText("Cancel");
    }
    public void move(){
        shoot=false;
        move=true;
        ulButton.setText("UpperLeft");
        upButton.setText("Up");
        urButton.setText("UpperRight");
        leftButton.setText("Left");
        rightButton.setText("Right");
        dlButton.setText("DownLeft");
        downButton.setText("Down");
        drButton.setText("DownRight");
        cancelButton.setText("Cancel");
    }
    public void cancel(){
        if(shoot||move){
            shoot=false;
            move=false;
            ulButton.setText("");
            upButton.setText("");
            urButton.setText("");
            leftButton.setText("");
            rightButton.setText("");
            dlButton.setText("");
            downButton.setText("");
            drButton.setText("");
            cancelButton.setText("");
        }
    }
    //Doing actions
    /*
    public void upLeft(){
        action(-1,-1, shoot, move);
    }
    public void upRight(){
        action(1,-1, shoot, move);
    }
    public void up(){
        action(0,-1, shoot, move);
    }
    public void left(){
        action(-1,0, shoot, move);
    }
    public void right(){
        action(1,0, shoot, move);
    }
    public void downLeft(){
        action(-1,1, shoot, move);
    }
    public void downRight(){
        action(1,1, shoot, move);
    }
    public void down(){
        action(0,1, shoot, move);
    }
    public void idle(){
        action(0,0,false,false);
    }*/



}
