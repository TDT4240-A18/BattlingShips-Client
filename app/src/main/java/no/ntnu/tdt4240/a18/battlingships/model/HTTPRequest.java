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
        actionListeners.add(listener);
    }

    public static void send(Context context, String namespace, String action) {
        send(context, namespace, action, "");
    }

    public static void send(final Context context, String namespace, String action, String suffix) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://78.91.74.235:8080/" + namespace + "/" + action + suffix;
        Log.i("http error", "url: " + url);


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
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
        String tag, type, obj, desc;
        try {
            tag = job.getString("tag").toString();
            type = job.getString("type").toString();
            obj = job.getString("obj").toString();
            desc = job.getString("desc").toString();

            if (tag.equalsIgnoreCase("finish")) {
                listener.gameFinished(job.getString("desc"));
            }
//            if () listener.newPlayerJoined(); listener.onAction();
//            listener.readyStatus();
//            listener.gameStarted();
//            listener.aPlayerDead();

            if (tag.equalsIgnoreCase("check") && desc.equalsIgnoreCase("no game created")) {
                listener.isThereAgame(false);
            } else if (tag.equalsIgnoreCase("check") && desc.equalsIgnoreCase("have game")) {
                listener.isThereAgame(true);
            }
            if (tag.equalsIgnoreCase("finish")) {

            }
            if (tag.equalsIgnoreCase("finish")) {

            }
            if (tag.equalsIgnoreCase("finish")) {

            }
            if (tag.equalsIgnoreCase("finish")) {

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
