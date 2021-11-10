package com.szymonjasinski;

public class Car {
    private final String producer;
    private final String model;
    private Integer age;
    private Double mileage;

    public Car(String producer, String model, Integer age, Double mileage) {
        this.producer = producer;
        this.model = model;
        this.age = age;
        this.mileage = mileage;
    }
}
