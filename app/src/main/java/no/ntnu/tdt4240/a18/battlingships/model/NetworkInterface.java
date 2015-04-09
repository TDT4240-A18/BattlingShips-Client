package no.ntnu.tdt4240.a18.battlingships.model;

/**
 * Created by Ondra on 10/03/15.
 */
public class NetworkInterface {

    private static final NetworkInterface INSTANCE = new NetworkInterface();

    public static NetworkInterface getInstance() {
        return INSTANCE;
    }

    public NetworkInterface() {}

    /**
     * This method checks overall status of the network connection.
     *
     * It should make available information if there is connection to the server and some game on the server.
     */
    public void checkStatus() {}

    /*
    public void move(String username, int x,int y){

    }
    public void shoot(String username, int x, int y){

    }

    //a heartbeat that runs in a seperate thread
    check(username){

    }
    */
}
