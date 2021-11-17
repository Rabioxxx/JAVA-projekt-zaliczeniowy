package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Color {
    BLACK("Black"),
    WHITE("White"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    PINK("Pink"),
    VIOLET("Violet"),
    ORANGE("Orange");

    private final String name;

    // Creating new list of Brand with all the values from enum Brand.
    private static final List<Color> COLOR_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = COLOR_LIST.size();

    private static final SecureRandom RNG = new SecureRandom();

    Color(String name) {
        this.name = name;
    }

    public static Color getRandomColor(){
        int i = RNG.nextInt(SIZE);
        return COLOR_LIST.get(i);
    }

    String getName(){
        return name;
    }
}
