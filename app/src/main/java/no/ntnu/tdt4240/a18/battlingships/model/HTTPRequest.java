package no.ntnu.tdt4240.a18.battlingships.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * a Static Class
 * <p/>
 * This file is part of BattlingShips-Client
 * <p/>
 * Created by ChunFan & GuoJunjun on April 14, 2015.
 */
public class HTTPRequest {
    private String response;
    private static ArrayList<ActionListener> actionListeners = new ArrayList<>();

    private static NetworkInterface networkInterface;

    /**
     * add action listener to listener list
     *
     * @param listener
     */
    public static void addListener(ActionListener listener) {

        System.out.println("--- + listener: " + listener.toString() + " size: " + actionListeners.size());

        actionListeners.add(listener);
    }

    /**
     * remove listener form listener list
     *
     * @param listener
     */
    public static void removeListener(ActionListener listener) {
        System.out.println("--- - listener: " + listener.toString() + " size: " + actionListeners.size());
        actionListeners.remove(listener);
    }


    public static void send(final Context context, String namespace, String action) {
        send(context, namespace, action, "");
    }

    public static void send(final Context context, String namespace, String action, String suffix) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://78.91.74.123:8080/" + namespace + "/" + action + suffix;
        Log.i("HTTP", "url: ----" + url);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(this.getClass().getSimpleName(), " ----: Response is: " + response);
                try {

                    JSONObject job = new JSONObject(response);
                    //                    networkInterface.getInstance(context).response(job);
                    for (ActionListener listener : actionListeners) {
                        responseHandler(listener, job);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(this.getClass().getSimpleName(), "That didn't work!\n");
                error.printStackTrace();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    /**
     * handler responses: send response to right method
     *
     * @param listener
     * @param job
     */
    private static void responseHandler(ActionListener listener, JSONObject job) {
        listener.response(job);
        String tag, type, obj, desc, onPlayer, activePlayers, inactivePlayers;
        int state;
        try {
            tag = job.getString("tag");
        } catch (JSONException e) {
            //            e.printStackTrace();
            tag = "";
        }
        try {
            type = job.getString("type");
        } catch (JSONException e) {
            //            e.printStackTrace();
            type = "";
        }

        try {
            obj = job.getString("obj");
        } catch (JSONException e) {
            //            e.printStackTrace();
            obj = "";
        }

        try {
            desc = job.getString("desc");
        } catch (JSONException e) {
            //            e.printStackTrace();
            desc = "";
        }
        try {
            onPlayer = job.getString("onplayer");
        } catch (JSONException e) {
            //            e.printStackTrace();
            onPlayer = "";
        }
        try {
            activePlayers = job.getString("active");
        } catch (JSONException e) {
            //            e.printStackTrace();
            activePlayers = "";
        }
        try {
            inactivePlayers = job.getString("inactive");
        } catch (JSONException e) {
            //            e.printStackTrace();
            inactivePlayers = "";
        }

        try {
            state = job.getInt("state");
        } catch (JSONException e) {
            //            e.printStackTrace();
            state = -1;
        }


        // is there a game created at the server
        if ((tag.equalsIgnoreCase("check") || tag.equalsIgnoreCase("infor")) &&
                desc.equalsIgnoreCase("no game created")) {
            listener.isThereAgame(false);
        } else if ((tag.equalsIgnoreCase("check") || tag.equalsIgnoreCase("infor")) &&
                desc.equalsIgnoreCase("game created")) {
            listener.isThereAgame(true);
        }

        //joined players
        if (tag.equalsIgnoreCase("infor") && type.equalsIgnoreCase("playerList")) {
            listener.joinedPlayers(obj);
        }

        // ready status
        if (tag.equalsIgnoreCase("infor") && type.equalsIgnoreCase("playerList")) {
            listener.readyStatus(obj);
        }

        // game started
        if (tag.equalsIgnoreCase("infor") && type.equalsIgnoreCase("board") && state == 1) {
            listener.gameStarted(obj);
            listener.gameState(state);
        }

        // on player
        if (tag.equalsIgnoreCase("infor") && type.equalsIgnoreCase("board") && state >= 1) {
            //on state
            listener.gameState(state);

            //on player: player name + board
            if (onPlayer != "") {
                listener.onPlayer(onPlayer, obj);
            }

            //active player list
            listener.activePlayerList(activePlayers);

            //inactive player list
            listener.inactivePlayerList(inactivePlayers);
        }

        // join result
        if (tag.equalsIgnoreCase("join")) {
            listener.joinResult(desc);
        }

        // game finished
        if (tag.equalsIgnoreCase("finish")) {
            try {
                listener.gameFinished(job.getString("desc"));
            } catch (JSONException e) {
                //                e.printStackTrace();
            }
        }
    }
}
