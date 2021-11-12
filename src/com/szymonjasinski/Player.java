package com.szymonjasinski;

import java.util.ArrayList;

public class Player {
    private static Double cash;
    private static ArrayList<Car> cars;
    private static ArrayList<Client> clients;

    public static Double getCash() {
        return cash;
    }

    public static void setCash(Double cash) {
        Player.cash = cash;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static void setCars(ArrayList<Car> cars) {
        Player.cars = cars;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients) {
        Player.clients = clients;
    }
}
