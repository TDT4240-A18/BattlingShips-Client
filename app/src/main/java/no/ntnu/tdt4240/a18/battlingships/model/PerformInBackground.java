package no.ntnu.tdt4240.a18.battlingships.model;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This file is part of BattlingShips-Client
 * <p/>
 * Created Chun Fan & GuoJunjun <junjunguo.com> on April 16, 2015.
 */
public class PerformInBackground extends AsyncTask {
    private static PerformInBackground instance = null;
    private Context context;
    private NetworkInterface networkInterface;


    private PerformInBackground(Context context) {
        this.context = context;
        networkInterface = NetworkInterface.getInstance(context);
    }

    public static PerformInBackground getInstance(Context context) {
        if (instance == null) {
            instance = new PerformInBackground(context);
        }
        return instance;
    }

    /**
     * Override this method to perform a computation on a background thread. The specified parameters are the parameters
     * passed to {@link #execute} by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override protected Object doInBackground(Object[] params) {
        startLoop();
        return null;
    }

    public void startLoop() {
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    networkInterface.infor();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(doAsynchronousTask, 1000, 1000);
    }
}
