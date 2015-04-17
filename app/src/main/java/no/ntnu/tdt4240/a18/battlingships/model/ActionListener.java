package no.ntnu.tdt4240.a18.battlingships.model;

import org.json.JSONObject;

/**
 * This file is part of BattlingShips-Client
 * <p/>
 * Created by Chun Fan & GuoJunjun on April 16, 2015.
 */
public interface ActionListener {
    /**
     * tell if there is a game at the server
     *
     * @param b
     */
    public void isThereAgame(boolean b);

    /**
     * a new player joined the game
     *
     * @param list
     */
    public void newPlayerJoined(String list);

    /**
     * list of players ready status
     *
     * @param list (playerName:boolean)
     */
    public void readyStatus(String list);

    /**
     * report that the game is start now:
     * <p/>
     * report only once when the game start.
     *
     * @param board : initial board
     */
    public void gameStarted(String board);

    /**
     * which player is on action: the player can do an action
     * <p/>
     * player name + board
     *
     * @param jsonObject
     */
    public void onAction(JSONObject jsonObject);

    /**
     * a player is dead
     *
     * @param name: name of the player
     */
    public void aPlayerDead(String name);

    /**
     * game Finished
     *
     * @param reason : why game is gameFinished
     */
    public void gameFinished(String reason);

    /**
     * the join result for a player to join the game
     *
     * @param result
     */
    public void joinResult(String result);

    /**
     * all responses from the server
     *
     * @param jsonObject
     */
    public void response(JSONObject jsonObject);

}
