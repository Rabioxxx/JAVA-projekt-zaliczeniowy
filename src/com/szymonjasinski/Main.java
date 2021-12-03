package com.szymonjasinski;

import java.util.ArrayList;
import java.util.Comparator;
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
                case 'a' -> System.out.println(input + " clicked.\n");
                case 'b' -> System.out.println("Closing."); // TODO #002 find a way to close a program with it.
                default -> System.out.println(">:(");
            }
        } while (input < 97 || input > 98);

        //System.out.println(Player.carsBuyable);

        if (input == 97) // That means new game was clicked.
        {
            // Here I am going to generate things needed to be generated on the beginning of the new game.
            Player player = new Player();
            Market market = new Market();

            //Debugging purposes.
            player.setCash(50000.0);
            System.out.println("Your cash is set! It is now: " + Helper.moneyPretty(player.getCash()));

            market.carsGenerator(21);
            System.out.println("Cars available to buy - ready!");

            do {
                System.out.println(
                        """
                                                            
                                What do you want to do now?
                                                            
                                a - show cars available to buy at https://www.cars.com/.
                                b - show cars you own.
                                c - show clients.
                                d - check marketing options.
                                e - check yours bank account.
                                f - exit game.""");

                input = scanner.next().charAt(0);

                // TODO #001
                switch (input) {
                    case 'a' -> {
                        char input2 = 97;

                        System.out.println(input + " clicked.\n");

                        do {
                            // get ArrayList of cars and then printing all cars in this Array to console. What exactly is printed is defined with toString().
                            ArrayList<Car> cars = market.getCars();

                            // It is a lambda expression.
                            // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
                            cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

                            // TODO #014 - Restricting loops.
                            int i; // it is here to make this first letter that shows what will happen when you click it.
                            int carsOnScreen = 10;
                            int offset = 0;
                            int max = Math.min(carsOnScreen, cars.size());
                            int amountSites = (int) Math.ceil(cars.size() / (double) carsOnScreen);
                            int check = cars.size() % carsOnScreen;
                            int currentSite = 1;

                            do {
                                i = 97; // 97 represents lowercase a.
                                for (int j = 0 + offset; j < max + offset; j++) {
                                    Car car = cars.get(j);
                                    System.out.println((char) i + " - " + car.getProducer() + " " + car.getModel() + " $" + Helper.roundMoney(car.getValue()) + " " + car.getAge());
                                    i++;

                                    if (i >= 97 + carsOnScreen) {
                                        System.out.println("Site " + currentSite + "/" + amountSites);
                                        System.out.println("Choose a car, go to next site (>) or get back (x).");

                                        input2 = scanner.next().charAt(0);
                                        System.out.println(input2 + " clicked.\n");

                                        if (input2 == 60) {
                                            offset -= carsOnScreen;
                                            currentSite -= 1;
                                            break;
                                        } else if (input2 == 62) { // 62 is '>' and 60 is '<'
                                            offset += carsOnScreen;
                                            currentSite += 1;
                                            break;
                                        } else if (input2 >= 97 && input2 <= 97 + carsOnScreen) {

                                            car = cars.get(input2 - 97 + offset);
                                            System.out.println(car);

                                            char trashInput;
                                            System.out.println("\nPress x to continue.");

                                            do {
                                                trashInput = scanner.next().charAt(0);
                                                System.out.println(trashInput + " clicked.\n");
                                                if (trashInput != 'x')
                                                    System.out.println(">:(");
                                            } while (trashInput != 'x');

                                        } else
                                            System.out.println(">:(");

                                    }
                                }

                                    /* else {

                                        System.out.println("Choose a car or get back (x).");

                                        input2 = scanner.next().charAt(0);
                                        System.out.println(input2 + " clicked.\n");

                                        // get back to main menu

                                    }*/

                            } while (input2 == 62 || input2 == 60);


                            input2 = scanner.next().charAt(0);
                            System.out.println(input2 + " clicked.\n");


                            int maximum = cars.size() + 97;

                            if (maximum >= 120) // 120 represents lowercase x.
                                maximum = 119;

                        } while (input2 != 'x');
                    }
                    case 'b' -> {
                        System.out.println(input + " clicked.\n");

                        ArrayList<Car> cars = player.getCars();

                        if (cars != null) {
                            System.out.println("You have following cars in your parking lot:");
                            for (Car car : cars) {
                                System.out.println(car.toString());
                            }
                        } else {
                            System.out.println("You have no cars in your parking lot.");
                        }
                    }
                    case 'e' -> {
                        System.out.println(input + " clicked.\n");
                        System.out.println("You have $" + Helper.moneyPretty(player.getCash()) + ".");
                        char input;
                        do {
                            System.out.println("Do you want to check your last transactions? (y/n)");

                            input = scanner.next().charAt(0);

                            if (input == 'y') {
                                System.out.println("These are your last transactions: ");
                                // And here these transactions will be.
                            }
                        } while (input != 'y' && input != 'n');
                    }
                    case 'f' -> {
                    }
                    default -> System.out.println(">:(");
                }
                // TODO #005 while input == something
            } while (input != 'f');
        }
    }

    static void functiontest1(){

    }
}
