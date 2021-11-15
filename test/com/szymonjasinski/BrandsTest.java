package com.szymonjasinski;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrandsTest {

    @Test
    void Test() {
        Brands brand = Brands.randomBrand();
    }
}