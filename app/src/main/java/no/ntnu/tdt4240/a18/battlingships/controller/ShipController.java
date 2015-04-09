package no.ntnu.tdt4240.a18.battlingships.controller;

import android.app.Application;

import no.ntnu.tdt4240.a18.battlingships.model.Board;
import no.ntnu.tdt4240.a18.battlingships.model.Game;
import no.ntnu.tdt4240.a18.battlingships.model.NetworkInterface;
import no.ntnu.tdt4240.a18.battlingships.model.Player;
import no.ntnu.tdt4240.a18.battlingships.model.ruleset.BasicGame;

/**
 * Created by Ondra on 11/03/15.
 */
public class ShipController extends Application {

    private Player player = new Player();
    private Board board = new Board();
    private BasicGame rules = new BasicGame(board);
    private Game game = new Game(rules, board);
    private NetworkInterface net = new NetworkInterface();

    public Player getPlayer(){
        return player;
    }
    public Game getGame(){
        return game;
    }
    public Board getBoard(){
        return board;
    }
    public NetworkInterface getNet(){
        return net;
    }
}

