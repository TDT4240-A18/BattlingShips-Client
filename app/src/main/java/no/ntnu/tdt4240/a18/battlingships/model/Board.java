package no.ntnu.tdt4240.a18.battlingships.model;

/**
 * singleton pattern
 * <p/>
 * Created by Ondra on 10/03/15.
 */
public class Board {
    private static Board instance = null;

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private Board() {
    }

    private String[][] board = {{"null", "null", "null", "null"}, {"null", "null", "null", "null"}, {"null", "null", "null", "null"},
            {"null", "null", "null", "null"}};
    private int width = 4;
    private int height = 4;
    String[] playerList = {""};
    private String deadPlayers = "[]";
    private boolean gameBegun = false;
    private String winReason = "test";


    public void setPlayerList(String players){
        this.playerList = players.substring(1,players.length()-1).split(",");
    }
    public void setWinReason(String winner){
        this.winReason = winner;
    }
    public String getWinReason(){
        return winReason;
    }
    public void setgameBegun(){

        gameBegun = true;
    }

    public void setDeadPlayers(String players){
        this.deadPlayers = players;
    }

    public String getDeadPlayers(){
        return deadPlayers;
    }

    public boolean getGamebegun() {return gameBegun;}

    public String[] getPlayerList() {
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

    public void setBoard(String[][] newBoard) {
        this.board = newBoard;
    }
}

//should be on serverside only
