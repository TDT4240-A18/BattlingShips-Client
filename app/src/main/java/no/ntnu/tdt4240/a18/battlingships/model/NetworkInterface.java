package no.ntnu.tdt4240.a18.battlingships.model;

import android.content.Context;

/**
 * singleton pattern
 * <p/>
 * This file is part of BattlingShips-Client
 * <p/>
 * Created Chun Fan & GuoJunjun <junjunguo.com> on April 16, 2015.
 */
public class NetworkInterface {

    private static NetworkInterface instance = null;
    private Context context;

    /**
     * application context
     *
     * @param context
     */
    private NetworkInterface(Context context) {
        this.context = context;
    }

    public static NetworkInterface getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkInterface(context);
        }
        return instance;
    }

    /**
     * send server a request to build a game
     *
     * @return true if the game is built.
     */
    public void create(String username) {
        HTTPRequest.send(context, "game", "create", "?username=" + username);
    }

    /**
     * tell server the user is ready
     *
     * @return true if the game is built.
     */
    public void ready(String username) {
        HTTPRequest.send(context, "game", "ready", "?username=" + username);
    }

    /**
     * join game
     *
     * @param username
     */
    public void join(String username) {
        HTTPRequest.send(context, "game", "join", "?username=" + username);
    }

    /**
     * a player leave the game
     *
     * @param username
     */
    public void leave(String username) {
        HTTPRequest.send(context, "game", "leave", "?username=" + username);
    }

    /**
     * check who has next action
     * <p/>
     * check if there is a game
     *
     * @param username
     */
    public void check(String username) {
        HTTPRequest.send(context, "game", "check", "?username=" + username);
    }

    /**
     * move to
     *
     * @param username
     * @param x
     * @param y
     */
    public void move(String username, int x, int y) {
        HTTPRequest.send(context, "action", "move", "?username=" + username + "&x=" + x + "&y=" + y);
    }

    /**
     * do a shoot
     *
     * @param username
     * @param x
     * @param y
     */
    public void shoot(String username, int x, int y) {
        HTTPRequest.send(context, "action", "shoot", "?username=" + username + "&x=" + x + "&y=" + y);
    }

    /**
     * do nothing: pass the action to next player
     *
     * @param username
     */
    public void doNothing(String username) {
        HTTPRequest.send(context, "action", "doNothing", "?username=" + username);
    }

    /**
     * finish the game
     *
     * @param username
     */
    public void finish(String username) {
        HTTPRequest.send(context, "action", "shoot", "?username=" + username);
    }

    /**
     * check information
     */
    public void infor() {
        HTTPRequest.send(context, "action", "infor");
    }
}
