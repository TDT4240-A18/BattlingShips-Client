package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class Game {

    private Gamerules rules = null;
    private Board board = null;
    private ArrayList<Player> players = new ArrayList<>();

    public Game(Gamerules rules) {
        this.rules = rules;
        board = new Board();
    }
}
