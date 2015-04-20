package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class Board {

    private String[][] board = {{null,null,null,null},{null,"test:3",null,null},{null,null,null,null},{null,null,null,null}};
    private int width = 4;
    private int height = 4;
    String[] playerList = {null};
    private boolean gameBegun = false;

    public Board() {
    }

    public void setPlayerList(String players){
        this.playerList = players.substring(1,players.length()-1).split(",");
    }
    public void setgameBegun(){
        gameBegun = true;
    }
    public boolean getGamebegun(){return gameBegun;}
    public String[] getPlayerList(){
        return playerList;
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
