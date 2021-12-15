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
            //Brand brandRandom = Brand.randomBrand(); // Takes one random enum constant and assigns it to brand variable. E.g. MERCEDES which has var name "Mercedes-Benz" and String[] of models.
            Brand brandRandom = Brand.randomBrand();
            Model brandModelRandom = brandRandom.randomModel(); // Now we take from brand variable (E.g. MERCEDES) a random model specific to a brand (E.g. CLASSC).
            Segment segment = brandModelRandom.getSegment();

            String brandName = brandRandom.getName(); // Now we get name of the brand. If it is e.g. MERCEDES it will give us "Mercedes-Benz".
            String modelName = brandModelRandom.getName(); // Taking model name as String. E.g. "Class C".

            Integer defaultValue = brandModelRandom.getValue();

            // TODO #007, #015
            // Randomizing age in between (exclusive) ageMin and ageMax values.
            // For now I am manually weighting it, can't find better solution for now.
            Map<Integer, Double> map = new HashMap<>();

            map.put(5, 2.0);
            map.put(6, 4.0);
            map.put(7, 8.0);
            map.put(8, 11.0);
            map.put(9, 12.0);
            map.put(10, 12.0);
            map.put(11, 12.0);
            map.put(12, 8.0);
            map.put(13, 3.0);
            map.put(14, 2.0);
            map.put(15, 2.0);
            map.put(16, 1.0);


            int ageMin = 5;
            int ageMax = 16; // not used actually but may be in the future

            /*
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
            */
            Integer ageRandom = Helper.getWeightedRandom(map);
            map.clear(); // Clears everything inside map.

            // TODO #015
            // Randomizing mileage in between (exclusive both values) distMin and distMax.
            // This code below simply means something like "it is possible to
            // make between 6 and 16 thousands kilometers in a year" with weighting values
            // to more like 8 - 12 k kms a year. After that I multiply it by age of car.
            int distMin = 5;
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
            Double value;

            // Real, objective value of a car.
            // Based on a segment we are randomizing car value a little.
            // Taking value of a car and multiplying it by some multiplier. After that 'converting' it to thousands.
            if (segment == Segment.BUDGET) {
                value = Math.ceil(defaultValue * Helper.RNG.nextDouble(0.9, 1.1)) * 1000;
            } else if (segment == Segment.STANDARD) {
                value = Math.ceil(defaultValue * Helper.RNG.nextDouble(0.9, 1.1)) * 1000;
            } else { // else means Segment.PREMIUM in that case
                value = Math.ceil(defaultValue * Helper.RNG.nextDouble(0.95, 1.2)) * 1000;
            }

            value = ageToValue(ageMin, ageRandom, value); // value of this car at current age.

            boolean engine;
            boolean transmission;
            boolean body;
            boolean suspension;
            boolean brakes;

            /*
             * Trying to rework that part a little. I have some ideas.
             * One of my ideas is to random engine, then assign values to other parts to true if it's broken.
             */
            engine = Helper.RNG.nextBoolean();
            transmission = Helper.RNG.nextBoolean();
            body = Helper.RNG.nextBoolean();
            suspension = Helper.RNG.nextBoolean();
            brakes = Helper.RNG.nextBoolean();

            // Basically I want to prevent minimize situations where cars have broken engine, transmission and body.
            if (!engine) {
                transmission = true;
                body = true;
            } else if (!transmission) {
                engine = Helper.RNG.nextBoolean();
            }

            // TODO #017 Randomizing price of a car based on parts it has to repair.
            double price;

            // Subjective price of a car.
            // Based on a segment we are randomizing car value a little.
            // Taking value of a car and multiplying it by some multiplier we get a price that seller want to get for it.
            int roundingTo = 100;
            if (value > 30000)
                roundingTo = 1000;

            if (segment == Segment.BUDGET) {
                price = Math.ceil(value / roundingTo * Helper.RNG.nextDouble(0.9, 1.1)) * roundingTo;
            } else if (segment == Segment.STANDARD) {
                price = Math.ceil(value / roundingTo * Helper.RNG.nextDouble(0.9, 1.1)) * roundingTo;
            } else { // else means Segment.PREMIUM in that case
                price = Math.ceil(value / roundingTo * Helper.RNG.nextDouble(0.95, 1.2)) * roundingTo;
            }

            double enginePrice = price * 0.3;
            double transmissionPrice = price * 0.25;
            double bodyPrice = price * 0.25;
            double suspensionPrice = price * 0.08;
            double brakesPrice = price * 0.02;

            if (!engine)
                price -= enginePrice;
            if (!transmission)
                price -= transmissionPrice;
            if (!body)
                price -= bodyPrice;
            if (!suspension)
                price -= suspensionPrice;
            if (!brakes)
                price -= brakesPrice;
            /*
                // debugging purposes.
            else
                System.out.println("Perfect car!");

            */

            Color colorRandom = Color.getRandomColor();

            Car carRandom = new Car(brandName, modelName, ageRandom, mileageRandom, value, price, colorRandom, engine, transmission, body, suspension, brakes);

            cars.add(carRandom);
        }
        setCars(cars);
    }

    // This method simulate losing value of a car with age.
    private Double ageToValue(Integer ageMin, Integer age, Double value) {
        if (age != ageMin) {
            for (int k = 0; k < age - ageMin; k++) {
                if (value >= 200000.0)
                    value -= 10000.0;
                else if (value >= 130000.0)
                    value -= 20000.0;
                else if (value >= 100000.0)
                    value -= 15000.0;
                else if (value >= 25000.0)
                    value -= 10000.0;
                else if (value >= 15000.0)
                    value -= 5000.0;
                else if (value >= 5000.0)
                    value -= 2500.0;
                else break;
            }
        }
        return value;
    }
}

