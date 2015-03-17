package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class Board {

    private Ship[][] board ={{null}};
    private int width;
    private int height;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        board = new Ship[height][width];
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void addShip(Ship ship, int x, int y) {
        board[y][x]=ship;
    }

    //should be on serverside only
    public boolean checkOccupied(int x, int y){
        return (board[y][x] != null);
    }

    public void removeShip(Ship ship) {
        board[ship.getPosY()][ship.getPosX()]=null;
    }
}
