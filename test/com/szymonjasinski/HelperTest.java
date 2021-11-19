package com.szymonjasinski;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void createWeightedMap() {
        Map<Integer, Double> map = new HashMap<>();

        Helper.createWeightedMap(map, 10);
        map.clear();

        Helper.createWeightedMap(map, 15);
        map.clear();
    }
}