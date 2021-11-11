package com.szymonjasinski;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static char input;

    public static void main(String[] args) {

        printAndWaitForInput(
                """
                        Wanna play some game?
                        a - new game
                        b - exit program"""
        );

        printAndWaitForInput(
                """
                                                    
                        What do you want to do now?
                                                    
                        a - show cars available at https://www.cars.com/.
                        b - show cars you own.
                        c - show clients.
                        d - check marketing options.
                        e - check you bank account.""");
    }

    static void printAndWaitForInput(String message) {

        scanner = new Scanner(System.in);

        do {
            System.out.println("\n" + message);

            // Wait for user input and assign value to variable input.
            input = scanner.next().charAt(0);

            // TODO Could change a, b, c ... to interval from 97 (lowercase a) to 122 (lowercase z)
            switch (input) {
                case 'a', 'b', 'c', 'd', 'e' -> System.out.println(input + " clicked.");
                default -> System.out.println(">:(");
            }
        } while (input < 97 || input > 122);
    }
}
