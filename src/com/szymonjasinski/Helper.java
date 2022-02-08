package com.szymonjasinski;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Scanner;

public interface Helper {

    Scanner scanner = new Scanner(System.in);

    // TODO #016
    // Functions for rounding values to specific number of decimal places.

    static String moneyPretty(Double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return "$" + bd;
    }

    static Double roundMoney(Double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    static Double roundMileage(Double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    SecureRandom RNG = new SecureRandom();

    // This method works by giving her a Map with object as key and weight as a value.
    static <E> E getWeightedRandom(Map<E, Double> weights) {
        E result = null;
        double bestValue = Double.MAX_VALUE;

        for (E element : weights.keySet()) {
            Double x = weights.get(element);
            Double rn = RNG.nextDouble();
            Double y = -Math.log(rn);
            double value = y / x;

            if (value < bestValue) {
                bestValue = value;
                result = element;
            }
        }
        return result;
    }

    /*
    This method creates something like this for 9 values...

               weight
                 5             |
                 4          |  |  |
                 3       |  |  |  |  |
                 2    |  |  |  |  |  |  |
                 1 |  |  |  |  |  |  |  |  |
                   1  2  3  4  5  6  7  8  9
                             value

    It can also take odd values, but two middle values will have the same weight.
     */
    static Map<Integer, Double> createWeightedMap(Map<Integer, Double> map, int max) {
        double average = max / 2.0;
        double averageDown = Math.floor(average);
        double averageUp = Math.ceil(average);
        double counter = max - averageDown;
        double contraCounter = max;

        boolean switchUp = false;

        double isOdd = max % 2;
        double isEven = isOdd;
        if (isOdd == 0)
            isOdd = 1.0;
        else
            isOdd = 0.0;


        for (int i = 1; i <= max; i++) {
            if (i == averageUp) {
                map.put(i, averageUp);
                switchUp = true;
                counter = 0;
            } else if (i == counter - averageDown + isOdd && !switchUp)
                map.put(i, max - contraCounter + 1.0);
            else if (i == counter + averageDown + isEven && switchUp)
                map.put(i, max - (max - contraCounter));
            counter++;
            contraCounter--;
        }
        return map;
    }
}