package com.szymonjasinski;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Model {
    //BMW models 15009
    SERIES3(        "Series 3",         3866,   100,     Segment.STANDARD), // standard! 100k
    SERIES5(        "Series 5",         3272,   120,     Segment.PREMIUM), // Premium 135k
    SERIES1(        "Series 1",         1377,   70,      Segment.STANDARD), // Standard 70k
    X3(             "X3",               1224,   100,     Segment.PREMIUM), // premium! 100k
    X5(             "X5",               926,    170,     Segment.PREMIUM), // Premium 170k
    SERIES7(        "SERIES 7",         729,    150,     Segment.PREMIUM), // Premium 150k
    X1(             "X1",               599,    70,      Segment.STANDARD), // standard 70k
    SERIES4(        "SERIES 4",         455,    125,     Segment.PREMIUM), // premium 125k
    SERIES2(        "SERIES 2",         332,    70,      Segment.STANDARD), // standard 70k
    X6(             "X6",               267,    180,     Segment.PREMIUM), // Premium 180k
    X4(             "X4",               214,    125,     Segment.PREMIUM), // Premium 125k
    SERIES6(        "SERIES 6",         196,    150,     Segment.PREMIUM), // Premium 150k
    THREEGT(        "3GT",              194,    75,      Segment.STANDARD), // standard 75k
    I3(             "I3",               154,    70,      Segment.STANDARD), // electric standard 70k
    X5M(            "X5M",              117,    160,     Segment.PREMIUM), // Premium 160k
    X2(             "X2",               106,    160,     Segment.PREMIUM), // premium 2018 160k
    X7(             "X7",               92,     500,     Segment.PREMIUM), // Premium 2019+ 500k
    SERIES8(        "SERIES 8",         91,     666,     Segment.PREMIUM), // Premium 2020+ 666k, 1990-1996 150k
    FIVEGT(         "5GT",              89,     100,     Segment.PREMIUM), // premium 100k
    M3(             "M3",               86,     160,     Segment.PREMIUM), // premium 2008 120k, 2015 160k, 2020+ 400k+
    M4(             "M4",               83,     170,     Segment.PREMIUM), // premium 170k
    M5(             "M5",               82,     150,     Segment.PREMIUM), // premium 150k similar to M3, value is similar for old models.

    //Audi models 14767
    A4(             "A4",               3884,   70,      Segment.STANDARD), // standard 70k
    A6(             "A6",               2992,   130,     Segment.PREMIUM), // premium 130k
    A3(             "A3",               2206,   70,      Segment.STANDARD), // standard 70k
    Q5(             "Q5",               960,    95,      Segment.STANDARD), // standard? 95k
    A5(             "A5",               885,    90,      Segment.STANDARD), // standard 90k
    A8(             "A8",               518,    180,     Segment.PREMIUM), // premium 180k
    Q7(             "Q7",               478,    160,     Segment.PREMIUM), // premium 160k
    Q3(             "Q3",               451,    75,      Segment.STANDARD), // standard 75k
    A7(             "A7",               255,    130,     Segment.PREMIUM), // premium 130k
    A6ALLROAD(      "A6 Allroad",       184,    115,     Segment.PREMIUM), // premium 115k
    TT(             "TT",               175,    45,      Segment.STANDARD), // standard 45k
    A1(             "A1",               174,    40,      Segment.STANDARD), // standard? 40k
    A4ALLROAD(      "A4 Allroad",       173,    65,      Segment.STANDARD), // standard 65k
    S3(             "S3",               150,    75,      Segment.STANDARD), // standard? 60-90k
    S5(             "S5",               85,     120,     Segment.PREMIUM), // premium 120k, old age.
    S6(             "S6",               84,     125,     Segment.PREMIUM), // premium 125k
    Q8(             "Q8",               81,     380,     Segment.PREMIUM), // 2018 premium 380k+
    S4(             "S4",               75,     70,      Segment.STANDARD), // standard 70k

    //Opel models 14721
    ASTRA(          "Astra",            4754,   50,      Segment.STANDARD), // standard? 50k
    INSIGNIA(       "Insignia",         2324,   60,      Segment.STANDARD), // standard? 60k
    CORSA(          "Corsa",            2109,   37,      Segment.BUDGET), // budget 37k
    ZAFIRA(         "Zafira",           1169,   50,      Segment.STANDARD), // standard? 50k
    MERIVA(         "Meriva",           1131,   38,      Segment.BUDGET), // budget 38k
    MOKKA(          "Mokka",            982,    60,      Segment.STANDARD), // standard? 60k
    VECTRA(         "Vectra",           582,    20,      Segment.BUDGET), // budget 20k
    VIVARO(         "Vivaro",           501,    45,      Segment.STANDARD), // cargo standard! 65k
    CROSSLANDX(     "Crossland X",      250,    60,      Segment.STANDARD), // 2017 60k standard
    COMBO(          "Combo",            244,    30,      Segment.BUDGET), // small cargo
    GRANDLANDX(     "Grandland X",      193,    80,      Segment.STANDARD), // 2017 80k standard!
    ANTARA(         "Antara",           183,    45,      Segment.BUDGET), // budget 45k
    SIGNUM(         "Signum",           126,    15,      Segment.STANDARD), // 2008 budget 15k
    ADAM(           "Adam",             97,     35,      Segment.BUDGET), // budget 35k
    AGILA(          "Agila",            95,     17,      Segment.BUDGET), // budget 17k
    MOVANO(         "Movano",           88,     45,      Segment.STANDARD), // cargo


    //Volkswagen models 14236
    GOLF(           "Golf",             3380,   90,      Segment.STANDARD), // Standard 90k
    PASSAT(         "Passat",           2826,   85,      Segment.STANDARD), // Standard 85k
    POLO(           "Polo",             1328,   37,      Segment.BUDGET), // budget 37k
    TIGUAN(         "Tiguan",           1071,   70,      Segment.STANDARD), // Standard 70k
    TOURAN(         "Touran",           835,    50,      Segment.BUDGET), // budget 50k
    CADDY(          "Caddy",            459,    50,      Segment.BUDGET), // cargo
    GOLFPLUS(       "Golf Plus",        449,    33,      Segment.BUDGET), // budget 33k
    SHARAN(         "Sharan",           338,    70,      Segment.STANDARD), // Standard 70k
    ARTEON(         "Arteon",           301,    150,     Segment.PREMIUM), // premium 2017 150k
    UP(             "up!",              280,    30,      Segment.BUDGET), // budget 30-35k electric
    TRANSPORTER(    "Transporter",      279,    55,      Segment.BUDGET), // cargo
    JETTA(          "Jetta",            266,    55,      Segment.STANDARD), // budget 45k
    TOUAREG(        "Touareg",          248,    90,      Segment.STANDARD), // standard 80-100k
    MULTIVAN(       "Multivan",         237,    140,     Segment.PREMIUM), // Premium. van, so cargo? 140k
    TCROSS(         "T-Cross",          223,    50,      Segment.BUDGET), // budget 2019 100k, so I will give it 50 for 2015.
    SCIROCCO(       "Scirocco",         170,    50,      Segment.BUDGET), // budget 50k
    CARAVELLE(      "Caravelle",        148,    95,      Segment.STANDARD), // Standard. van, so cargo? 85-110k
    CC(             "CC",               145,    70,      Segment.STANDARD), // Standard 70k
    NEWBEETLE(      "New Beetle",       129,    20,      Segment.BUDGET), // budget 20k
    FOX(            "Fox",              119,    10,      Segment.BUDGET), // budget 10k
    CRAFTER(        "Crafter",          115,    47,      Segment.BUDGET), // cargo
    GOLFSPORTSVAN(  "Golf Sportsvan",   112,    50,      Segment.BUDGET), // budget 50k
    TIGUANALLSPACE( "Tiguan Allspace",  102,    125,     Segment.STANDARD), // standard 2017-18 125k
    LT(             "LT-35",            31,     120,     Segment.STANDARD), // cargo. maybe value need some tweaking, but it is 2006 MAX vehicle and it is worth ~20k, so if my math is correct it should be this 120k i set.

    //Ford models 12785
    FOCUS(          "Focus",            2712,   60,      Segment.STANDARD), // Standard 60k
    MONDEO(         "Mondeo",           2340,   65,      Segment.STANDARD), // standard 70k
    FIESTA(         "Fiesta",           1481,   60,      Segment.STANDARD), // budget 37k
    KUGA(           "Kuga",             1137,   70,      Segment.STANDARD), // Standard 70k
    SMAX(           "S-MAX",            941,    60,      Segment.STANDARD), // Standard 60k
    CMAX(           "C-MAX",            654,    45,      Segment.BUDGET), // budget 45k
    MUSTANG(        "Mustang",          437,    300,     Segment.PREMIUM), // premium/antique?/classic? 2015+ 150k, 1965-1970 300-500k
    GALAXY(         "Galaxy",           337,    45,      Segment.BUDGET), // budget 45k
    FUSION(         "Fusion",           262,    40,      Segment.BUDGET), // budget 40k
    ECOSPORT(       "EcoSport",         227,    40,      Segment.BUDGET), // budget 40k
    GRANDECMAX(     "Grands C-MAX",     213,    40,      Segment.BUDGET), // budget 40k
    FOCUSCMAX(      "Focus C-MAX",      189,    22,      Segment.BUDGET), // budget 22k
    KA(             "KA",               188,    20,      Segment.BUDGET), // budget 20k
    EDGE(           "EDGE",             188,    80,      Segment.STANDARD), // 2015 80k, 2018+ 150k standard!
    TRANSIT(        "Transit",          172,    58,      Segment.STANDARD), // cargo
    ESCAPE(         "Escape",           142,    55,      Segment.STANDARD), // standard? i think. 55k
    RANGER(         "Ranger",           126,    70,      Segment.STANDARD), // Standard 70k
    TRANSITCUSTOM(  "Transit Custom",   123,    50,      Segment.STANDARD), // Standard cargo, 50k
    BMAX(           "B-MAX",            120,    33,      Segment.BUDGET), // budget 33k
    CUSTOM(         "Custom",           51,     45,      Segment.BUDGET), // cargo
    CONNECT(        "Connect",          50,     30,      Segment.BUDGET), // cargo

    //Alfa Romeo models 1370
    STELVIO(        "Stelvio",          353,    140,     Segment.PREMIUM), // premium 275k+ 2017 140k
    ONEFIVENINE(    "159",              248,    25,      Segment.BUDGET), // budget 25k
    GIULIA(         "Giulia",           244,    100,     Segment.PREMIUM), // premium 250k+ 2016 100k
    GIULIETTA(      "Giulietta",        232,    45,      Segment.BUDGET), // budget 45k
    MITO(           "Mito",             127,    25,      Segment.BUDGET), // budget 25k
    ONEFOURSEVEN(   "147",              79,     10,      Segment.BUDGET), // budget 10k

    //Renault models
    MASTER(         "Master",           382,     60,     Segment.STANDARD), // cargo
    TRAFIC(         "Trafic",           289,     50,     Segment.BUDGET),   // cargo
    KANGOO(         "Kangoo",           79,      27,     Segment.BUDGET),   // cargo

    //Fiat models
    DUCATO(        "Ducato",           286,     60,     Segment.STANDARD),  // cargo
    DOBLO(         "Doblo",            77,      27,     Segment.BUDGET),    // cargo
    SCUDO(         "Scudo",            48,      28,     Segment.BUDGET),    // cargo
    FIORINO(       "Fiorino",          36,      14,     Segment.BUDGET),    // cargo

    //Iveco models
    DAILY(         "Daily",            145,     63,     Segment.STANDARD),    // cargo

    //Mercedes-Benz models
    SPRINTER(       "Sprinter",         191,    70,     Segment.STANDARD),    // cargo
    VITO(           "Vito",             104,    50,     Segment.STANDARD),    // cargo
    CITAN(          "Citan",            15,     25,     Segment.BUDGET),      // cargo

    //Peugeot models
    BOXER(          "Boxer",            211,    50,     Segment.STANDARD),    // cargo
    PARTNER(        "Partner",          88,     27,     Segment.BUDGET),    // cargo
    EXPERT(         "Expert",           59,     24,     Segment.BUDGET),    // cargo

    //Citroen models
    JUMPER(         "Jumper",           203,    48,     Segment.BUDGET),    // cargo
    BERLINGO(       "Berlingo",         88,     25,     Segment.BUDGET),    // cargo
    JUMPY(          "Jumpy",            65,     25,     Segment.BUDGET),    // cargo

    //Toyota models
    PROACE(         "Proace",           110,     35,     Segment.BUDGET),    // cargo
    HIACE(          "Hiace",            4,       40,     Segment.BUDGET),    // cargo

    //Dacia models
    DOKKER(         "Dokker",           21,      42,     Segment.BUDGET);    // cargo



    private final String name;
    private final Integer commonness;
    private final Integer value; // IN THOUSANDS!
    private final Segment segment;

    // Creating new list of Model with all the values from enum Model.
    private static final List<Model> MODEL_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = MODEL_LIST.size();

    Model(String name, Integer commonness, Integer value, Segment segment) {
        this.name = name;
        this.commonness = commonness;
        this.value = value;
        this.segment = segment;
    }

    public String getName(){
        return this.name;
    }

    public Integer getCommonness() {
        return commonness;
    }

    public Integer getValue() {
        return value;
    }

    public Segment getSegment() {
        return segment;
    }

    public static List<Model> getModelList(){
        return MODEL_LIST;
    }
}