package no.ntnu.tdt4240.a18.battlingships.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;


public class ActionView extends ActionBarActivity {
    private boolean shoot=false;
    private boolean move=false;
    private Button ulButton = (Button) findViewById(R.id.ulButton);
    private Button upButton = (Button) findViewById(R.id.upButton);
    private Button urButton= (Button) findViewById(R.id.urButton);
    private Button leftButton= (Button) findViewById(R.id.leftButton);
    private Button cancelButton= (Button) findViewById(R.id.cancelButton);
    private Button rightButton= (Button) findViewById(R.id.rightButton);
    private Button dlButton= (Button) findViewById(R.id.dlbutton);
    private Button downButton= (Button) findViewById(R.id.downButton);
    private Button drButton= (Button) findViewById(R.id.drButton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
        final ShipController aController = (ShipController) getApplicationContext();
        move=false;
        shoot=false;
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
