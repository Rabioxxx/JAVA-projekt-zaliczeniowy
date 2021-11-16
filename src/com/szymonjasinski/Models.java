package com.szymonjasinski;

public enum Models {
    //BMW models 15009
    SERIES3("Series3", 3866, new Segments[]{Segments.STANDARD}),
    SERIES5("Series5", 3272, new Segments[]{Segments.STANDARD}),
    SERIES1("Series1", 1377, new Segments[]{Segments.STANDARD}),
    X3("X3", 1224, new Segments[]{Segments.STANDARD}),
    X5("X5", 926, new Segments[]{Segments.STANDARD}),
    SERIES7("SERIES7", 729, new Segments[]{Segments.STANDARD}),
    X1("X1", 599, new Segments[]{Segments.STANDARD}),
    SERIES4("SERIES4", 455, new Segments[]{Segments.STANDARD}),
    SERIES2("SERIES2", 332, new Segments[]{Segments.STANDARD}),
    X6("X6", 267, new Segments[]{Segments.STANDARD}),
    X4("X4", 214, new Segments[]{Segments.STANDARD}),
    SERIES6("SERIES6", 196, new Segments[]{Segments.STANDARD}),
    I3("I3", 154, new Segments[]{Segments.STANDARD}),
    X2("X2", 106, new Segments[]{Segments.STANDARD}),

    //Audi models 14767
    A4("A4", 3884, new Segments[]{Segments.STANDARD}),
    A6("A6", 2992, new Segments[]{Segments.STANDARD}),
    A3("A3", 2206, new Segments[]{Segments.STANDARD}),
    Q5("Q5", 960, new Segments[]{Segments.STANDARD}),
    A5("A5", 885, new Segments[]{Segments.STANDARD}),
    A8("A8", 518, new Segments[]{Segments.STANDARD}),
    Q7("Q7", 478, new Segments[]{Segments.STANDARD}),
    Q3("Q3", 451, new Segments[]{Segments.STANDARD}),
    TT("TT", 175, new Segments[]{Segments.STANDARD}),
    S3("S3", 150, new Segments[]{Segments.STANDARD}),

    //Opel models 14721
    ASTRA("Astra", 4754, new Segments[]{Segments.STANDARD}),
    INSIGNIA("Insignia", 2324, new Segments[]{Segments.STANDARD}),
    CORSA("Corsa", 2109, new Segments[]{Segments.STANDARD}),
    ZAFIRA("Zafira", 1169, new Segments[]{Segments.STANDARD}),
    MERIVA("Meriva", 1131, new Segments[]{Segments.STANDARD}),
    MOKKA("Mokka", 982, new Segments[]{Segments.STANDARD}),
    VECTRA("Vectra", 582, new Segments[]{Segments.STANDARD}),
    VIVARO("Vivaro", 266, new Segments[]{Segments.STANDARD}),
    CROSSLANDX("Crossland X", 250, new Segments[]{Segments.STANDARD}),
    GRANDLANDX("Grandland X", 193, new Segments[]{Segments.STANDARD}),
    COMBO("Combo", 189, new Segments[]{Segments.STANDARD}),
    ANTARA("Antara", 183, new Segments[]{Segments.STANDARD}),
    SIGNUM("Signum", 126, new Segments[]{Segments.STANDARD}),
    AGILA("Agila", 10, new Segments[]{Segments.STANDARD}),

    //Volkswagen models 14236
    GOLF(          "Golf",            3380, new Segments[]{Segments.STANDARD}),
    PASSAT(        "Passat",          2826, new Segments[]{Segments.STANDARD}),
    POLO(          "Polo",            1328, new Segments[]{Segments.STANDARD}),
    TIGUAN(        "Tiguan",          1071, new Segments[]{Segments.STANDARD}),
    TOURAN(        "Touran",          835,  new Segments[]{Segments.STANDARD}),
    CADDY(         "Caddy",           459,  new Segments[]{Segments.STANDARD}),
    GOLFPLUS(      "Golf Plus",       449,  new Segments[]{Segments.STANDARD}),
    SHARAN(        "Sharan",          338,  new Segments[]{Segments.STANDARD}),
    ARTEON(        "Arteon",          301,  new Segments[]{Segments.STANDARD}),
    UP(            "up!",             280,  new Segments[]{Segments.STANDARD}),
    TRANSPORTER(   "Transporter",     279,  new Segments[]{Segments.STANDARD}),
    JETTA(         "Jetta",           266,  new Segments[]{Segments.STANDARD}),
    TOUAREG(       "Touareg",         248,  new Segments[]{Segments.STANDARD}),
    MULTIVAN(      "Multivan",        237,  new Segments[]{Segments.STANDARD}),
    TCROSS(        "T-Cross",         223,  new Segments[]{Segments.STANDARD}),
    SCIROCCO(      "Scirocco",        170,  new Segments[]{Segments.STANDARD}),
    CARAVELLE(     "Caravelle",       148,  new Segments[]{Segments.STANDARD}),
    CC(            "CC",              145,  new Segments[]{Segments.STANDARD}),
    NEWBEETLE(     "New Beetle",      129,  new Segments[]{Segments.STANDARD}),
    FOX(           "Fox",             119,  new Segments[]{Segments.STANDARD}),
    GOLFSPORTSVAN( "Golf Sportsvan",  112,  new Segments[]{Segments.STANDARD}),
    TIGUANALLSPACE("Tiguan Allspace", 102,  new Segments[]{Segments.STANDARD}),

    //Ford models 12785
    FOCUS("Focus", 2712, new Segments[]{Segments.STANDARD}),
    MONDEO("Mondeo", 2340, new Segments[]{Segments.STANDARD}),
    FIESTA("Fiesta", 1481, new Segments[]{Segments.STANDARD}),
    KUGA("Kuga", 1137, new Segments[]{Segments.STANDARD}),
    SMAX("S-MAX", 941, new Segments[]{Segments.STANDARD}),
    CMAX("C-MAX", 654, new Segments[]{Segments.STANDARD}),
    MUSTANG("Mustang", 437, new Segments[]{Segments.STANDARD}),
    GALAXY("Galaxy", 337, new Segments[]{Segments.STANDARD}),
    FUSION("Fusion", 262, new Segments[]{Segments.STANDARD}),
    ECOSPORT("EcoSport", 227, new Segments[]{Segments.STANDARD}),
    GRANDECMAX("Grands C-MAX", 213, new Segments[]{Segments.STANDARD}),
    FOCUSCMAX("Focus C-MAX", 189, new Segments[]{Segments.STANDARD}),
    KA("KA", 188, new Segments[]{Segments.STANDARD}),
    EDGE("EDGE", 188, new Segments[]{Segments.STANDARD}),
    ESCAPE("Escape", 142, new Segments[]{Segments.STANDARD}),
    TRANSIT("Transit", 128, new Segments[]{Segments.STANDARD}),
    RANGER("Ranger", 126, new Segments[]{Segments.STANDARD}),
    TRANSITCUSTOM("Transit Custom", 123, new Segments[]{Segments.STANDARD}),
    BMAX("B-MAX", 120, new Segments[]{Segments.STANDARD});


    private final String name;
    private final Integer commonness;
    private final Segments[] segments;

    Models(String name, Integer commonness, Segments[] segments) {
        this.name = name;
        this.commonness = commonness;
        this.segments = segments;
    }

    public String getName(){
        return name;
    }
}