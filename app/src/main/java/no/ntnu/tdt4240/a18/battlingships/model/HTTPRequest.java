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
        String url = "http://78.91.73.22:8080/" + namespace + "/" + action + suffix;
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
                        listener.response(job);
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
}
