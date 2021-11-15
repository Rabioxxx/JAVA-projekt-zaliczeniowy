package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Brands { // Here I can add more car brands + their models!
    ALFAROMEO("Alfa Romeo", new String[]{"500L", "500L Living", "500X Pulse", "Sedici", "Seiciento", "Multipla", "Siena", "Palio", "Marea", "Bravo", "Punto", "Cinquecento", "Tipo", "Tempra", "Croma", "Penny", "Marengo"}),
    AUDI("Audi", new String[]{"500L", "500L Living", "500X Pulse"}),
    BMW("BMW", new String[]{"500L", "500L Living", "500X Pulse"}),
    CHEVROLET("Chevrolet", new String[]{"500L", "500L Living", "500X Pulse"}),
    CITROEN("Citroen", new String[]{"500L", "500L Living", "500X Pulse"}),
    DACIA("Dacia", new String[]{"500L", "500L Living", "500X Pulse"}),
    DAEWOO("Daewoo", new String[]{"500L", "500L Living", "500X Pulse"}),
    DODGE("Dodge", new String[]{"500L", "500L Living", "500X Pulse"}),
    FIAT("Fiat", new String[]{"500L", "500L Living", "500X Pulse"}),
    FORD("Ford", new String[]{"500L", "500L Living", "500X Pulse"}),
    HONDA("Honda", new String[]{"500L", "500L Living", "500X Pulse"}),
    HYUNDAI("Hyundai", new String[]{"500L", "500L Living", "500X Pulse"}),
    JAGUAR("Jaguar", new String[]{"500L", "500L Living", "500X Pulse"}),
    JEEP("Jeep", new String[]{"500L", "500L Living", "500X Pulse"}),
    KIA("KIA", new String[]{"500L", "500L Living", "500X Pulse"}),
    LEXUS("Lexus", new String[]{"500L", "500L Living", "500X Pulse"}),
    MAZDA("Mazda", new String[]{"500L", "500L Living", "500X Pulse"}),
    MERCEDES("Mercedes-Benz", new String[]{"500L", "500L Living", "500X Pulse"}),
    MITSUBISHI("Mitsubishi", new String[]{"500L", "500L Living", "500X Pulse"}),
    NISSAN("Nissan", new String[]{"500L", "500L Living", "500X Pulse"}),
    OPEL("Opel", new String[]{"500L", "500L Living", "500X Pulse"}),
    PEUGEOT("Peugeot", new String[]{"500L", "500L Living", "500X Pulse"}),
    RENAULT("Renault", new String[]{"500L", "500L Living", "500X Pulse"}),
    SAAB("Saab", new String[]{"500L", "500L Living", "500X Pulse"}),
    SEAT("Seat", new String[]{"500L", "500L Living", "500X Pulse"}),
    SKODA("Skoda", new String[]{"500L", "500L Living", "500X Pulse"}),
    SUBARU("Subaru", new String[]{"500L", "500L Living", "500X Pulse"}),
    SUZUKI("Suzuki", new String[]{"500L", "500L Living", "500X Pulse"}),
    TESLA("Tesla", new String[]{"500L", "500L Living", "500X Pulse"}),
    TOYOTA("Toyota", new String[]{"500L", "500L Living", "500X Pulse"}),
    VOLKSWAGEN("Volkswagen", new String[]{"500L", "500L Living", "500X Pulse"}),
    VOLVO("Volvo", new String[]{"500L", "500L Living", "500X Pulse"});

    // I need a String value, so these values can have names.
    private final String name;
    private final String[] models;

    Brands(String name, String[] models) {
        this.name = name;
        this.models = models;
    }

    // Creating new list of Brands with all the values from enum Brands.
    private static final List<Brands> BRANDS_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = BRANDS_LIST.size();

    private static final SecureRandom RNG = new SecureRandom();

    public static Brands randomBrand() { // assigning random integer BUT not bigger than size of BRANDS_LIST. After that returns specified brands ex. ALFAROMEO.
        int i = RNG.nextInt(SIZE);
        return BRANDS_LIST.get(i);
    }

    public String getName() {
        return name;
    }
}
