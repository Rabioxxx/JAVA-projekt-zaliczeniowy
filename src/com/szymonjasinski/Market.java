package com.szymonjasinski;

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
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Brand brandRandom = Brand.randomBrand(); // Takes one random enum constant and assigns it to brand variable. E.g. MERCEDES which has var name "Mercedes-Benz" and String[] of models.
            Model brandModelRandom = brandRandom.randomModel(); // Now we take from brand variable (E.g. MERCEDES) a random model specific to a brand (E.g. CLASSC).

            String brandName = brandRandom.getName(); // Now we get name of the brand. If it is e.g. MERCEDES it will give us "Mercedes-Benz".
            String modelName = brandModelRandom.getName(); // Taking model name as String. E.g. "Class C".

            // TODO #007, #015
            // Randomizing age in between (exclusive) ageMin and ageMax values.
            // For now I am manually weighting it, can't find better solution for now.
            Map<Integer, Double> map = new HashMap<>();

            int ageMin = 6;
            int ageMax = 20;

            for (int j = ageMin; j <= ageMax; j++) {
                if (j >= 9 && j <= 11)
                    map.put(j, 14.0);
                else if (j == 8 || j == 12)
                    map.put(j, 12.0);
                else if (j == 7 || j == 13)
                    map.put(j, 10.0);
                else if (j == 6 || j == 14)
                    map.put(j, 8.0);
                else if (j == 15)
                    map.put(j, 6.0);
                else if (j == 16)
                    map.put(j, 4.0);
                else
                    map.put(j, 1.0);
            }
            Integer ageRandom = Helper.getWeightedRandom(map);


            // TODO #008
            double mileageRandom = Helper.RNG.nextDouble(5000.0, 500000.0); // Random mileage [5000.0, 500000.0)

            // TODO #010
            double valueRandom = Helper.RNG.nextDouble(100000.0);

            Color colorRandom = Color.getRandomColor();

            Car carRandom = new Car(brandName, modelName, ageRandom, mileageRandom, valueRandom, colorRandom);

            cars.add(carRandom);
        }
        setCars(cars);
    }
}
