package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class Board {

    private String[][] board = {{null}};
    private int width = 4;
    private int height = 4;

    public Board() {
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] newBoard){
        this.board = newBoard;
    }
}

    //should be on serverside only
