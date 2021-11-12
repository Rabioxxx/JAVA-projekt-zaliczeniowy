package com.szymonjasinski;

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

        if (input == 97) // That means new game was clicked.
        {
            Player player = new Player();
            Market market = new Market();

            player.setCash(50000.0);

            market.carsGenerator(6);

            System.out.println("Cars available to buy - ready!");

            System.out.println(
                    """
                                                        
                            What do you want to do now?
                                                        
                            a - show cars available to buy at https://www.cars.com/.
                            b - show cars you own.
                            c - show clients.
                            d - check marketing options.
                            e - check you bank account.""");

            input = scanner.next().charAt(0);

            // TODO #001
            switch (input) {
                case 'a':
                    System.out.println(input + " clicked.");
                    market.printCarsAllPretty();
                    break;
                default:
                    System.out.println(">:(");
                    break;
            }
        }
    }
}
