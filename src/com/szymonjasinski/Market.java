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
            Segment segment = brandModelRandom.getSegment();

            String brandName = brandRandom.getName(); // Now we get name of the brand. If it is e.g. MERCEDES it will give us "Mercedes-Benz".
            String modelName = brandModelRandom.getName(); // Taking model name as String. E.g. "Class C".

            Integer price = brandModelRandom.getPrice();

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
            map.clear(); // Clears everything inside map, just to be sure.

            // TODO #015
            // Randomizing mileage in between (exclusive both values) distMin and distMax.
            // This code below simply means something like "it is possible to
            // make between 6 and 16 thousands kilometers in a year" with weighting values
            // to more like 8 - 12 k kms a year. After that I multiply it by age of car.
            int distMin = 6;
            int distMax = 16;

            for (int k = distMin; k <= distMax; k++) {
                if (k >= 10 && k <= 11)
                    map.put(k, 8.0);
                else if ((k >= 8 && k <= 9) || k == 12)
                    map.put(k, 6.0);
                else if (k == 7 || k == 13)
                    map.put(k, 4.0);
                else if (k == 6 || k == 14)
                    map.put(k, 2.0);
                else
                    map.put(k, 1.0);
            }

            Integer traveledDist = Helper.getWeightedRandom(map);
            map.clear();

            double randomN = Helper.RNG.nextDouble(1000.0);

            // Take car age, multiply by random weighted value between distMin and distMax multiplied by
            // 10,000 and add some random value [0.0, 1000.0) on the end, so it looks more natural.
            Double mileageRandom = ageRandom * (double) traveledDist * 1000.0 + randomN;

            // TODO #010
            double valueRandom;

            // Based on segment we take randomize a car value in thousands.
            if (segment == Segment.BUDGET) {
                valueRandom = Math.ceil(price * Helper.RNG.nextDouble(0.8, 1.1)) * 1000;
            } else if (segment == Segment.STANDARD) {
                valueRandom = Math.ceil(price * Helper.RNG.nextDouble(0.9, 1.1)) * 1000;
            } else { // else means Segment.PREMIUM in that case
                valueRandom = Math.ceil(price * Helper.RNG.nextDouble(0.95, 1.3)) * 1000;
            }

            Color colorRandom = Color.getRandomColor();

            Car carRandom = new Car(brandName, modelName, ageRandom, mileageRandom, valueRandom, colorRandom);

            cars.add(carRandom);
        }
        setCars(cars);
    }
}
