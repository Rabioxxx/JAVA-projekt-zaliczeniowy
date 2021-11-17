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

        market.carsGenerator(10);

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
    }
}