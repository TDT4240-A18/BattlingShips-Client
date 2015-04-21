package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
    private Button shootButton;
    private Button moveButton;
    private ShipController aController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
        aController = (ShipController) getApplicationContext();
        move=false;
        shoot=false;
        shootButton =(Button) findViewById(R.id.shootButton);
        moveButton = (Button) findViewById(R.id.moveButton);
        ulButton = (Button) findViewById(R.id.ulButton);
        upButton = (Button) findViewById(R.id.upButton);
        urButton= (Button) findViewById(R.id.urButton);
        leftButton= (Button) findViewById(R.id.leftButton);
        cancelButton= (Button) findViewById(R.id.cancelButton);
        rightButton= (Button) findViewById(R.id.rightButton);
        dlButton= (Button) findViewById(R.id.dlbutton);
        downButton= (Button) findViewById(R.id.downButton);
        drButton= (Button) findViewById(R.id.drButton);
        cancelButton.setBackgroundColor(Color.GRAY);

    }

    public void mapView(View view){
        Intent intent = new Intent(this, MapView.class);
        startActivity(intent);

    }
    public void shoot(View view){
        shoot=true;
        move=false;
        shootButton.setTypeface(null, Typeface.BOLD);
        moveButton.setTypeface(null, Typeface.NORMAL);
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
        shootButton.setTypeface(null, Typeface.NORMAL);
        moveButton.setTypeface(null, Typeface.BOLD);
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
            shootButton.setTypeface(null, Typeface.NORMAL);
            moveButton.setTypeface(null, Typeface.NORMAL);
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
    //for these to work we need to set a value to the X and Y of the ship
    public void upLeft(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX()-1)){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX()-1);
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX()-1);
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }
    }
    public void upRight(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX()+1)){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX()+1);
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX()+1);
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }
    }
    public void up(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX())){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX());
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()-1,aController.getPlayer().getShip().getPosX());
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }
    }
    public void left(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY(),aController.getPlayer().getShip().getPosX()-1)){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY(),aController.getPlayer().getShip().getPosX()-1);
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY(),aController.getPlayer().getShip().getPosX()-1);
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else {
            //give player message that move is invalid
        }
    }

    public void right(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY(),1+aController.getPlayer().getShip().getPosX())){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY(),1+aController.getPlayer().getShip().getPosX());
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY(),1+aController.getPlayer().getShip().getPosX());
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }

    }
    public void downLeft(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY()+1,aController.getPlayer().getShip().getPosX()-1)){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()+1,aController.getPlayer().getShip().getPosX()-1);
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()+1,aController.getPlayer().getShip().getPosX()-1);
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }
    }

    public void downRight(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), aController.getPlayer().getShip().getPosY()+1,aController.getPlayer().getShip().getPosX()+1)){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()+1,aController.getPlayer().getShip().getPosX()+1);
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),aController.getPlayer().getShip().getPosY()+1,aController.getPlayer().getShip().getPosX()+1);
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }
    }
    public void down(View view){
        if (aController.getRules().checkMove(aController.getPlayer().getShip(), 1+aController.getPlayer().getShip().getPosY(),aController.getPlayer().getShip().getPosX())){
            if(move){
                aController.getNet().move(aController.getPlayer().toString(),1+aController.getPlayer().getShip().getPosY(),aController.getPlayer().getShip().getPosX());
            }
            else if(shoot){
                aController.getNet().move(aController.getPlayer().toString(),1+aController.getPlayer().getShip().getPosY(),aController.getPlayer().getShip().getPosX());
            }
            //after choosing a valid move go back to the mapview
            Intent intent = new Intent(this, MapView.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else{
            //give player message that move is invalid
        }
    }
    public void idle(View view){
        aController.getNet().doNothing(aController.getPlayer().toString());
        Intent intent = new Intent(this, MapView.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }



}
