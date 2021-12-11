package com.szymonjasinski;

public class Car {
    private String producer;
    private String model;
    private Integer age;
    private Double mileage;
    private Double value; // of fully repaired car, should be hidden from player I guess.
    private Double price; // price of this specific car
    private Color color;

    /*
    Every car is build out of these things below.

    Engine          is 30% of its value.
    Transmission    is 25% of its value.
    Body            is 25% of its value.
    Suspension      is 8% of its value.
    Brakes          is 2% of its value.
                       90% of total value.

    10% that left is added by a car itself, as it works, was built, all parts were connected yada yada.
     */

    private Boolean engine;
    private Boolean transmission;
    private Boolean body;
    private Boolean suspension;
    private Boolean brakes;


    public Car(String producer, String model, Integer age, Double mileage, Double value, Double price, Color color) {
        if (age >= 0 && mileage >= 0) {
            this.producer = producer;
            this.model = model;
            this.age = age;
            this.mileage = mileage;
            this.value = value;
            this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public Boolean getEngine() {
        return engine;
    }

    public Boolean getTransmission() {
        return transmission;
    }

    public Boolean getBody() {
        return body;
    }

    public Boolean getSuspension() {
        return suspension;
    }

    public Boolean getBrakes() {
        return brakes;
    }

    public void setEngine(Boolean engine) {
        if (engine != null)
            this.engine = engine;
    }

    public void setTransmission(Boolean transmission) {
        if (transmission != null)
        this.transmission = transmission;
    }

    public void setBody(Boolean body) {
        if (body != null)
        this.body = body;
    }

    public void setSuspension(Boolean suspension) {
        if (suspension != null)
        this.suspension = suspension;
    }

    public void setBrakes(Boolean brakes) {
        if (brakes != null)
        this.brakes = brakes;
    }

    public void setParts(Boolean engine, Boolean transmission, Boolean body, Boolean suspension, Boolean brakes) {
        setEngine(engine);
        setTransmission(transmission);
        setBody(body);
        setSuspension(suspension);
        setBrakes(brakes);
    }

    @Override
    public String toString() {
        return producer + " " + model + "\n" + age + " years old,\n" + Helper.roundMileage(mileage) + " km on odometer,\nPainted " + color.getName() + "\n$" + Helper.moneyPretty(price);
    }
}
