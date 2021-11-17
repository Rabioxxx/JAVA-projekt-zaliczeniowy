package com.szymonjasinski;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Map;

public interface Helper {

    // TODO #016
    // Functions for rounding values to specific number of decimal places.

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
}