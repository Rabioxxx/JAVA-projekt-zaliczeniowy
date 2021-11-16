package com.szymonjasinski;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

class BrandTest {

    @Test
    void Test() {
        double mileageRandom = 97550.885200459;

        System.out.printf("bla bla bla %.2f %n", mileageRandom);

        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println(df.format(mileageRandom));

        Brand bmw = Brand.BMW;

        System.out.println(bmw.getBrandCommonness());
    }
}