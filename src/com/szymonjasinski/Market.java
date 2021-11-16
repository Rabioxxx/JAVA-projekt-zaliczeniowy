package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.*;
import java.lang.*;

public class Market {
    private ArrayList<Car> cars;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void carsGenerator(Integer number) {

        SecureRandom rng = new SecureRandom();

        Brand brandRandom = Brand.randomBrand(); // Takes one random enum constant and assigns it to brand variable. E.g. MERCEDES which has var name "Mercedes-Benz" and String[] of models.
        Model brandModelRandom = brandRandom.randomModel(); // Now we take from brand variable (E.g. MERCEDES) a random model specific to a brand (E.g. CLASSC).

        String brandName = brandRandom.getName(); // Now we get name of the brand. If it is e.g. MERCEDES it will give us "Mercedes-Benz".
        String modelName = brandModelRandom.getName(); // Taking model name as String. E.g. "Class C".

        // TODO #007, #013
        int ageRandom = rng.nextInt(30); // Random age [0, 30).

        // TODO #008
        double mileageRandom = rng.nextDouble(5000.0, 500000.0); // Random mileage [5000.0, 500000.0).

        // TODO #010
        double valueRandom = rng.nextDouble(100000.0);

        Color colorRandom = Color.getRandomColor();

        ArrayList<Car> cars = new ArrayList<>();

        Car carRandom = new Car(brandName, modelName, ageRandom, mileageRandom, valueRandom, colorRandom);
        cars.add(carRandom);

        setCars(cars);



        /*if (number <= models.length) {

            Random rng = new Random();

            ArrayList<Car> cars = new ArrayList<>();

            for (int i = 0; i < number; i++) {

                int randomProducerAndModel = rng.nextInt(0, producers.length);
                int randomAge = rng.nextInt(0, 30);
                // TODO #004
                Double randomDouble = rng.nextDouble(25000.0, 300000.0);

                Car carRandom = new Car(producers[randomProducerAndModel], models[randomProducerAndModel], randomAge, randomDouble, randomDouble, Color.BLACK);
                cars.add(carRandom);
            }

            setCars(cars);

        } else {
            throw new ArrayIndexOutOfBoundsException("Variable number cannot be bigger than producers[]/models[] index.");
        }*/
    }
}
