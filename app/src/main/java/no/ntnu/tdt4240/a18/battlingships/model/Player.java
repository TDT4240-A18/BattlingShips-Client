package no.ntnu.tdt4240.a18.battlingships.model;

import no.ntnu.tdt4240.a18.battlingships.model.ship.BasicShip;

/**
 * singleton pattern
 * <p/>
 * Created by Ondra on 10/03/15.
 */
public class Player {

    private static Player instance = null;

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    private Ship ship = null;
    private String username = "";
    private int life = 3;
    private boolean dead = false;
    private Boolean[][] visibility =
            {{false, false, false, false}, {false, false, false, false}, {false, false, false, false},
                    {false, false, false, false}};

    private Player() {
        dead = false;
    }

    public void iDied() {
        dead = true;
    }

    public void canSee() {
        if (ship != null) {
            visibility[ship.getPosY()][ship.getPosX()] = true;
        }
    }

    public Boolean[][] getVisibility() {return visibility;}

    public boolean getDead() {
        return dead;
    }

    public void setUsername(String name) {
        username = name;
    }

    public Ship createShip(int x, int y) {
        ship = new BasicShip(x, y);
        return ship;
    }

    public Ship getShip() {
        return ship;
    }

    public void destroyShip() {
        ship = null;
    }

    public String toString() {
        return username;
    }
}
