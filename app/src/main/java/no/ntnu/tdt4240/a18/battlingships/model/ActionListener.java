package no.ntnu.tdt4240.a18.battlingships.model;

import org.json.JSONObject;

/**
 * This file is part of BattlingShips-Client
 * <p/>
 * Created by Chun Fan & GuoJunjun on April 16, 2015.
 */
public interface ActionListener {

    //    public void created();
    //
    //    /**
    //     * all the players are ready: list of players with board
    //     *
    //     * @param jsonObject
    //     */
    //    public void everyOneReady(JSONObject jsonObject);
    //
    //    /**
    //     * a new player joined the game
    //     *
    //     * @param jsonObject
    //     */
    //    public void newPlayerJoined(JSONObject jsonObject);

    //    /**
    //     * actions or changes has been made
    //     *
    //     * @param jsonObject
    //     */
    //    public void statusChanged(JSONObject jsonObject);

    /**
     * responses from the server
     *
     * @param jsonObject
     */
    public void response(JSONObject jsonObject);
}
