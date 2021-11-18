package com.szymonjasinski;

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
