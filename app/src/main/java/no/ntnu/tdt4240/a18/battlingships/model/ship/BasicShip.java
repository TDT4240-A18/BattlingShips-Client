package no.ntnu.tdt4240.a18.battlingships.model.ship;

import java.lang.reflect.Array;

import no.ntnu.tdt4240.a18.battlingships.model.Ship;
import no.ntnu.tdt4240.a18.battlingships.model.ShipDirections;

/**
 * Created by Ondra on 10/03/15.
 */
public class BasicShip implements Ship {

    private int life = 3;
    private final int moverange = 1;
    private final int shootrange = 1;
    private int x;
    private int y;
    private final Boolean[][] shape = {{true}};
    private ShipDirections direction = ShipDirections.RIGHT;


    public BasicShip (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveShip(int x, int y){
        this.x = x;
        this.y =y;
    }
    @Override
    public int getPosX(){
        return x;
    }
    @Override
    public int getPosY(){
        return y;
    }
    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void loseLife() {
        life -=1 ;
        if(shipLost()){
            //If true terminate ship
        }
    }


    @Override
    public boolean shipLost() {
        return (life <= 0);
    }
    @Override
    public int getRange() {
        return moverange;
    }

    @Override
    public int getShootRange() {
        return shootrange;
    }

    @Override
    public Boolean[][] getShape() {
        return shape;
    }

    @Override
    public ShipDirections getDirection() {
        return direction;
    }
}
