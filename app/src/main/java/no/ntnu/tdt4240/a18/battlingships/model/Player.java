package no.ntnu.tdt4240.a18.battlingships.model;

import no.ntnu.tdt4240.a18.battlingships.model.ship.BasicShip;

/**
 * Created by Ondra on 10/03/15.
 */
public class Player {

    private Ship ship = null;
    private String username = "";
    private boolean ready;


    public Player(){
        ready = false;
    }
    public void imReady(){
        ready = true;
    }
    public boolean getReady(){
        return ready;
    }
    public void setUsername(String name){
        username=name;
    }
    public Ship createShip(int x,int y) {
        ship = new BasicShip(x,y);
        return ship;
    }
    public Ship getShip(){
        return ship;
    }

    public void destroyShip() {
        ship = null;
    }

    public String toString(){
        return username;
    }
}
