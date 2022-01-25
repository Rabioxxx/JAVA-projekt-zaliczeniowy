package com.szymonjasinski;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
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
                case 'a' -> System.out.println("Loading...");
                case 'b' -> System.out.println("Closing."); // TODO #002 find a way to close a program with it.
                default -> System.out.println(">:(");
            }
        } while (input < 97 || input > 98);

        //System.out.println(Player.carsBuyable);

        // That means new game was clicked.
        if (input == 97) {

            // Here I am going to generate objects needed to be generated on the beginning of the new game.
            Player player = new Player();
            Market market = new Market();
            Calendar calendar = new Calendar();

            //Debugging purposes.
            player.setCash(5000000.0);
            System.out.println("Cash set!");
            // System.out.println("Debug: It is now: " + Helper.moneyPretty(player.getCash()));

            market.carsGenerator(21);
            System.out.println("Cars on market set!");

            market.clientsGenerator(21);
            System.out.println("Your first clients? Ready!");
            System.out.println("Looks like we're set and ready to go!");

            do {
                System.out.println("\n" + calendar.getDate() + " " + Helper.moneyPretty(player.getCash()));
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
                        printListOfCars(market, player, calendar, 10);
                    }
                    case 'b' -> {
                        player.printGarage(scanner, calendar, market);
                    }
                    case 'c' -> {
                        market.printClients(scanner, player, calendar);
                    }
                    case 'e' -> {
                        System.out.println("You have " + Helper.moneyPretty(player.getCash()) + ".");
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

    public static void printListOfCars(Market market, Player player, Calendar calendar, int rowsToPrint) {

        System.out.println("\nThese are the cars you are able to buy. If you have enough $$$ of course ;)");

        char input = 97;

        do {
            // get ArrayList of cars and then printing all cars in this Array to console. What exactly is printed is defined with toString().
            ArrayList<Car> cars = market.getCars();

            // It is a lambda expression(?).
            // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
            cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

            // TODO #014 - Restricting loops.
            // TODO #020
            int i; // it is here to make this first letter that shows what will happen when you click it.
            int arraySize = cars.size();
            // int rowsToPrint = 10; // how many rows containing cars names we want to print on one site.
            int offset = 0;
            int max = Math.min(rowsToPrint, arraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.

            int totalSites = (int) Math.ceil(arraySize / (double) rowsToPrint); // total number of sites.
            int currentSite = 1;
            int lastPageCorrection = 0;

            do {
                i = 97; // 97 represents lowercase a.
                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                    Car car = cars.get(j);
                    System.out.printf("%c - %s %s %s %s \n", (char) i, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getBuyingPrice()), car.getShape());
                    i++;

                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is fewer objects to print than rowsToPrint.
                        System.out.println("Site " + currentSite + "/" + totalSites);

                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
                        if (currentSite == 1 && currentSite == totalSites) {
                            System.out.println("Choose " + "an object" + " or get back (x).");
                        } else if (currentSite == 1)
                            System.out.println("Choose " + "an object" + ", go to next site (>) or get back (x).");
                        else if (currentSite == totalSites)
                            System.out.println("Choose " + "an object" + ", go to previous site (<) or get back (x).");
                        else
                            System.out.println("Choose " + "an object" + ", go to next site (>), previous site (<) or get back (x).");

                        // Buying car part:

                        input = scanner.next().charAt(0);

                        if (input == 60 && currentSite != 1) { // 60 is '<'
                            lastPageCorrection = 0;
                            offset -= rowsToPrint;
                            currentSite -= 1;
                            break;
                        } else if (input == 62 && currentSite != totalSites) { // 62 is '>'
                            lastPageCorrection = 0;
                            offset += rowsToPrint;
                            // This if is for correction on last page that can contain less than arraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                            if (offset + rowsToPrint > arraySize) {
                                lastPageCorrection = offset + rowsToPrint - arraySize;
                            }
                            currentSite += 1;
                            break;
                        } else if (input >= 97 && input < 97 + max - lastPageCorrection) {

                            car = cars.get(input - 97 + offset);
                            System.out.println(car.getCarStringPrice());

                            char buyInput;
                            System.out.println("\nPress x to continue or b to buy this car (buying pass a day).");

                            do {
                                buyInput = scanner.next().charAt(0);

                                if (buyInput == 'b') {
                                    Double playerCash = player.getCash();
                                    Double carPrice = car.getBuyingPrice();

                                    if (playerCash < carPrice) {
                                        System.out.println("You don't have enough cash for this transaction.");
                                    } else {
                                        player.setCash(playerCash - carPrice);
                                        System.out.println("Debug: player cash adjusted.");

                                        cars.remove(input - 97 + offset);
                                        System.out.println("Debug: car removed.");

                                        player.addCar(car);
                                        System.out.println("Debug: car added to player parking.");

                                        // When removing car we need to let the loop above know about it, as we first declare this variable outside the loop,
                                        // so if not updating it now, we never update it. It will try to print a car that is not in this list, so we will leave bounds of an array.
                                        arraySize = cars.size();

                                        // Changing new max if on new first page will be less than rowsToPrint cars (ie 10).
                                        max = Math.min(rowsToPrint, arraySize);

                                        if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                            totalSites -= 1;
                                            currentSite -= 1;
                                            lastPageCorrection = 0;
                                            offset -= rowsToPrint;
                                        } else {
                                            // Basically check if we now have fewer pages.
                                            totalSites = (int) Math.ceil(arraySize / (double) rowsToPrint); // This one also need to be updated if we are going to buy last car on the last page.
                                        }

                                        // Passing a day, because car was bought.
                                        calendar.nextDay(market);
                                    }
                                } else {
                                    System.out.println(">:(");
                                }
                            } while (buyInput != 'x' && buyInput != 'b');
                            break;
                        } else {
                            if (input != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                System.out.println(">:(");
                        }
                    }
                }
            } while (input == 62 || input == 60 || (input >= 97 && input <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
        } while (input != 'x'); // x means "go back"
    }
}
