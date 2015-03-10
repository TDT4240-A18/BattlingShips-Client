package no.ntnu.tdt4240.a18.battlingships.model;

import no.ntnu.tdt4240.a18.battlingships.model.ship.BasicShip;

/**
 * Created by Ondra on 10/03/15.
 */
public class Player {

    private Ship ship = null;

    public Ship createShip() {
        ship = new BasicShip();
        return ship;
    }

    public void destroyShip() {
        ship = null;
    }

}
