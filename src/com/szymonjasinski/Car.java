package com.szymonjasinski;

public class Car {
    private String producer;
    private String model;
    private Integer age;
    private Double mileage;

    public Car(String producer, String model, Integer age, Double mileage) {
        if (age > 0 && mileage > 0) {
            this.producer = producer;
            this.model = model;
            this.age = age;
            this.mileage = mileage;
        } else {
            System.out.println("ERROR/. This car have a negative value of age and/or mileage.");
        }
    }
}
