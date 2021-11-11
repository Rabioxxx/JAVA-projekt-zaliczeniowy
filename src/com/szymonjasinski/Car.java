package com.szymonjasinski;

import java.awt.*;

public class Car {
    private String producer;
    private String model;
    private Integer age;
    private Double mileage;
    private Double value;
    private Color color;
    private Boolean cargo; // Ładownia - yes or no.

    public Car(String producer, String model, Integer age, Double mileage, Double value, Color color, Boolean cargo) {
        if (age >= 0 && mileage >= 0) {
            this.producer = producer;
            this.model = model;
            this.age = age;
            this.mileage = mileage;
            this.value = value;
            this.color = color;
            this.cargo = cargo;
        } else {
            System.out.println("ERROR/. This car have a negative value of age and/or mileage.");
        }
    }
}
