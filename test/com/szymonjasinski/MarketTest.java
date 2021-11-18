package com.szymonjasinski;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class MarketTest {

    @Test
    void carsGenerator() {
        // I was testing if values are distributed as I wanted them to be.

        Market market = new Market();

        market.carsGenerator(1000);

        Map<Integer, Integer> ageMap = new HashMap<>();

        int value = 0;

        for (Car car : market.getCars()) {
            Integer age = car.getAge();
            if (ageMap.containsKey(age))
                ageMap.replace(age, ageMap.get(age) + 1);
            else
                ageMap.put(age, 1);

            value++;
            if (value == 1000)
                System.out.println(value);
            if (value == 10000)
                System.out.println(value);
            if (value == 100000)
                System.out.println(value);
            if (market.getCars().size() == value)
                System.out.println("Test is ending!");
        }

        Map<Double, Integer> mileageMap = new HashMap<>();

        value = 0;

        for (Car car : market.getCars()) {
            Double mileage = car.getMileage();
            if (mileageMap.containsKey(mileage))
                mileageMap.replace(mileage, mileageMap.get(mileage) + 1);
            else
                mileageMap.put(mileage, 1);

            value++;
            if (value == 1000)
                System.out.println(value);
            if (value == 10000)
                System.out.println(value);
            if (value == 100000)
                System.out.println(value);
            if (market.getCars().size() == value)
                System.out.println("Test is ending!");
        }
    }
}