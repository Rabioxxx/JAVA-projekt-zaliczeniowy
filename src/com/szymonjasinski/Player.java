package com.szymonjasinski;

import java.util.ArrayList;

public class Player {
    private Double cash;
    private ArrayList<Car> cars;
    private ArrayList<Client> clients;

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = Helper.roundMoney(cash);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
