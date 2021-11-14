package com.szymonjasinski;

import java.util.ArrayList;
import java.util.Random;

enum Brands{
    ALFAROMEO("Alfa Romeo"), AUDI("Audi"), BMW("BMW"), CHEVROLET("Chevrolet"), CITROEN("Citroen"), DACIA("Dacia"), DAEWOO("Daewoo"), DODGE("Dodge"), FIAT("Fiat"), FORD("Ford"), HONDA("Honda"), HYUNDAI("Hyundai"), JAGUAR("Jaguar"), JEEP("Jeep"), KIA("KIA"), LEXUS("Lexus"), MAZDA("Mazda"), MERCEDES("Mercedes-Benz"), MITSUBISHI("Mitsubishi"), NISSAN("Nissan"), OPEL("Opel"), PEUGEOT("Peugeot"), RENAULT("Renault"), SAAB("Saab"), SEAT("Seat"), SKODA("Skoda"), SUBARU("Subaru"), SUZUKI("Suzuki"), TESLA("Tesla"), TOYOTA("Toyota"), VOLKSWAGEN("Volkswagen"), VOLVO("Volvo");

    String name;

    Brands(String name){
        this.name = name;
    }
}

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
        String[] producers = {"Fiat", "Opel", "Ford", "Mercedes-Benz", "Renault", "Tesla", "Toyota", "Hyundai", "BMW", "SAAB", "KIA", "Daewoo", "Honda", "Nissan", "Peugeot", "Volvo", "Suzuki", "Mazda", "Subaru", "Jeep", "Audi", "Jaguar", "Dodge", "Alfa Romeo", "Lexus", "Chevrolet", "Volkswagen", "Mitsubishi", "Citroen", "Skoda", "SEAT", "Dacia"};
        String[] models = {"500", "Insignia", "Fiesta", "CLA45", "Clio", "Model X"};
        String[] fiatModels = {"500L", "500L Living", "500X", "Pulse", "Tipo", "Cronos", "Argo", "Uno", "Panda", "500", "New 500", "Mobi", /* up to this moment there are current models*/ "Sedici", "Seiciento", "Multipla", "Siena", "Palio", "Marea", "Bravo", "Punto", "Cinquecento", "Tipo", "Tempra", "Croma", "Penny", "Marengo"};

        if (number <= models.length) {

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
        }
    }
}
