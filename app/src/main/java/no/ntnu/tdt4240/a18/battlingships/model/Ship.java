package no.ntnu.tdt4240.a18.battlingships.model;

import java.lang.reflect.Array;

/**
 * Created by Ondra on 10/03/15.
 */
public interface Ship {

    public int getLife();

    public void loseLife();

    public boolean shipLost();

    public int getRange();

    public int getShootRange();

    public Boolean[][] getShape();

    public ShipDirections getDirection();

    public void moveShip(int x,int y);

    public int getPosX();

    public int getPosY();
}
