package com.szymonjasinski;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class BrandsTest {

    @Test
    void randomBrand() {
        System.out.println(Brands.randomBrand().getName());
    }

    @Test
    void getName() {

    }
}