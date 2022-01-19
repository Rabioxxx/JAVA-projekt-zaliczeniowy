package com.szymonjasinski;

import java.util.ArrayList;

public class Client {
    private Boolean interestedInCargoCars;
    private Boolean interestedInPersonalCars;
    private ArrayList<Brand> interestedBrands;
    private Boolean willBuyBrokenCar; // Meaning: Whatever shape.
    private Boolean willBuyDamagedCar; // Meaning: Broken suspension/brakes.

    public Client(Boolean interestedInCargoCars, Boolean interestedInPersonalCars, ArrayList<Brand> interestedBrands, Boolean willBuyBrokenCar, Boolean willBuyDamagedCar) {
        this.interestedInCargoCars = interestedInCargoCars;
        this.interestedInPersonalCars = interestedInPersonalCars;
        this.interestedBrands = interestedBrands;
        this.willBuyBrokenCar = willBuyBrokenCar;
        this.willBuyDamagedCar = willBuyDamagedCar;
    }

    public Boolean getInterestedInCargoCars() {
        return interestedInCargoCars;
    }

    public Boolean getInterestedInPersonalCars() {
        return interestedInPersonalCars;
    }

    public ArrayList<Brand> getInterestedBrands() {
        return interestedBrands;
    }

    public Boolean getWillBuyBrokenCar() {
        return willBuyBrokenCar;
    }

    public Boolean getWillBuyDamagedCar() {
        return willBuyDamagedCar;
    }

    public String getInterestedBrand(int index){
        ArrayList<Brand> brands = getInterestedBrands();
        return brands.get(index).getName();
    }

    public String getClient(){
        return "";
    }
}
