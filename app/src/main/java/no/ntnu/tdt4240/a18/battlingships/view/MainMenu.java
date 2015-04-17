package no.ntnu.tdt4240.a18.battlingships.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONObject;

import no.ntnu.tdt4240.a18.battlingships.R;
import no.ntnu.tdt4240.a18.battlingships.controller.ShipController;
import no.ntnu.tdt4240.a18.battlingships.model.ActionListener;
import no.ntnu.tdt4240.a18.battlingships.model.HTTPRequest;
import no.ntnu.tdt4240.a18.battlingships.model.PerformInBackground;

public class MainMenu extends Activity implements ActionListener {

    private ShipController aController;
    //Timer t = new Timer();

    private PerformInBackground performInBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        aController = (ShipController) getApplicationContext();
        performInBackground = PerformInBackground.getInstance(getApplicationContext());
        performInBackground.execute();
        HTTPRequest.addListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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

    /**
     * Called when the user clicks the "Game View" button
     */
    public void createNewGame(View view) {
    /*    t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (aController.getNet().getgameCreated()!=""){
                    System.out.println(aController.getNet().getgameCreated());
                    t.cancel();
                }
            }
        },0,1000);
        if (aController.getNet().getgameCreated()=="no game created"){
            Intent intent = new Intent(this, CreateNewGame.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, JoinGameView.class);
            startActivity(intent);
        } */

        Intent intent = new Intent(this, CreateNewGame.class);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the "CreditView" button
     */
    public void showCredits(View view) {
        Intent intent = new Intent(this, CreditView.class);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the "JoinView" button
     */
    public void joinGame(View view) {
        Intent intent = new Intent(this, JoinGameView.class);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the "Game View" button
     */
    public void exitApp(View view) {
        finish();
        System.exit(0);
    }

    /**
     * tell if there is a game at the server
     *
     * @param b
     */
    @Override public void isThereAgame(boolean b) {

    }

    /**
     * a new player joined the game
     *
     * @param list
     */
    @Override public void newPlayerJoined(String list) {

    }

    /**
     * list of players ready status
     *
     * @param list (playerName:boolean)
     */
    @Override public void readyStatus(String list) {

    }

    /**
     * report that the game is start now:
     * <p/>
     * report only once when the game start.
     *
     * @param board : initial board
     */
    @Override public void gameStarted(String board) {

    }

    /**
     * which player is on action: the player can do an action
     * <p/>
     * player name + board
     *
     * @param jsonObject
     */
    @Override public void onAction(JSONObject jsonObject) {

    }

    /**
     * a player is dead
     *
     * @param name : name of the player
     */
    @Override public void aPlayerDead(String name) {

    }

    /**
     * game Finished
     *
     * @param reason : why game is gameFinished
     */
    @Override public void gameFinished(String reason) {

    }

    /**
     * the join result for a player to join the game
     *
     * @param result
     */
    @Override public void joinResult(String result) {

    }

    /**
     * all responses from the server
     *
     * @param jsonObject
     */
    @Override public void response(JSONObject jsonObject) {

    }
}
