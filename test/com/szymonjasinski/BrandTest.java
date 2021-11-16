package com.szymonjasinski;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

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

        System.out.println(Brand.getSumAllBrandsCommonness());

        System.out.println(Helper.RNG.nextDouble());


        System.out.println("\n");

        System.out.println(Brand.getBrandList());
        System.out.println("\n");

        System.out.println(Brand.randomBrand().getName());
        System.out.println("\n");

        Brand brand = Brand.randomBrand();

        System.out.println(brand.getName() + " is the chosen one!");

        String brandModel = brand.randomModel().getName();

        System.out.println("And the chosen model is: " + brandModel);
        System.out.println(brand + " " + brandModel);

        System.out.println("\n\n\n");

        ArrayList<String> car = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Brand brand1 = Brand.randomBrand();
            Model brandModel1 = brand1.randomModel();

            car.add(brand1.getName() + " " + brandModel1.getName());
        }

        Collections.sort(car);

        for (String s : car) {
            System.out.println(s);
        }
    }

    @Test
    void Test2(){
        System.out.println(Helper.randomWeightedInteger());
    }
}