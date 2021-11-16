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
        Brand audi = Brand.AUDI;
        Brand opel = Brand.OPEL;
        Brand volkswagen = Brand.VOLKSWAGEN;
        Brand ford = Brand.FORD;

        System.out.println(bmw.getBrandCommonness());
        System.out.println(audi.getBrandCommonness());
        System.out.println(opel.getBrandCommonness());
        System.out.println(volkswagen.getBrandCommonness());
        System.out.println(ford.getBrandCommonness());

        System.out.println(Brand.SUM_ALL_BRANDS_COMMONNESS);

        System.out.println(Helper.RNG.nextDouble());
    }
}