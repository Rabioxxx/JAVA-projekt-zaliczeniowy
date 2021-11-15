package com.szymonjasinski;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Brands { // Here I can add more car brands + their models! Data taken from https://www.otomoto.pl
    BMW/*15009*/("BMW", new String[]{"Series 3"/*3866*/, "Series 5"/*3272*/, "Series 1"/*1377*/, "X3"/*1224*/, "X5"/*926*/, "Series 7"/*729*/, "X1"/*599*/, "Series 4"/*455*/, "Series 2"/*332*/, "X6"/*267*/, "X4"/*214*/, "Series 6"/*196*/, "3GT"/*183*/, "I3"/*154*/, "X2"/*106*/}), // Sorted from the least popular
    AUDI/*14767*/("Audi", new String[]{"A4"/*3884*/, "A6"/*2992*/, "A3"/*2206*/, "Q5"/*960*/, "A5"/*885*/, "A8"/*518*/, "Q7"/*478*/, "Q3"/*451*/, "TT"/*175*/, "S3"/*150*/}),
    OPEL/*14721*/("Opel", new String[]{"Astra"/*4754*/, "Insignia"/*2324*/, "Corsa"/*2109*/, "Zafira"/*1169*/, "Meriva"/*1131*/, "Mokka"/*982*/, "Vectra"/*582*/, "Vivaro"/*266*/, "Crossland X"/*250*/, "Grandland X"/*193*/, "Combo"/*189*/, "Antara"/*183*/, "Signum"/*126*/, "Agila"/*103*/}),
    VOLKSWAGEN/*14236*/("Volkswagen", new String[]{"Gold"/*3380*/, "Passat"/*2826*/, "Polo"/*1328*/, "Tiguan"/*1071*/, "Touran"/*835*/, "Caddy"/*459*/, "Golf Plus"/*449*/, "Sharan"/*338*/, "Arteon"/*301*/, "up!"/*280*/, "Transporter"/*279*/, "Jetta"/*266*/, "Touareg"/*248*/, "Multivan"/*237*/, "T-Cross"/*223*/, "Scirocco"/*170*/, "Caravelle"/*148*/, "CC"/*145*/, "New Beetle"/*129*/, "Fox"/*119*/, "Golf Sportsvan"/*112*/, "Tiguan Allspace"/*102*/}),
    FORD/*12785*/("Ford", new String[]{"Focus"/*2712*/, "Mondeo"/*2340*/, "Fiesta"/*1481*/, "Kuga"/*1137*/, "S-MAX"/*941*/, "C-MAX"/*654*/, "Mustang"/*437*/, "Galaxy"/*337*/, "Fusion"/*262*/, "EcoSport"/*227*/, "Grands C-MAX"/*213*/, "Focus C-MAX"/*189*/, "KA"/*188*/, "EDGE"/*188*/, "Escape"/*142*/, "Transit"/*128*/, "Ranger"/*126*/, "Transit Custom"/*123*/, "B-MAX"/*120*/});
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

    // Assigning random integer that will be then an index of BRANDS_LIST, so we can pick a specific brand from it.
    public static Brands randomBrand() {
        int i = RNG.nextInt(SIZE);
        return BRANDS_LIST.get(i);
    }

    public String getName() {
        return name;
    }

    public String[] getModels() {
        return models;
    }

    // Assigning random integer that will be then an index of models[], so we can pick a specific model from it.
    public String randomModel() {
        int i = RNG.nextInt(models.length);
        return models[i];
    }
}
