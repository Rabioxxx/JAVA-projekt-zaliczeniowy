package com.szymonjasinski;

public enum Models {
    //BMW models 15009
    SERIES3("Series3", 3866),
    SERIES5("Series5", 3272),
    SERIES1("Series1", 1377),
    X3("X3", 1224),
    X5("X5", 926),
    SERIES7("SERIES7", 729),
    X1("X1", 599),
    SERIES4("SERIES4", 455),
    SERIES2("SERIES2", 332),
    X6("X6", 267),
    X4("X4", 214),
    SERIES6("SERIES6", 196),
    I3("I3", 154),
    X2("X2", 106),

    //Audi models 14767
    A4("A4", 3884),
    A6("A6", 2992),
    A3("A3", 2206),
    Q5("Q5", 960),
    A5("A5", 885),
    A8("A8", 518),
    Q7("Q7", 478),
    Q3("Q3", 451),
    TT("TT", 175),
    S3("S3", 150),

    //Opel models 14721
    ASTRA("Astra", 4754),
    INSIGNIA("Insignia", 2324),
    CORSA("Corsa", 2109),
    ZAFIRA("Zafira", 1169),
    MERIVA("Meriva", 1131),
    MOKKA("Mokka", 982),
    VECTRA("Vectra", 582),
    VIVARO("Vivaro", 266),
    CROSSLANDX("Crossland X", 250),
    GRANDLANDX("Grandland X", 193),
    COMBO("Combo", 189),
    ANTARA("Antara", 183),
    SIGNUM("Signum", 126),
    AGILA("Agila", 10),

    //Volkswagen models 14236
    GOLF("Golf", 3380),
    PASSAT("Passat", 2826),
    POLO("Polo", 1328),
    TIGUAN("Tiguan", 1071),
    TOURAN("Touran", 835),
    CADDY("Caddy", 459),
    GOLFPLUS("Golf Plus", 449),
    SHARAN("Sharan", 338),
    ARTEON("Arteon", 301),
    UP("up!", 280),
    TRANSPORTER("Transporter", 279),
    JETTA("Jetta", 266),
    TOUAREG("Touareg", 248),
    MULTIVAN("Multivan", 237),
    TCROSS("T-Cross", 223),
    SCIROCCO("Scirocco", 170),
    CARAVELLE("Caravelle", 148),
    CC("CC", 145),
    NEWBEETLE("New Beetle", 129),
    FOX("Fox", 119),
    GOLFSPORTSVAN("Golf Sportsvan", 112),
    TIGUANALLSPACE("Tiguan Allspace", 102),

    //Ford models 12785
    FOCUS("Focus", 2712),
    MONDEO("Mondeo", 2340),
    FIESTA("Fiesta", 1481),
    KUGA("Kuga", 1137),
    SMAX("S-MAX", 941),
    CMAX("C-MAX", 654),
    MUSTANG("Mustang", 437),
    GALAXY("Galaxy", 337),
    FUSION("Fusion", 262),
    ECOSPORT("EcoSport", 227),
    GRANDECMAX("Grands C-MAX", 213),
    FOCUSCMAX("Focus C-MAX", 189),
    KA("KA", 188),
    EDGE("EDGE", 188),
    ESCAPE("Escape", 142),
    TRANSIT("Transit", 128),
    RANGER("Ranger", 126),
    TRANSITCUSTOM("Transit Custom", 123),
    BMAX("B-MAX", 120);


    private final String name;
    private final Integer commonness;

    Models(String name, Integer commonness) {
        this.name = name;
        this.commonness = commonness;
    }

    public String getName(){
        return name;
    }
}