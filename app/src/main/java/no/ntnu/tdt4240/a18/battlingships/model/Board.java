package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class Board {

    private Ship[][] board ={{null}};
    private int width=3;
    private int height=3;

    public Board(){
    }

    public void setWidth(int width){this.width = width;}
    public void setHeight(int height){this.height = height;}
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
