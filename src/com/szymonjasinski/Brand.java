package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Brand { // Here I can add more car brands + their models! Data taken from https://www.otomoto.pl

    /*  These are constants which should be formatted like this:
     *   AUDI("Audi", new Model[]{Model.A4, Model.A6, Model.A3, Model.Q5, Model.A5, Model.A8, Model.Q7, Model.Q3, Model.TT, Model.S3}),
     *
     *   which means:
     *   CONSTANT_NAME("NAME OF BRAND", new Model[]{Model.MODEL1, Model.MODEL2, ... Model.MODELN},
     */

    BMW("BMW", new Model[]{Model.SERIES3, Model.SERIES5, Model.SERIES1, Model.X3, Model.X5, Model.SERIES7, Model.X1, Model.SERIES4, Model.SERIES2, Model.X6, Model.X4, Model.SERIES6, Model.I3, Model.X2}), // Sorted from the least popular

    AUDI("Audi", new Model[]{Model.A4, Model.A6, Model.A3, Model.Q5, Model.A5, Model.A8, Model.Q7, Model.Q3, Model.TT, Model.S3}),

    OPEL("Opel", new Model[]{Model.ASTRA, Model.INSIGNIA, Model.CORSA, Model.ZAFIRA, Model.MERIVA, Model.MOKKA, Model.VECTRA, Model.VIVARO, Model.CROSSLANDX, Model.GRANDLANDX, Model.COMBO, Model.ANTARA, Model.SIGNUM, Model.AGILA}),

    VOLKSWAGEN("Volkswagen", new Model[]{Model.GOLF, Model.PASSAT, Model.POLO, Model.TIGUAN, Model.TOURAN, Model.CADDY, Model.GOLFPLUS, Model.SHARAN, Model.ARTEON, Model.UP, Model.TRANSPORTER, Model.JETTA, Model.TOUAREG, Model.MULTIVAN, Model.TCROSS, Model.SCIROCCO, Model.CARAVELLE, Model.CC, Model.NEWBEETLE, Model.FOX, Model.GOLFSPORTSVAN, Model.TIGUANALLSPACE}),

    FORD("Ford", new Model[]{Model.FOCUS, Model.MONDEO, Model.FIESTA, Model.KUGA, Model.SMAX, Model.CMAX, Model.MUSTANG, Model.GALAXY, Model.FUSION, Model.ECOSPORT, Model.GRANDECMAX, Model.FOCUSCMAX, Model.KA, Model.EDGE, Model.ESCAPE, Model.TRANSIT, Model.RANGER, Model.TRANSITCUSTOM, Model.BMAX});

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
    private final Model[] model;

    Brand(String name, Model[] model) {
        this.name = name;
        this.model = model;
    }

    // Creating new list of Brand with all the values from enum Brand.
    private static final List<Brand> BRAND_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = BRAND_LIST.size();

    private static final SecureRandom RNG = new SecureRandom();

    // Assigning random integer that will be then an index of BRAND_LIST, so we can pick a specific brand from it.
    public static Brand randomBrand() {
        int i = RNG.nextInt(SIZE);
        return BRAND_LIST.get(i);
    }

    // It is mainly to use with randomBrand() to get a variable name. Then we will have also model to pick from, so we have a randomModel() for that.
    public String getName() {
        return this.name;
    }

    public Model[] getModel() {
        return model;
    }

    // Assigning random integer that will be then an index of models[], so we can pick a specific model from it.
    public String randomModel() {
        int i = RNG.nextInt(model.length);
        Model model = this.model[i];
        return model.getName();
    }
}
