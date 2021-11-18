package com.szymonjasinski;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Model {
    //BMW models 15009
    SERIES3(        "Series 3",         3866,     Segment.STANDARD), // standard! 100k
    SERIES5(        "Series 5",         3272,     Segment.PREMIUM), // Premium 135k
    SERIES1(        "Series 1",         1377,     Segment.STANDARD), // Standard 70k
    X3(             "X3",               1224,     Segment.PREMIUM), // premium! 100k
    X5(             "X5",               926,      Segment.PREMIUM), // Premium 170k
    SERIES7(        "SERIES 7",         729,      Segment.PREMIUM), // Premium 150k
    X1(             "X1",               599,      Segment.STANDARD), // standard 70k
    SERIES4(        "SERIES 4",         455,      Segment.PREMIUM), // premium 125k
    SERIES2(        "SERIES 2",         332,      Segment.STANDARD), // standard 70k
    X6(             "X6",               267,      Segment.PREMIUM), // Premium 180k
    X4(             "X4",               214,      Segment.PREMIUM), // Premium 125k
    SERIES6(        "SERIES 6",         196,      Segment.PREMIUM), // Premium 150k
    THREEGT(        "3GT",              194,      Segment.STANDARD), // standard 75k
    I3(             "I3",               154,      Segment.STANDARD), // electric standard 70k
    X5M(            "X5M",              117,      Segment.PREMIUM), // Premium 160k
    X2(             "X2",               106,      Segment.PREMIUM), // premium 2018 160k
    X7(             "X7",               92,       Segment.PREMIUM), // Premium 2019+ 500k
    SERIES8(        "SERIES 8",         91,       Segment.PREMIUM), // Premium 2020+ 666k, 1990-1996 150k
    FIVEGT(         "5GT",              89,       Segment.PREMIUM), // premium 100k
    M3(             "M3",               86,       Segment.PREMIUM), // premium 2008 120k, 2015 160k, 2020+ 400k+
    M4(             "M4",               83,       Segment.PREMIUM), // premium 170k
    M5(             "M5",               82,       Segment.PREMIUM), // premium 150k similar to M3, value is similar for old models.

    //Audi models 14767
    A4(             "A4",               3884,     Segment.STANDARD), // standard 70k
    A6(             "A6",               2992,     Segment.PREMIUM), // premium 130k
    A3(             "A3",               2206,     Segment.STANDARD), // standard 70k
    Q5(             "Q5",               960,      Segment.STANDARD), // standard? 95k
    A5(             "A5",               885,      Segment.STANDARD), // standard 90k
    A8(             "A8",               518,      Segment.PREMIUM), // premium 180k
    Q7(             "Q7",               478,      Segment.PREMIUM), // premium 160k
    Q3(             "Q3",               451,      Segment.STANDARD), // standard 75k
    A7(             "A7",               255,      Segment.PREMIUM), // premium 130k
    A6ALLROAD(      "A6 Allroad",       184,      Segment.PREMIUM), // premium 115k
    TT(             "TT",               175,      Segment.STANDARD), // standard 45k
    A1(             "A1",               174,      Segment.STANDARD), // standard? 40k
    A4ALLROAD(      "A4 Allroad",       173,      Segment.STANDARD), // standard 65k
    S3(             "S3",               150,      Segment.STANDARD), // standard? 60-90k
    S5(             "S5",               85,       Segment.PREMIUM), // premium 120k, old age.
    S6(             "S6",               84,       Segment.PREMIUM), // premium 125k
    Q8(             "Q8",               81,       Segment.PREMIUM), // 2018 premium 380k+
    S4(             "S4",               75,       Segment.STANDARD), // standard 70k

    //Opel models 14721
    ASTRA(          "Astra",            4754,     Segment.STANDARD), // standard? 50k
    INSIGNIA(       "Insignia",         2324,     Segment.STANDARD), // standard? 60k
    CORSA(          "Corsa",            2109,     Segment.BUDGET), // budget 37k
    ZAFIRA(         "Zafira",           1169,     Segment.STANDARD), // standard? 50k
    MERIVA(         "Meriva",           1131,     Segment.BUDGET), // budget 38k
    MOKKA(          "Mokka",            982,      Segment.STANDARD), // standard? 60k
    VECTRA(         "Vectra",           582,      Segment.BUDGET), // budget 20k
    VIVARO(         "Vivaro",           266,      Segment.STANDARD), // cargo standard! 65k
    CROSSLANDX(     "Crossland X",      250,      Segment.STANDARD), // 2017 60k standard
    GRANDLANDX(     "Grandland X",      193,      Segment.STANDARD), // 2017 80k standard!
    COMBO(          "Combo",            189,      Segment.BUDGET), // budget, small cargo, 30k
    ANTARA(         "Antara",           183,      Segment.BUDGET), // budget 45k
    SIGNUM(         "Signum",           126,      Segment.STANDARD), // 2008 budget 15k
    ADAM(           "Adam",             97,       Segment.BUDGET), // budget 35k
    AGILA(          "Agila",            95,       Segment.BUDGET), // budget 17k


    //Volkswagen models 14236
    GOLF(           "Golf",             3380,     Segment.STANDARD), // Standard 90k
    PASSAT(         "Passat",           2826,     Segment.STANDARD), // Standard 85k
    POLO(           "Polo",             1328,     Segment.BUDGET), // budget 37k
    TIGUAN(         "Tiguan",           1071,     Segment.STANDARD), // Standard 70k
    TOURAN(         "Touran",           835,      Segment.BUDGET), // budget 50k
    CADDY(          "Caddy",            459,      Segment.BUDGET), // budget low cargo 45-55k
    GOLFPLUS(       "Golf Plus",        449,      Segment.BUDGET), // budget 33k
    SHARAN(         "Sharan",           338,      Segment.STANDARD), // Standard 70k
    ARTEON(         "Arteon",           301,      Segment.PREMIUM), // premium 2017 150k
    UP(             "up!",              280,      Segment.BUDGET), // budget 30-35k electric
    TRANSPORTER(    "Transporter",      279,      Segment.BUDGET), // budget 55k
    JETTA(          "Jetta",            266,      Segment.BUDGET), // budget 45k
    TOUAREG(        "Touareg",          248,      Segment.STANDARD), // standard 80-100k
    MULTIVAN(       "Multivan",         237,      Segment.PREMIUM), // Premium. van, so cargo? 140k
    TCROSS(         "T-Cross",          223,      Segment.BUDGET), // budget 2019 100k
    SCIROCCO(       "Scirocco",         170,      Segment.BUDGET), // budget 50k
    CARAVELLE(      "Caravelle",        148,      Segment.STANDARD), // Standard. van, so cargo? 85-110k
    CC(             "CC",               145,      Segment.STANDARD), // Standard 70k
    NEWBEETLE(      "New Beetle",       129,      Segment.BUDGET), // budget 20k
    FOX(            "Fox",              119,      Segment.BUDGET), // budget 10k
    GOLFSPORTSVAN(  "Golf Sportsvan",   112,      Segment.BUDGET), // budget 50k
    TIGUANALLSPACE( "Tiguan Allspace",  102,      Segment.STANDARD), // standard 2017-18 125k

    //Ford models 12785
    FOCUS(          "Focus",            2712,     Segment.STANDARD), // Standard 60k
    MONDEO(         "Mondeo",           2340,     Segment.STANDARD), // standard 70k
    FIESTA(         "Fiesta",           1481,     Segment.BUDGET), // budget 37k
    KUGA(           "Kuga",             1137,     Segment.STANDARD), // Standard 70k
    SMAX(           "S-MAX",            941,      Segment.STANDARD), // Standard 60k
    CMAX(           "C-MAX",            654,      Segment.BUDGET), // budget 45k
    MUSTANG(        "Mustang",          437,      Segment.PREMIUM), // premium/antique?/classic? 2015+ 150k, 1965-1970 300-500k
    GALAXY(         "Galaxy",           337,      Segment.BUDGET), // budget 45k
    FUSION(         "Fusion",           262,      Segment.BUDGET), // budget 40k
    ECOSPORT(       "EcoSport",         227,      Segment.BUDGET), // budget 40k
    GRANDECMAX(     "Grands C-MAX",     213,      Segment.BUDGET), // budget 40k
    FOCUSCMAX(      "Focus C-MAX",      189,      Segment.BUDGET), // budget 22k
    KA(             "KA",               188,      Segment.BUDGET), // budget 20k
    EDGE(           "EDGE",             188,      Segment.STANDARD), // 2015 80k, 2018+ 150k standard!
    ESCAPE(         "Escape",           142,      Segment.STANDARD), // standard? i think. 55k
    TRANSIT(        "Transit",          128,      Segment.BUDGET), // cargo, 40-50k
    RANGER(         "Ranger",           126,      Segment.STANDARD), // Standard 70k
    TRANSITCUSTOM(  "Transit Custom",   123,      Segment.STANDARD), // Standard cargo, 50k
    BMAX(           "B-MAX",            120,      Segment.BUDGET), // budget 33k

    //Alfa Romeo models 1370
    STELVIO(        "Stelvio",          353,      Segment.PREMIUM), // premium 275k+ 2017 140k
    ONEFIVENINE(    "159",              248,      Segment.BUDGET), // budget 25k
    GIULIA(         "Giulia",           244,      Segment.PREMIUM), // premium 250k+ 2016 100k
    GIULIETTA(      "Giulietta",        232,      Segment.BUDGET), // budget 45k
    MITO(           "Mito",             127,      Segment.BUDGET), // budget 25k
    ONEFOURSEVEN(   "147",              79,       Segment.BUDGET); // budget 10k

    
    private final String name;
    private final Integer commonness;
    private final Segment segment;

    // Creating new list of Model with all the values from enum Model.
    private static final List<Model> MODEL_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = MODEL_LIST.size();

    Model(String name, Integer commonness, Segment segment) {
        this.name = name;
        this.commonness = commonness;
        this.segment = segment;
    }

    public String getName(){
        return this.name;
    }

    public Integer getCommonness() {
        return commonness;
    }

    public Segment getSegment() {
        return segment;
    }

    public static List<Model> getModelList(){
        return MODEL_LIST;
    }
}