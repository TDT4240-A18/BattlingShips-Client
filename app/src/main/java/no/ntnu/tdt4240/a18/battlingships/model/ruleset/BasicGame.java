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
    //list of remaining players.
    private ArrayList<Player> players;

    public BasicGame(Board board, ArrayList<Player> players){
        this.board = board;
        this.players = players;
    }

    @Override
    public boolean checkMove(Ship ship, int posX, int posY) {
        if (posX >= board.getWidth()|| posY >= board.getHeight() || posX < 0 || posY < 0){
            return false;
        }
        //add a check if the move is valid based on ships current position
        return true;
    }

    @Override
    public boolean checkShot(Ship ship, int posX, int posY) {
        if (posX >= board.getWidth()|| posY >= board.getHeight() || posX < 0 || posY < 0){
            return false;
        }
        //add a check if the move is valid based on ships current position
        return true;
    }

    @Override
    public boolean checkWin() {
        return (players.size() == 1);
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
