package no.ntnu.tdt4240.a18.battlingships.model.ruleset;

import java.util.ArrayList;

import no.ntnu.tdt4240.a18.battlingships.model.Board;
import no.ntnu.tdt4240.a18.battlingships.model.Gamerules;
import no.ntnu.tdt4240.a18.battlingships.model.Player;
import no.ntnu.tdt4240.a18.battlingships.model.Ship;

/**
 * Created by Ondra on 10/03/15.
 */
public class BasicGame implements Gamerules {
    private Board board;
    //list of remaining players. should be serverside?
    //private ArrayList<Player> players = new ArrayList<Player>();

    public BasicGame(Board board){
        this.board = board;
    }


    @Override
    public boolean checkMove(Ship ship, int posX, int posY) {
        //checks if position is out of bounds
        if (posX >= board.getWidth()|| posY >= board.getHeight() || posX < 0 || posY < 0){
            return false;
        }
        //this sentence only works when all ships only can move and shoot one tile away from their position
        //im sure it can be written in a prettier and more compact way
        //it checks if the spot that is chosen to move to is within range of the ships moving range (if the range is 1)
        if ((ship.getPosX()-posX==1 || ship.getPosX()-posX==-1 || ship.getPosX()==posX) && (ship.getPosY()-posY==1 || ship.getPosY()-posY==-1 || ship.getPosY()==posY)) {
            if (ship.getPosX()-posX == 0 && ship.getPosY()-posY == 0) {
                return false;
            }
            else{ return true;}
        }
        else{ return false;}
    }

    @Override
    public boolean checkShot(Ship ship, int posX, int posY) {
            //checks if position is out of bounds
        if (posX >= board.getWidth()|| posY >= board.getHeight() || posX < 0 || posY < 0){
            return false;
        }
        //this sentence only works when all ships only can move and shoot one tile away from their position
        //im sure it can be written in a prettier and more compact way
        //it checks if the spot that is aimed at is within range of the ships shooting range (if the range is 1)
        if ((ship.getPosX()-posX==1 || ship.getPosX()-posX==-1 || ship.getPosX()==posX) && (ship.getPosY()-posY==1 || ship.getPosY()-posY==-1 || ship.getPosY()==posY)){
            if (ship.getPosX()-posX == 0 && ship.getPosY()-posY==0){
                return false;
            }
            return true;
        }
        else{ return false;}
    }
    //only serverside?
    @Override
    public boolean checkWin() {
        return false; //(players.size() == 1);
    }

    @Override
    //returns true if the ship collides with another ship (this should be run after the move is confirmed as valid.
    public boolean checkCollide(Ship ship, int posX, int posY) {
        if (board.checkOccupied(posX,posY)){
            return true;
        }
        return false;
    }
}
