package com.szymonjasinski;

import java.util.ArrayList;
import java.util.Random;

public class Market {
    private ArrayList<Car> cars;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void carsGenerator(Integer number) {
        // TODO #003
        String[] producers = {"Fiat", "Opel", "Ford", "Mercedes-Benz", "Renault", "Tesla"};
        String[] models = {"500", "Insignia", "Fiesta", "CLA45", "Clio", "Model X"};

        if (number <= producers.length) {

            Random rng = new Random();

            ArrayList<Car> cars = new ArrayList<>();

            for (int i = 0; i < number; i++) {

                int randomProducerAndModel = rng.nextInt(0, producers.length);
                int randomAge = rng.nextInt(0, 30);
                // TODO #004
                Double randomDouble = rng.nextDouble(25000.0, 300000.0);

                Car carRandom = new Car(producers[randomProducerAndModel], models[randomProducerAndModel], randomAge, randomDouble, randomDouble, Color.BLACK, false);
                cars.add(carRandom);
            }

            this.cars = cars;

        } else {
            throw new ArrayIndexOutOfBoundsException("Variable number cannot be bigger than producers[]/models[] index.");
        }
    }

    public void getCarsAllPretty() {
        for (int i = 0; i < this.cars.size(); i++) {
            System.out.println(this.cars.get(i));
        }
    }
}
