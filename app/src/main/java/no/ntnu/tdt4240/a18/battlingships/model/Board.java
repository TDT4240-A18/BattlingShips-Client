package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class Board {

    private ArrayList<Ship> ships = new ArrayList<>();
    
    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }
}
