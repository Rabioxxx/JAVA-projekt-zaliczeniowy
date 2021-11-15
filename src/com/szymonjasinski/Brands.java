package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Brands { // Here I can add more car brands.
    ALFAROMEO("Alfa Romeo"), AUDI("Audi"), BMW("BMW"), CHEVROLET("Chevrolet"), CITROEN("Citroen"), DACIA("Dacia"), DAEWOO("Daewoo"), DODGE("Dodge"), FIAT("Fiat"), FORD("Ford"), HONDA("Honda"), HYUNDAI("Hyundai"), JAGUAR("Jaguar"), JEEP("Jeep"), KIA("KIA"), LEXUS("Lexus"), MAZDA("Mazda"), MERCEDES("Mercedes-Benz"), MITSUBISHI("Mitsubishi"), NISSAN("Nissan"), OPEL("Opel"), PEUGEOT("Peugeot"), RENAULT("Renault"), SAAB("Saab"), SEAT("Seat"), SKODA("Skoda"), SUBARU("Subaru"), SUZUKI("Suzuki"), TESLA("Tesla"), TOYOTA("Toyota"), VOLKSWAGEN("Volkswagen"), VOLVO("Volvo");

    // I need a String value.
    String name;

    Brands(String name) {
        this.name = name;
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
