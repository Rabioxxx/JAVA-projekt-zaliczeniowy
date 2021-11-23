package com.szymonjasinski;

public class Car {
    private String producer;
    private String model;
    private Integer age;
    private Double mileage;
    private Double value; // of fully repaired car
    private Color color;

    /*
    Every car is build out of these things below.

    Engine          is 35% of its value.
    Transmission    is 25% of its value.
    Body            is 15% of its value.
    Suspension      is 10% of its value.
    Brakes          is 5% of its value.
                       90% of total value.

    10% that left is added by a car itself, as it works, was built, all parts were connected yada yada.
     */

    private Boolean engine;
    private Boolean body;
    private Boolean transmission;
    private Boolean suspension;
    private Boolean brakes;


    public Car(String producer, String model, Integer age, Double mileage, Double value, Color color) {
        if (age >= 0 && mileage >= 0) {
            this.producer = producer;
            this.model = model;
            this.age = age;
            this.mileage = mileage;
            this.value = value;
            this.color = color;
        } else {
            System.out.println("ERROR/. This car cannot have a negative value of age and/or mileage.");
        }
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public Integer getAge() {
        return age;
    }

    public Double getMileage() {
        return mileage;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
            return producer + " " + model + " $" + Helper.roundMoney(value) + "\nAge = " + age + "\nMileage = " + Helper.roundMileage(mileage) + "\nPainted " + color.getName() + "\n";
    }
}
