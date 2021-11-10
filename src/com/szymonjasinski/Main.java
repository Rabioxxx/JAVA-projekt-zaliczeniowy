package com.szymonjasinski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        char input;

        do {
            System.out.println(
                    """
                                                        
                            What do you want to do now?
                                                        
                            a - show cars available at https://www.cars.com/.
                            b - show cars you own.
                            c - show clients.
                            d - check marketing options.
                            e - check you bank account.""");

            input = scanner.next().charAt(0);

            // TODO Could change a, b, c ... to interval from 97 (lowercase a) to 122 (lowercase z)
            switch (input) {
                case 'a' -> System.out.println(input + " clicked.");
                case 'b' -> System.out.println(input + " clicked.");
                case 'c' -> System.out.println(input + " clicked.");
                case 'd' -> System.out.println(input + " clicked.");
                case 'e' -> System.out.println(input + " clicked.");
                default -> System.out.println(">:(");
            }
        } while (input != 'a'
                && input != 'b'
                && input != 'c'
                && input != 'd'
                && input != 'e');
    }
}
