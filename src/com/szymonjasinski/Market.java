package com.szymonjasinski;

import java.util.ArrayList;

public class Market {
    private static ArrayList<Car> cars;

    public static ArrayList<Car> getCarsBuyable() {
        return cars;
    }

    public static void setCarsBuyable(ArrayList<Car> carsBuyable) {
        Market.cars = carsBuyable;
    }
}
