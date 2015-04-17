package no.ntnu.tdt4240.a18.battlingships.model;

import android.content.Context;

/**
 * Created by Ondra on 10/03/15.
 */
public class NetworkInterface {

    private static NetworkInterface instance = null;
    private String[] playerlist = {null};
    private Context context;
    private String gameCreated = "";


    /**
     * application context
     *
     * @param context
     */
    private NetworkInterface(Context context) {
        this.context = context;
        //        HTTPRequest.addListener(this);
    }

    public static NetworkInterface getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkInterface(context);
        }
        return instance;
    }

    public String getgameCreated() {return gameCreated; }

    public String[] getPlayerlist() {
        return playerlist;
    }

    /**
     * This method checks overall status of the network connection.
     * <p/>
     * It should make available information if there is connection to the server and some game on the server.
     */
    public void imReady(String name) {
        //need to send to the server that this person is ready
    }

    public String creator() {
        //ask server who created the game
        return null;
    }


    /**
     * send server a request to build a game
     *
     * @return true if the game is built.
     */
    public void create(String username) {
        HTTPRequest.send(context, "game", "create", "?username=" + username);
    }


    //    /**
    //     * response from the server
    //     *
    //     * @param jsonObject
    //     */
    //    public void response(JSONObject jsonObject) {
    //        try {
    //            Log.i("", "->operation : " + jsonObject.getString("tag"));
    //            Log.i("", "->result: " + jsonObject.getString("desc"));
    //            Log.i("", "->Players: " + jsonObject.getString("obj"));
    //
    //            //            if (jsonObject.getString("obj").charAt(0) == 'n') {
    //            //                playerlist =
    //            //                        jsonObject.getString("obj").substring(11,
    // jsonObject.getString("obj").length()
    //            // - 1).split(",");
    //            //            } else {
    //            //                playerlist =
    //            //                        jsonObject.getString("obj").substring(1, jsonObject.getString("obj").length
    //            // () - 1).split(",");
    //            //            }
    //            if (jsonObject.getString("obj").isEmpty()) {
    //                //playerlist = jsonObject.getString("obj").substring(11,jsonObject.getString("obj").length()-1)
    // .split
    //                // (",");
    //            } else {
    //                playerlist =
    //                        jsonObject.getString("obj").substring(1, jsonObject.getString("obj").length() - 1)
    // .split(",");
    //            }
    //            gameCreated = jsonObject.getString("desc");
    //        } catch (JSONException e) {
    //            e.printStackTrace();
    //        }
    //        Log.i("", "all response info: " + jsonObject.toString());
    //    }


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
     * @param x
     * @param y
     */
    public void doNothing(String username, int x, int y) {
        HTTPRequest.send(context, "action", "noNothing", "?username=" + username + "&x=" + x + "&y=" + y);
    }

    /**
     * finish the game
     *
     * @param username
     */
    public void finish(String username) {
        HTTPRequest.send(context, "action", "shoot", "?username=" + username);
    }


    public void infor() {
        HTTPRequest.send(context, "action", "infor");
    }
}
