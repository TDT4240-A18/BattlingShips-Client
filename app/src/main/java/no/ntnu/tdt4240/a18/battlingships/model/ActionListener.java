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
    public void joinedPlayers(String list);

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
     * @param playerName
     * @param board
     */
    public void onPlayer(String playerName, String board);

    /**
     * tell the current game state
     * <p/>
     * game state based on sum of players actions
     * <p/>
     * first move start with 1
     *
     * @param state
     */
    public void gameState(int state);

    /**
     * a player list with active players:
     * <p/>
     * <li>players not dead</li> <li>players not left the game</li>
     *
     * @param activePlayers
     */
    public void activePlayerList(String activePlayers);


    /**
     * a player list with inactive players:
     * <p/>
     * <li>players are dead</li> <li>players that left the game</li>
     *
     * @param inactivePlayers
     */
    public void inactivePlayerList(String inactivePlayers);

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
