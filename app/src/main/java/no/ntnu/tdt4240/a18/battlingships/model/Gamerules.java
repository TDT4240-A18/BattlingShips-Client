package no.ntnu.tdt4240.a18.battlingships.model;

/**
 * Created by Ondra on 10/03/15.
 */
public interface Gamerules {

    //checks if boat tries to leave board (might need to change posX and posY to something else)
    public boolean checkMove(Ship ship, int posX,int posY);

    //checks if boat tries to shoot outside the board (might need to change posX and posY to something else)
    public boolean checkShot(Ship ship, int posX,int posY);

    //check the list of players and their ships life to see if one has won
    public boolean checkWin();

    //checks if the position you try to move to is occupied by another ship
    public boolean checkCollide(Ship ship, int posX,int posY);
}
