package com.szymonjasinski;

import java.text.DecimalFormat;

public class Car {
    private String producer;
    private String model;
    private Integer age;
    private Double mileage;
    private Double value;
    private Color color;

    public Car(String producer, String model, Integer age, Double mileage, Double value, Color color) {
        if (age >= 0 && mileage >= 0) {
            this.producer = producer;
            this.model = model;
            this.age = age;
            this.mileage = mileage;
            this.value = value;
            this.color = color;
        } else {
            System.out.println("ERROR/. This car have a negative value of age and/or mileage.");
        }
    }

    public String mileageToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        return decimalFormat.format(mileage);
    }

    @Override
    public String toString() {
            return producer + " " + model;
    }
}
