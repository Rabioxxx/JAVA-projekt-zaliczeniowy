package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.*;
import java.lang.*;

public class Market {
    private ArrayList<Car> cars;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void carsGenerator(Integer number) {
        // TODO #003
        /*
        String[] producers = {"Fiat", "Opel", "Ford", "Mercedes-Benz", "Renault", "Tesla", "Toyota", "Hyundai", "BMW", "SAAB", "KIA", "Daewoo", "Honda", "Nissan", "Peugeot", "Volvo", "Suzuki", "Mazda", "Subaru", "Jeep", "Audi", "Jaguar", "Dodge", "Alfa Romeo", "Lexus", "Chevrolet", "Volkswagen", "Mitsubishi", "Citroen", "Skoda", "SEAT", "Dacia"};
        String[] models = {"500", "Insignia", "Fiesta", "CLA45", "Clio", "Model X"};
        String[] fiatModels = {"500L", "500L Living", "500X", "Pulse", "Tipo", "Cronos", "Argo", "Uno", "Panda", "500", "New 500", "Mobi", *//* up to this moment there are current models*//* "Sedici", "Seiciento", "Multipla", "Siena", "Palio", "Marea", "Bravo", "Punto", "Cinquecento", "Tipo", "Tempra", "Croma", "Penny", "Marengo"};
         */


        SecureRandom rng = new SecureRandom();

        Brands brand = Brands.randomBrand(); // Takes one random enum constant and assigns it to brand variable. E.g. MERCEDES which has var name "Mercedes-Benz" and String[] of models.
        String brandRandom = brand.getName(); // Now we get name of the brand. If it is e.g. MERCEDES it will give us "Mercedes-Benz".
        String brandModelRandom = brand.randomModel(); // And here we take a random model from array models which is taken from another enum named Models.

        int ageRandom = rng.nextInt(30); // Random age from 0 to 30.


        ArrayList<Car> cars = new ArrayList<>();

        Car carRandom = new Car(brandRandom, brandModelRandom, ageRandom, /*mileageRandom*/ 0.0, /*valueRandom*/ 0.0, /*colorRandom*/ Color.BLACK);
        cars.add(carRandom);

        setCars(cars);



        /*if (number <= models.length) {

            Random rng = new Random();

            ArrayList<Car> cars = new ArrayList<>();

            for (int i = 0; i < number; i++) {

                int randomProducerAndModel = rng.nextInt(0, producers.length);
                int randomAge = rng.nextInt(0, 30);
                // TODO #004
                Double randomDouble = rng.nextDouble(25000.0, 300000.0);

                Car carRandom = new Car(producers[randomProducerAndModel], models[randomProducerAndModel], randomAge, randomDouble, randomDouble, Color.BLACK);
                cars.add(carRandom);
            }

            setCars(cars);

        } else {
            throw new ArrayIndexOutOfBoundsException("Variable number cannot be bigger than producers[]/models[] index.");
        }*/
    }
}
