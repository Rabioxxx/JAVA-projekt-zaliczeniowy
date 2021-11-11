package com.szymonjasinski;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static char input;

    public static void main(String[] args) {

        do {
            System.out.println(
                    """
                            Wanna play some game?

                            a - new game
                            b - exit program""");

            // Wait for user input and assign value to variable input.
            input = scanner.next().charAt(0);

            // TODO #001 Could change a, b, c ... to interval from 97 (lowercase a) to 122 (lowercase z).
            switch (input) {
                case 'a' -> System.out.println(input + " clicked.");
                case 'b' -> System.out.println("Closing."); // TODO #002 find a way to close a program with it.
                default -> System.out.println(">:(");
            }
        } while (input < 97 || input > 122);

        //System.out.println(Player.carsBuyable);

        if (input == 97) {
            newGameGenerator();
            System.out.println("Cars available to buy - ready!");
        }

        //System.out.println(Player.carsBuyable.get(0));

        /*
        printAndWaitForInput(
                """
                                                    
                        What do you want to do now?
                                                    
                        a - show cars available at https://www.cars.com/.
                        b - show cars you own.
                        c - show clients.
                        d - check marketing options.
                        e - check you bank account.""");

         */
    }

    static void printAndWaitForInput(String message) {

        scanner = new Scanner(System.in);

        do {
            System.out.println("\n" + message);

            // Wait for user input and assign value to variable input.
            input = scanner.next().charAt(0);

            // TODO #001 Could change a, b, c ... to interval from 97 (lowercase a) to 122 (lowercase z)
            switch (input) {
                case 'a', 'b', 'c', 'd', 'e' -> System.out.println(input + " clicked.");
                default -> System.out.println(">:(");
            }
        } while (input < 97 || input > 122);
    }

    static void newGameGenerator() {
        Player.carsBuyable = carsBuyableGenerator(6);
    }

    static ArrayList<Car> carsBuyableGenerator(Integer number) {
        // TODO #003
        String[] producers = {"Fiat", "Opel", "Ford", "Mercedes-Benz", "Renault", "Tesla"};
        String[] models = {"500", "Insignia", "Fiesta", "CLA45", "Clio", "Model X"};

        if (number <= producers.length) {

            Random rng = new Random();

            ArrayList<Car> cars = new ArrayList<>();

            for (int i = 0; i < number; i++) {

                int randomProducerAndModel = rng.nextInt(0, producers.length);
                int randomAge = rng.nextInt(0, 30);
                Double randomDouble = rng.nextDouble(25000.0, 300000.0);

                Car carRandom = new Car(producers[randomProducerAndModel], models[randomProducerAndModel], randomAge, randomDouble, randomDouble, Color.BLACK, false);
                cars.add(carRandom);
            }

            return cars;
        } else {
            throw new ArrayIndexOutOfBoundsException("Variable number cannot be bigger than producers[]/models[] index.");
        }

        /*
        Car fiat = new Car("Fiat", "500", 6, 93521.8, 20000.0, Color.black, false);
        Car opel = new Car("Opel", "Insignia", 3, 35651.0, 150000.0, Color.blue, false);
        Car ford = new Car("Ford", "Fiesta", 16, 193658.9, 6900.0, Color.gray, false);
        Car mercedes = new Car("Mercedes-Benz", "CLA45", 5, 44999.5, 200000.0, Color.white, false);
        Car renault = new Car("Renault", "Clio", 12, 220050.4, 24900.0, Color.red, false);
        Car tesla = new Car("Tesla", "Model X", 1, 5191.7, 450000.0, Color.white, false);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(fiat);
        cars.add(opel);
        cars.add(ford);
        cars.add(mercedes);
        cars.add(renault);
        cars.add(tesla);
        */
    }
}
