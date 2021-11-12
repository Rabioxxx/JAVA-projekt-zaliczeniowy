package com.szymonjasinski;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Helper {
    static Double roundMoney(Double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}