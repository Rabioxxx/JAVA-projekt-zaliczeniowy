package com.szymonjasinski;

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

    Color(String name) {
        this.name = name;
    }
}
