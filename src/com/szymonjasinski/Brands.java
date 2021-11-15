package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Brands { // Here I can add more car brands + their models! Data taken from https://www.otomoto.pl

    /*  These are constants which should be formatted like this:
     *   AUDI("Audi", new Models[]{Models.A4, Models.A6, Models.A3, Models.Q5, Models.A5, Models.A8, Models.Q7, Models.Q3, Models.TT, Models.S3}),
     *
     *   which means:
     *   CONSTANT_NAME("NAME OF BRAND", new Models[]{Models.MODEL1, Models.MODEL2 ... Models.MODELN},
     */

    BMW("BMW", new Models[]{Models.SERIES3, Models.SERIES5, Models.SERIES1, Models.X3, Models.X5, Models.SERIES7, Models.X1, Models.SERIES4, Models.SERIES2, Models.X6, Models.X4, Models.SERIES6, Models.I3, Models.X2}), // Sorted from the least popular

    AUDI("Audi", new Models[]{Models.A4, Models.A6, Models.A3, Models.Q5, Models.A5, Models.A8, Models.Q7, Models.Q3, Models.TT, Models.S3}),

    OPEL("Opel", new Models[]{Models.ASTRA, Models.INSIGNIA, Models.CORSA, Models.ZAFIRA, Models.MERIVA, Models.MOKKA, Models.VECTRA, Models.VIVARO, Models.CROSSLANDX, Models.GRANDLANDX, Models.COMBO, Models.ANTARA, Models.SIGNUM, Models.AGILA}),

    VOLKSWAGEN("Volkswagen", new Models[]{Models.GOLF, Models.PASSAT, Models.POLO, Models.TIGUAN, Models.TOURAN, Models.CADDY, Models.GOLFPLUS, Models.SHARAN, Models.ARTEON, Models.UP, Models.TRANSPORTER, Models.JETTA, Models.TOUAREG, Models.MULTIVAN, Models.TCROSS, Models.SCIROCCO, Models.CARAVELLE, Models.CC, Models.NEWBEETLE, Models.FOX, Models.GOLFSPORTSVAN, Models.TIGUANALLSPACE}),

    FORD/*12785*/("Ford", new Models[]{Models.FOCUS, Models.MONDEO, Models.FIESTA, Models.KUGA, Models.SMAX, Models.CMAX, Models.MUSTANG, Models.GALAXY, Models.FUSION, Models.ECOSPORT, Models.GRANDECMAX, Models.FOCUSCMAX, Models.KA, Models.EDGE, Models.ESCAPE, Models.TRANSIT, Models.RANGER, Models.TRANSITCUSTOM, Models.BMAX});

    //TOYOTA/*7250*/("Toyota", new String[]{"500L", "500L Living", "500X Pulse"}),
    //NISSAN/*4470*/("Nissan", new String[]{"500L", "500L Living", "500X Pulse"}),
    //FIAT/*4450*/("Fiat", new String[]{"500L", "500L Living", "500X Pulse"}),
    //ALFAROMEO/*1370*/("Alfa Romeo", new String[]{"500L", "500L Living", "500X Pulse", "Sedici", "Seiciento", "Multipla", "Siena", "Palio", "Marea", "Bravo", "Punto", "Cinquecento", "Tipo", "Tempra", "Croma", "Penny", "Marengo"}),
    //CHEVROLET/*1582*/("Chevrolet", new String[]{"500L", "500L Living", "500X Pulse"}),
    //CITROEN/*6115*/("Citroen", new String[]{"500L", "500L Living", "500X Pulse"}),
    //DACIA/*1782*/("Dacia", new String[]{"500L", "500L Living", "500X Pulse"}),
    //DAEWOO/*76*/("Daewoo", new String[]{"500L", "500L Living", "500X Pulse"}), // so rare car on otomoto that probably will not find his place in the game.
    //DODGE/*842*/("Dodge", new String[]{"500L", "500L Living", "500X Pulse"}),
    //HONDA/*3400*/("Honda", new String[]{"500L", "500L Living", "500X Pulse"}),
    //HYUNDAI/*5588*/("Hyundai", new String[]{"500L", "500L Living", "500X Pulse"}),
    //JAGUAR/*964*/("Jaguar", new String[]{"500L", "500L Living", "500X Pulse"}),
    //JEEP/*1710*/("Jeep", new String[]{"500L", "500L Living", "500X Pulse"}),
    //KIA/*5114*/("KIA", new String[]{"500L", "500L Living", "500X Pulse"}),
    //LANDROVER/*1024*/("Land Rover", new String[]{""}),
    //LEXUS/*895*/("Lexus", new String[]{"500L", "500L Living", "500X Pulse"}),
    //MAZDA/*3816*/("Mazda", new String[]{"500L", "500L Living", "500X Pulse"}),
    //MERCEDES/*10079*/("Mercedes-Benz", new String[]{"500L", "500L Living", "500X Pulse"}),
    //MINI/*1221*/("MINI", new String[]{""}),
    //MITSUBISHI/*1921*/("Mitsubishi", new String[]{"500L", "500L Living", "500X Pulse"}),
    //PEUGEOT/*6783*/("Peugeot", new String[]{"500L", "500L Living", "500X Pulse"}),
    //PORSCHE/*1034*/("Porsche", new String[]{""}),
    //RENAULT/*9091*/("Renault", new String[]{"500L", "500L Living", "500X Pulse"}),
    //SAAB/*401*/("Saab", new String[]{"500L", "500L Living", "500X Pulse"}),
    //SEAT/*3828*/("Seat", new String[]{"500L", "500L Living", "500X Pulse"}),
    //SKODA/*6634*/("Skoda", new String[]{"500L", "500L Living", "500X Pulse"}),
    //SUBARU/*883*/("Subaru", new String[]{"500L", "500L Living", "500X Pulse"}),
    //SUZUKI/*2218*/("Suzuki", new String[]{"500L", "500L Living", "500X Pulse"}),
    //TESLA/*75*/("Tesla", new String[]{"500L", "500L Living", "500X Pulse"}),
    //VOLVO/*4788*/("Volvo", new String[]{"500L", "500L Living", "500X Pulse"});

    // I need a String value, so these values can have names.
    private final String name;
    // value = (key, value)
    // (key, value)
    //
    // (key, (key, value))
    private final Models[] models;

    Brands(String name, Models[] models) {
        this.name = name;
        this.models = models;
    }

    // Creating new list of Brands with all the values from enum Brands.
    private static final List<Brands> BRANDS_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = BRANDS_LIST.size();

    private static final SecureRandom RNG = new SecureRandom();

    // Assigning random integer that will be then an index of BRANDS_LIST, so we can pick a specific brand from it.
    public static Brands randomBrand() {
        int i = RNG.nextInt(SIZE);
        return BRANDS_LIST.get(i);
    }

    // It is mainly to use with randomBrand() to get a variable name. Then we will have also model to pick from, so we have a randomModel() for that.
    public String getName() {
        return name;
    }

    public Models[] getModels() {
        return models;
    }

    // Assigning random integer that will be then an index of models[], so we can pick a specific model from it.
    public String randomModel() {
        int i = RNG.nextInt(models.length);
        Models model = models[i];
        return model.getName();
    }
}
