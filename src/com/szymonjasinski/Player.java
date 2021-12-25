package com.szymonjasinski;

import java.util.ArrayList;

public class Player {
    private Double cash = 0.0;
    private ArrayList<Car> cars;
    private ArrayList<Client> clients;
    private ArrayList<String> transactions; // Maybe type will be changed.

    public Double getCash() {
        return cash;
    }

    // TODO #021
    public void setCash(Double cash) {
        if (this.transactions == null) {
            transactions = new ArrayList<>();
        }

        cash = Helper.roundMoney(cash);

        String cashDifferenceString;
        double cashDifference = Helper.roundMoney(cash - this.cash);

        if (cashDifference > 0) // if new cash we want to set is bigger than cash we had now then it means that transactions is adding cash to our account. So we want to see '+' sign.
            cashDifferenceString = "+" + Helper.moneyPretty(cashDifference);
        else
            cashDifferenceString = "" + Helper.moneyPretty(cashDifference);

        transactions.add("Transaction ##### ---> " + cashDifferenceString);

        this.cash = cash;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (this.cars == null)
            cars = new ArrayList<>();
        cars.add(car);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
