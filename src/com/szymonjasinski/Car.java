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

    private Double engineRepairPrice = 0.0;
    private Double transmissionRepairPrice = 0.0;
    private Double bodyRepairPrice = 0.0;
    private Double suspensionRepairPrice = 0.0;
    private Double brakesRepairPrice = 0.0;


    public Car(String producer, String model, Integer age, Double mileage, Double value, Double price, Color color, Boolean engine, Boolean transmission, Boolean body, Boolean suspension, Boolean brakes) {
        if (age >= 0 && mileage >= 0 && engine != null && transmission != null && body != null && suspension != null && brakes != null) {
            this.producer = producer;
            this.model = model;
            this.age = age;
            this.mileage = mileage;
            this.value = value;
            this.price = price;
            this.color = color;
            this.engine = engine;
            this.transmission = transmission;
            this.body = body;
            this.suspension = suspension;
            this.brakes = brakes;
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

    /**
     * Returns array of status of car parts. That is
     * 5 Boolean values, where 0 - is broken part and
     * 1 - is cool, not need repair.
     *
     * @return  Boolean Engine, Transmissin, Body, Suspension, Brakes.
     */
    public Boolean[] getAllParts(){
        return new Boolean[]{getEngine(), getTransmission(), getBody(), getSuspension(), getBrakes()};
    }

    private String getPartsBlock() {
        String engine = "need repairs";
        String transmission = "need repairs";
        String body = "need repairs";
        String suspension = "need repairs";
        String brakes = "need repairs";

        if (getEngine())
            engine = "works";
        if (getTransmission())
            transmission = "works";
        if (getBody())
            body = "lookin' good";
        if (getSuspension())
            suspension = "works";
        if (getBrakes())
            brakes = "works";

        return "Engine: " + engine + "\nTransmission: " + transmission + "\nBody: " + body + "\nSuspension: " + suspension + "\nBrakes: " + brakes;
    }

    public Double getEngineRepairPrice() {
        return engineRepairPrice;
    }

    public Double getTransmissionRepairPrice() {
        return transmissionRepairPrice;
    }

    public Double getBodyRepairPrice() {
        return bodyRepairPrice;
    }

    public Double getSuspensionRepairPrice() {
        return suspensionRepairPrice;
    }

    public Double getBrakesRepairPrice() {
        return brakesRepairPrice;
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

    public void setEngineRepairPrice(Double engineRepairPrice) {
        if (engineRepairPrice >= 0)
            this.engineRepairPrice = engineRepairPrice;
        else System.out.println("Trying to assign negative repair price to this part.");
    }

    public void setTransmissionRepairPrice(Double transmissionRepairPrice) {
        if (transmissionRepairPrice >= 0)
            this.transmissionRepairPrice = transmissionRepairPrice;
        else System.out.println("Trying to assign negative repair price to this part.");
    }

    public void setBodyRepairPrice(Double bodyRepairPrice) {
        if (bodyRepairPrice >= 0)
            this.bodyRepairPrice = bodyRepairPrice;
        else System.out.println("Trying to assign negative repair price to this part.");
    }

    public void setSuspensionRepairPrice(Double suspensionRepairPrice) {
        if (suspensionRepairPrice >= 0)
            this.suspensionRepairPrice = suspensionRepairPrice;
        else System.out.println("Trying to assign negative repair price to this part.");
    }

    public void setBrakesRepairPrice(Double brakesRepairPrice) {
        if (brakesRepairPrice >= 0)
            this.brakesRepairPrice = brakesRepairPrice;
        else System.out.println("Trying to assign negative repair price to this part.");
    }

    public String getShape() {
        String shape = "excellent shape";

        // If everything is broken then it is ruined (brakes can be ok, but it is still a ruin).
        if (!this.engine && !this.transmission && !this.body/* && !this.suspension*/)
            shape = "ruin";
        /*
        // If 3 expensive parts are broken
        else if (!this.engine && !this.transmission && !this.body)
            shape = "almost ruined";
        */
        // If 2 expensive parts are broken
        else if ((!this.engine && !this.transmission) || (!this.engine && !this.body) || (!this.transmission && !this.body))
            shape = "needs lot of work";
        // If any of the expensive part is broken
        else if (!this.engine || !this.transmission || !this.body)
            shape = "need repairs";
        // If everything is okay...
        else {
            // ... but not the sus or brakes.
            if (!this.suspension || !this.brakes)
                shape = "good condition";
        }

        return shape;
    }

    public String getCar() {
        return producer + " " + model + "\n" + age + " years old,\n" + Helper.roundMileage(mileage) + " km on odometer,\nPainted " + color.getName() + "\n" + getPartsBlock() + "\n" + Helper.moneyPretty(price);
    }

    @Override
    public String toString() {
        return producer + " " + model + "\n" + age + " years old,\n" + Helper.roundMileage(mileage) + " km on odometer,\nPainted " + color.getName() + "\n" + Helper.moneyPretty(price);
    }
}
