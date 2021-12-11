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

            market.carsGenerator(8);
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
                            int carsArraySize = cars.size();
                            int carsToPrint = 10; // how many rows containing cars names we want to print on one site.
                            int offset = 0;
                            int max = Math.min(carsToPrint, carsArraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.
                            int totalSites = (int) Math.ceil(carsArraySize / (double) carsToPrint); // total number of sites.
                            int currentSite = 1;
                            int lastPageCorrection = 0;

                            do {
                                i = 97; // 97 represents lowercase a.
                                for (int j = 0 + offset; j < max + offset - lastPageCorrection; j++) {
                                    Car car = cars.get(j);
                                    System.out.println((char) i + " - " + car.getProducer() + " " + car.getModel() + " $" + Helper.roundMoney(car.getValue()) + " " + car.getAge());
                                    i++;

                                    if (i >= 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is less objects to print than carsToPrint.
                                        System.out.println("Site " + currentSite + "/" + totalSites);

                                        if (currentSite == 1 && currentSite == totalSites) {
                                            System.out.println("Choose a car or get back (x).");
                                        } else if (currentSite == 1)
                                            System.out.println("Choose a car, go to next site (>) or get back (x).");
                                        else if (currentSite == totalSites)
                                            System.out.println("Choose a car, go to previous site (<) or get back (x).");
                                        else
                                            System.out.println("Choose a car, go to next site (>), previous site (<) or get back (x).");

                                        input2 = scanner.next().charAt(0);
                                        System.out.println(input2 + " clicked.\n");

                                        if (input2 == 60 && currentSite != 1) { // 60 is '<'
                                            lastPageCorrection = 0;
                                            offset -= carsToPrint;
                                            currentSite -= 1;
                                            break;
                                        } else if (input2 == 62 && currentSite != totalSites) { // 62 is '>'
                                            lastPageCorrection = 0;
                                            offset += carsToPrint;
                                            // This if is for correction on last page that can contain less than carsArraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                                            if (offset + carsToPrint > carsArraySize) {
                                                lastPageCorrection = offset + carsToPrint - carsArraySize;
                                            }
                                            currentSite += 1;
                                            break;
                                        } else if (input2 >= 97 && input2 <= 97 + carsToPrint - lastPageCorrection) {

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
                                            break;
                                        } else if (input2 == 'x') {
                                            // idk has to leave it empty for now.
                                        } else
                                            System.out.println(">:(");
                                    }
                                }
                            } while (input2 == 62 || input2 == 60 || (input2 >= 97 && input2 <= 97 + carsToPrint)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
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

    static void functiontest1() {

    }
}
