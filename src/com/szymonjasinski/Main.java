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

        // That means new game was clicked.
        if (input == 97) {

            // Here I am going to generate objects needed to be generated on the beginning of the new game.
            Player player = new Player();
            Market market = new Market();
            Calendar calendar = new Calendar();

            //Debugging purposes.
            player.setCash(5000000.0);
            System.out.println("Debug: Cash set! It is now: " + Helper.moneyPretty(player.getCash()));

            market.carsGenerator(21);
            System.out.println("Debug: Cars available to buy - ready!");

            market.clientsGenerator(6);
            System.out.println("Debug: Clientele list created.");

            do {
                System.out.println("\n" + calendar.getDate());
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
                            // TODO #020
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
                                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                                    Car car = cars.get(j);
                                    System.out.println((char) i + " - " + car.getProducer() + " " + car.getModel() + " " + Helper.moneyPretty(car.getPrice()) + " " + car.getShape());
                                    i++;

                                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is less objects to print than carsToPrint.
                                        System.out.println("Site " + currentSite + "/" + totalSites);

                                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
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
                                        } else if (input2 >= 97 && input2 < 97 + max - lastPageCorrection) {

                                            car = cars.get(input2 - 97 + offset);
                                            System.out.println(car.getCar());

                                            char buyInput;
                                            System.out.println("\nPress x to continue or b to buy this car (buying pass a day).");

                                            do {
                                                buyInput = scanner.next().charAt(0);
                                                System.out.println(buyInput + " clicked.\n");

                                                if (buyInput == 'b') {
                                                    Double playerCash = player.getCash();
                                                    Double carPrice = car.getPrice();

                                                    if (playerCash < carPrice) {
                                                        System.out.println("You don't have enough cash for this transaction.");
                                                    } else {
                                                        player.setCash(playerCash - carPrice);
                                                        System.out.println("Debug: player cash adjusted.");

                                                        cars.remove(input2 - 97 + offset);
                                                        System.out.println("Debug: car removed.");

                                                        player.addCar(car);
                                                        System.out.println("Debug: car added to player parking.");

                                                        // When removing car we need to let the loop above know about it, as we first declare this variable outside the loop,
                                                        // so if not updating it now, we never update it. It will try to print a car that is not in this list, so we will leave bounds of an array.
                                                        carsArraySize = cars.size();

                                                        // Changing new max if on new first page will be less than carsToPrint cars (ie 10).
                                                        max = Math.min(carsToPrint, carsArraySize);

                                                        if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                            totalSites -= 1;
                                                            currentSite -= 1;
                                                            lastPageCorrection = 0;
                                                            offset -= carsToPrint;
                                                        } else {
                                                            // Basically check if we now have fewer pages.
                                                            totalSites = (int) Math.ceil(carsArraySize / (double) carsToPrint); // This one also need to be updated if we are going to buy last car on the last page.
                                                        }

                                                        // Passing a day, because car was bought.
                                                        calendar.nextDay();
                                                    }
                                                } else
                                                    System.out.println(">:(");
                                            } while (buyInput != 'x' && buyInput != 'b');
                                            break;
                                        } else {
                                            if (input2 != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                                System.out.println(">:(");
                                        }
                                    }
                                }
                            } while (input2 == 62 || input2 == 60 || (input2 >= 97 && input2 <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
                        } while (input2 != 'x');
                    }
                    case 'b' -> {
                        char input2 = 97;

                        System.out.println(input + " clicked.\n");

                        ArrayList<Car> cars = player.getCars();

                        if (cars == null) {
                            System.out.println("You have no cars in your parking lot.");

                        } else {
                            System.out.println("You have following cars in your parking lot:");
                            // It is a lambda expression.
                            // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
                            cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

                            // TODO #014 - Restricting loops.
                            // TODO #020
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
                                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                                    Car car = cars.get(j);
                                    //System.out.println((char) i + " - " + car.getProducer() + " " + car.getModel() + " " + Helper.moneyPretty(car.getPrice()) + " " + car.getShape());
                                    System.out.printf("%c - %s %s %s %s \n", (char) i, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getValue()), car.getShape());
                                    i++;

                                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is less objects to print than carsToPrint.
                                        System.out.println("Site " + currentSite + "/" + totalSites);

                                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
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
                                        } else if (input2 >= 97 && input2 < 97 + max - lastPageCorrection) {

                                            car = cars.get(input2 - 97 + offset);
                                            System.out.println(car.getCar());

                                            // These variables change usable keys.
                                            char repairKey = 'r';
                                            char washKey = 'w';

                                            char input;

                                            do {
                                                System.out.println("\nPress x to get back, " + repairKey + " to repair part or " + washKey + " to wash car.");

                                                input = scanner.next().charAt(0);
                                                System.out.println(input + " clicked.\n");

                                                if (input == repairKey) {

                                                    Boolean[] partList = car.getAllParts();
                                                    if (car.getEngine() && car.getTransmission() && car.getBody() && car.getSuspension() && car.getBrakes()) {
                                                        System.out.println("This car does not need any repairs.");
                                                    } else {

                                                        char inputPartRepair;

                                                        double enginePrice = car.getEngineRepairPrice();
                                                        double transmissionPrice = car.getTransmissionRepairPrice();
                                                        double bodyPrice = car.getBodyRepairPrice();
                                                        double suspensionPrice = car.getSuspensionRepairPrice();
                                                        double brakesPrice = car.getBrakesRepairPrice();

                                                        double playerCash = player.getCash();

                                                        do {
                                                            System.out.println("What would you like to repair?");
                                                            System.out.println("a - engine " + Helper.moneyPretty(enginePrice));
                                                            System.out.println("b - transmission " + Helper.moneyPretty(transmissionPrice));
                                                            System.out.println("c - body " + Helper.moneyPretty(bodyPrice));
                                                            System.out.println("d - suspension " + Helper.moneyPretty(suspensionPrice));
                                                            System.out.println("e - brakes " + Helper.moneyPretty(brakesPrice));
                                                            System.out.println();
                                                            System.out.println("x - get back");

                                                            inputPartRepair = scanner.next().charAt(0);
                                                            System.out.println("Debug: " + inputPartRepair + " clicked.\n");

                                                            if (inputPartRepair == 'x') {
                                                                System.out.println("Goin' back then.");
                                                            } else if (inputPartRepair == 97) {
                                                                if (partList[0])
                                                                    System.out.println("Engine doesn't need any repairs.");
                                                                else {
                                                                    if (playerCash <= enginePrice) {
                                                                        System.out.println("You have not enough money for that.");
                                                                    } else {
                                                                        playerCash -= enginePrice; // This is for local variable if we won't refresh it above. Problem would be then that it would have the old value.
                                                                        player.setCash(playerCash); // updating global player cash.
                                                                        car.setEngine(true); // repairing!
                                                                        calendar.nextDay();
                                                                        System.out.println("Engine repaired (One day have passed).");
                                                                    }
                                                                }

                                                            } else if (inputPartRepair == 98) {
                                                                if (partList[1])
                                                                    System.out.println("Transmission doesn't need any repairs.");
                                                                else {
                                                                    if (playerCash <= transmissionPrice) {
                                                                        System.out.println("You have not enough money for that.");
                                                                    } else {
                                                                        playerCash -= transmissionPrice; // This is for local variable if we won't refresh it above. Problem would be then that it would have the old value.
                                                                        player.setCash(playerCash); // updating global player cash.
                                                                        car.setTransmission(true); // repairing!
                                                                        calendar.nextDay();
                                                                        System.out.println("Transmission repaired (One day have passed).");
                                                                    }
                                                                }

                                                            } else if (inputPartRepair == 99) {
                                                                if (partList[2])
                                                                    System.out.println("Body doesn't need any repairs.");
                                                                else {
                                                                    if (playerCash <= bodyPrice) {
                                                                        System.out.println("You have not enough money for that.");
                                                                    } else {
                                                                        playerCash -= bodyPrice; // This is for local variable if we won't refresh it above. Problem would be then that it would have the old value.
                                                                        player.setCash(playerCash); // updating global player cash.
                                                                        car.setBody(true); // repairing!
                                                                        calendar.nextDay();
                                                                        System.out.println("Body repaired (One day have passed).");
                                                                    }
                                                                }

                                                            } else if (inputPartRepair == 100) {
                                                                if (partList[3])
                                                                    System.out.println("Suspension doesn't need any repairs.");
                                                                else {
                                                                    if (playerCash <= suspensionPrice) {
                                                                        System.out.println("You have not enough money for that.");
                                                                    } else {
                                                                        playerCash -= suspensionPrice; // This is for local variable if we won't refresh it above. Problem would be then that it would have the old value.
                                                                        player.setCash(playerCash); // updating global player cash.
                                                                        car.setSuspension(true); // repairing!
                                                                        calendar.nextDay();
                                                                        System.out.println("Suspension repaired (One day have passed).");
                                                                    }
                                                                }

                                                            } else if (inputPartRepair == 101) {
                                                                if (partList[4])
                                                                    System.out.println("Brakes doesn't need any repairs.");
                                                                else {
                                                                    if (playerCash <= brakesPrice) {
                                                                        System.out.println("You have not enough money for that.");
                                                                    } else {
                                                                        playerCash -= brakesPrice; // This is for local variable if we won't refresh it above. Problem would be then that it would have the old value.
                                                                        player.setCash(playerCash); // updating global player cash.
                                                                        car.setBrakes(true); // repairing!
                                                                        calendar.nextDay();
                                                                        System.out.println("Brakes repaired (One day have passed).");
                                                                    }
                                                                }

                                                            } else {
                                                                System.out.println(">:(");
                                                                inputPartRepair = '$';
                                                            }
                                                        } while (inputPartRepair == '$');
                                                    }
                                                } else
                                                    System.out.println(">:(");
                                            } while (input != 'x' && input != repairKey && input != washKey);
                                            break;
                                        } else {
                                            if (input2 != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                                System.out.println(">:(");
                                        }
                                    }
                                }
                            } while (input2 == 62 || input2 == 60 || (input2 >= 97 && input2 <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
                        }
                    }
                    case 'c' -> {
                        System.out.println(input + " clicked.\n");

                        char input2 = 97;

                        do {
                            System.out.println("Your clientele below:");

                            // get ArrayList of clients and then printing all clients in this Array to console. What exactly is printed is defined with toString().
                            ArrayList<Client> clients = market.getClients();

                            Boolean willBuyBrokenCar = false;
                            Boolean willBuyDamagedCar = false;

                            // TODO #014 - Restricting loops.
                            // TODO #020
                            int i; // it is here to make this first letter that shows what will happen when you click it.
                            int clientsSize = clients.size();
                            int clientsToPrint = 10; // how many rows containing clients names we want to print on one site.
                            int offset = 0;
                            int max = Math.min(clientsToPrint, clientsSize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.
                            int totalSites = (int) Math.ceil(clientsSize / (double) clientsToPrint); // total number of sites.
                            int currentSite = 1;
                            int lastPageCorrection = 0;

                            do {
                                i = 97; // 97 represents lowercase a.
                                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                                    Client client = clients.get(j);

                                    willBuyBrokenCar = client.getWillBuyBrokenCar();
                                    willBuyDamagedCar = client.getWillBuyDamagedCar();
                                    String willBuyBrokenCarString = "";
                                    String willBuyDamagedCarString = "";

                                    if (willBuyBrokenCar && willBuyDamagedCar)
                                        willBuyBrokenCarString = " Can buy broken car!";
                                    else if (willBuyDamagedCar)
                                        willBuyDamagedCarString = " Can buy without brakes and/or suspension!";


                                    System.out.printf("%c - This client will buy %s and %s.%s%s\n", (char) i, client.getInterestedBrand(0), client.getInterestedBrand(1), willBuyBrokenCarString, willBuyDamagedCarString);
                                    i++;

                                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is less objects to print than clientsToPrint.
                                        System.out.println("Site " + currentSite + "/" + totalSites);

                                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
                                        if (currentSite == 1 && currentSite == totalSites) {
                                            System.out.println("Choose a client or get back (x).");
                                        } else if (currentSite == 1)
                                            System.out.println("Choose a client, go to next site (>) or get back (x).");
                                        else if (currentSite == totalSites)
                                            System.out.println("Choose a client, go to previous site (<) or get back (x).");
                                        else
                                            System.out.println("Choose a client, go to next site (>), previous site (<) or get back (x).");

                                        input2 = scanner.next().charAt(0);
                                        System.out.println(input2 + " clicked.\n");

                                        if (input2 == 60 && currentSite != 1) { // 60 is '<'
                                            lastPageCorrection = 0;
                                            offset -= clientsToPrint;
                                            currentSite -= 1;
                                            break;
                                        } else if (input2 == 62 && currentSite != totalSites) { // 62 is '>'
                                            lastPageCorrection = 0;
                                            offset += clientsToPrint;
                                            // This if is for correction on last page that can contain less than clientsSize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                                            if (offset + clientsToPrint > clientsSize) {
                                                lastPageCorrection = offset + clientsToPrint - clientsSize;
                                            }
                                            currentSite += 1;
                                            break;
                                        } else if (input2 >= 97 && input2 < 97 + max - lastPageCorrection) {

                                            client = clients.get(input2 - 97 + offset);
                                            System.out.println("Which car would you like to sell to them?");

                                            char sellInput = 97;

                                            ArrayList<Car> cars = player.getCars();

                                            if (cars == null) {
                                                System.out.println("You have no cars in your parking lot.");

                                            } else {
                                                System.out.println("You have following cars in your parking lot:");
                                                // It is a lambda expression.
                                                // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
                                                cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

                                                // TODO #014 - Restricting loops.
                                                // TODO #020
                                                int k; // it is here to make this first letter that shows what will happen when you click it.
                                                int carsArraySize = cars.size();
                                                int carsToPrint = 10; // how many rows containing cars names we want to print on one site.
                                                int offset2 = 0;
                                                int max2 = Math.min(carsToPrint, carsArraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.
                                                int totalSites2 = (int) Math.ceil(carsArraySize / (double) carsToPrint); // total number of sites.
                                                int currentSite2 = 1;
                                                int lastPageCorrection2 = 0;

                                                do {
                                                    k = 97; // 97 represents lowercase a.
                                                    for (int l = offset2; l < max2 + offset2 - lastPageCorrection2; l++) {
                                                        Car car = cars.get(l);
                                                        //System.out.println((char) i + " - " + car.getProducer() + " " + car.getModel() + " " + Helper.moneyPretty(car.getPrice()) + " " + car.getShape());
                                                        System.out.printf("%c - %s %s %s %s \n", (char) k, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getValue()), car.getShape());
                                                        k++;

                                                        if (k == 97 + max2 - lastPageCorrection2) { // var max2 here, because it will then properly display first page if there is less objects to print than carsToPrint.
                                                            System.out.println("Site " + currentSite2 + "/" + totalSites2);

                                                            // Which message will be displayed depends on current site (first, last, first and last at the same time).
                                                            if (currentSite2 == 1 && currentSite2 == totalSites2) {
                                                                System.out.println("Choose a car or get back (x).");
                                                            } else if (currentSite2 == 1)
                                                                System.out.println("Choose a car, go to next site (>) or get back (x).");
                                                            else if (currentSite2 == totalSites2)
                                                                System.out.println("Choose a car, go to previous site (<) or get back (x).");
                                                            else
                                                                System.out.println("Choose a car, go to next site (>), previous site (<) or get back (x).");

                                                            sellInput = scanner.next().charAt(0);
                                                            System.out.println(sellInput + " clicked.\n");

                                                            if (sellInput == 60 && currentSite2 != 1) { // 60 is '<'
                                                                lastPageCorrection2 = 0;
                                                                offset2 -= carsToPrint;
                                                                currentSite2 -= 1;
                                                                break;
                                                            } else if (sellInput == 62 && currentSite2 != totalSites2) { // 62 is '>'
                                                                lastPageCorrection2 = 0;
                                                                offset2 += carsToPrint;
                                                                // This if is for correction on last page that can contain less than carsArraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                                                                if (offset2 + carsToPrint > carsArraySize) {
                                                                    lastPageCorrection2 = offset2 + carsToPrint - carsArraySize;
                                                                }
                                                                currentSite2 += 1;
                                                                break;
                                                            } else if (sellInput >= 97 && sellInput < 97 + max2 - lastPageCorrection2) {

                                                                car = cars.get(sellInput - 97 + offset2);

                                                                Double playerCash = player.getCash();

                                                                clients.remove(input2 - 97 + offset);
                                                                market.setClients(clients);
                                                                System.out.println("Debug: client removed.");

                                                                player.setCash(car.getValue() + playerCash);
                                                                System.out.println("Debug: Cash added to player account.");

                                                                cars.remove(sellInput - 97 + offset2);
                                                                player.setCars(cars);
                                                                System.out.println("Debug: Car removed from parking lot.");

                                                                // When removing client we need to let the loop above know about it, as we first declare this variable outside the loop,
                                                                // so if not updating it now, we never update it. It will try to print a client that is not in this list, so we will leave bounds of an array.
                                                                clientsSize = clients.size();
                                                                carsArraySize = cars.size();

                                                                // Changing new max if on new first page will be less than clientsToPrint clients (ie 10).
                                                                max = Math.min(clientsToPrint, clientsSize);
                                                                max2 = Math.min(carsToPrint, carsArraySize);

                                                                if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                                    totalSites -= 1;
                                                                    currentSite -= 1;
                                                                    lastPageCorrection = 0;
                                                                    offset -= clientsToPrint;
                                                                } else {
                                                                    // Basically check if we now have fewer pages.
                                                                    totalSites = (int) Math.ceil(clientsSize / (double) clientsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                                }

                                                                if (currentSite2 == totalSites2 && currentSite2 != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                                    totalSites2 -= 1;
                                                                    currentSite2 -= 1;
                                                                    lastPageCorrection2 = 0;
                                                                    offset2 -= clientsToPrint;
                                                                } else {
                                                                    // Basically check if we now have fewer pages.
                                                                    totalSites2 = (int) Math.ceil(carsArraySize / (double) carsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                                }

                                                                // Passing a day, because client was bought.
                                                                calendar.nextDay();

                                                                break;
                                                            } else {
                                                                if (sellInput != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                                                    System.out.println(">:(");
                                                            }
                                                        }
                                                    }
                                                } while (sellInput == 62 || sellInput == 60 || (sellInput >= 97 && sellInput <= 97 + max2)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
                                            }
                                            break;
                                        } else {
                                            if (input2 != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                                System.out.println(">:(");
                                        }
                                    }
                                }
                            } while (input2 == 62 || input2 == 60 || (input2 >= 97 && input2 <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
                        } while (input2 != 'x');
                    }
                    case 'e' -> {
                        System.out.println(input + " clicked.\n");
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
}
