package no.ntnu.tdt4240.a18.battlingships.view;

import java.util.ArrayList;

/**
 * Created by Ondra on 10/03/15.
 */
public class MapView {

    private ArrayList<ShipView> ships = new ArrayList<>();

    public MapView() {
        ships.add(new ShipView());
    }

}
