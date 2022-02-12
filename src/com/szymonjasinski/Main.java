package com.szymonjasinski;

public class Main {

    static char input;

    public static void main(String[] args) {
        do {
            System.out.println(
                    """
                            Wanna play some game?

                            a - new game
                            b - exit program""");

            // Wait for user input and assign value to variable input.
            input = Helper.scanner.next().charAt(0);

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

            // Setting goal to player.
            player.setGoal(player.getCash() * 2.0);

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

                input = Helper.scanner.next().charAt(0);

                // TODO #001
                switch (input) {
                    case 'a' -> {
                        market.printCarsAvailableToBuy(player, calendar, 10);
                    }
                    case 'b' -> {
                        player.printGarage(calendar, market);
                    }
                    case 'c' -> {
                        market.printClients(player, calendar);
                    }
                    case 'e' -> {
                        System.out.println("You have " + Helper.moneyPretty(player.getCash()) + ".");
                        char input;
                        do {
                            System.out.println("Do you want to check your last transactions? (y/n)");

                            input = Helper.scanner.next().charAt(0);

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
