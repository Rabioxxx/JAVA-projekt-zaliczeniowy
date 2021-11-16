package com.szymonjasinski;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Model {
    //BMW models 15009
    SERIES3("Series 3",      3866,       new Segment[]{Segment.STANDARD}),
    SERIES5("Series 5",      3272,       new Segment[]{Segment.STANDARD}),
    SERIES1("Series 1",      1377,       new Segment[]{Segment.STANDARD}),
    X3(     "X3",           1224,       new Segment[]{Segment.STANDARD}),
    X5(     "X5",           926,        new Segment[]{Segment.STANDARD}),
    SERIES7("SERIES 7",      729,        new Segment[]{Segment.STANDARD}),
    X1(     "X1",           599,        new Segment[]{Segment.STANDARD}),
    SERIES4("SERIES 4",      455,        new Segment[]{Segment.STANDARD}),
    SERIES2("SERIES 2",      332,        new Segment[]{Segment.STANDARD}),
    X6(     "X6",           267,        new Segment[]{Segment.STANDARD}),
    X4(     "X4",           214,        new Segment[]{Segment.STANDARD}),
    SERIES6("SERIES 6",      196,        new Segment[]{Segment.STANDARD}),
    I3(     "I3",           154,        new Segment[]{Segment.STANDARD}),
    X2(     "X2",           106,        new Segment[]{Segment.STANDARD}),

    //Audi models 14767
    A4("A4",     3884,      new Segment[]{Segment.STANDARD}),
    A6("A6",     2992,      new Segment[]{Segment.STANDARD}),
    A3("A3",     2206,      new Segment[]{Segment.STANDARD}),
    Q5("Q5",     960,       new Segment[]{Segment.STANDARD}),
    A5("A5",     885,       new Segment[]{Segment.STANDARD}),
    A8("A8",     518,       new Segment[]{Segment.STANDARD}),
    Q7("Q7",     478,       new Segment[]{Segment.STANDARD}),
    Q3("Q3",     451,       new Segment[]{Segment.STANDARD}),
    TT("TT",     175,       new Segment[]{Segment.STANDARD}),
    S3("S3",     150,       new Segment[]{Segment.STANDARD}),

    //Opel models 14721
    ASTRA("Astra",              4754,    new Segment[]{Segment.STANDARD}),
    INSIGNIA("Insignia",        2324,    new Segment[]{Segment.STANDARD}),
    CORSA("Corsa",              2109,    new Segment[]{Segment.STANDARD}),
    ZAFIRA("Zafira",            1169,    new Segment[]{Segment.STANDARD}),
    MERIVA("Meriva",            1131,    new Segment[]{Segment.STANDARD}),
    MOKKA("Mokka",              982,     new Segment[]{Segment.STANDARD}),
    VECTRA("Vectra",            582,     new Segment[]{Segment.STANDARD}),
    VIVARO("Vivaro",            266,     new Segment[]{Segment.STANDARD}),
    CROSSLANDX("Crossland X",   250,     new Segment[]{Segment.STANDARD}),
    GRANDLANDX("Grandland X",   193,     new Segment[]{Segment.STANDARD}),
    COMBO("Combo",              189,     new Segment[]{Segment.STANDARD}),
    ANTARA("Antara",            183,     new Segment[]{Segment.STANDARD}),
    SIGNUM("Signum",            126,     new Segment[]{Segment.STANDARD}),
    AGILA("Agila",              10,      new Segment[]{Segment.STANDARD}),

    //Volkswagen models 14236
    GOLF(          "Golf",            3380,     new Segment[]{Segment.STANDARD}),
    PASSAT(        "Passat",          2826,     new Segment[]{Segment.STANDARD}),
    POLO(          "Polo",            1328,     new Segment[]{Segment.STANDARD}),
    TIGUAN(        "Tiguan",          1071,     new Segment[]{Segment.STANDARD}),
    TOURAN(        "Touran",          835,      new Segment[]{Segment.STANDARD}),
    CADDY(         "Caddy",           459,      new Segment[]{Segment.STANDARD}),
    GOLFPLUS(      "Golf Plus",       449,      new Segment[]{Segment.STANDARD}),
    SHARAN(        "Sharan",          338,      new Segment[]{Segment.STANDARD}),
    ARTEON(        "Arteon",          301,      new Segment[]{Segment.STANDARD}),
    UP(            "up!",             280,      new Segment[]{Segment.STANDARD}),
    TRANSPORTER(   "Transporter",     279,      new Segment[]{Segment.STANDARD}),
    JETTA(         "Jetta",           266,      new Segment[]{Segment.STANDARD}),
    TOUAREG(       "Touareg",         248,      new Segment[]{Segment.STANDARD}),
    MULTIVAN(      "Multivan",        237,      new Segment[]{Segment.STANDARD}),
    TCROSS(        "T-Cross",         223,      new Segment[]{Segment.STANDARD}),
    SCIROCCO(      "Scirocco",        170,      new Segment[]{Segment.STANDARD}),
    CARAVELLE(     "Caravelle",       148,      new Segment[]{Segment.STANDARD}),
    CC(            "CC",              145,      new Segment[]{Segment.STANDARD}),
    NEWBEETLE(     "New Beetle",      129,      new Segment[]{Segment.STANDARD}),
    FOX(           "Fox",             119,      new Segment[]{Segment.STANDARD}),
    GOLFSPORTSVAN( "Golf Sportsvan",  112,      new Segment[]{Segment.STANDARD}),
    TIGUANALLSPACE("Tiguan Allspace", 102,      new Segment[]{Segment.STANDARD}),

    //Ford models 12785
    FOCUS(          "Focus",          2712,     new Segment[]{Segment.STANDARD}),
    MONDEO(         "Mondeo",         2340,     new Segment[]{Segment.STANDARD}),
    FIESTA(         "Fiesta",         1481,     new Segment[]{Segment.STANDARD}),
    KUGA(           "Kuga",           1137,     new Segment[]{Segment.STANDARD}),
    SMAX(           "S-MAX",          941,      new Segment[]{Segment.STANDARD}),
    CMAX(           "C-MAX",          654,      new Segment[]{Segment.STANDARD}),
    MUSTANG(        "Mustang",        437,      new Segment[]{Segment.STANDARD}),
    GALAXY(         "Galaxy",         337,      new Segment[]{Segment.STANDARD}),
    FUSION(         "Fusion",         262,      new Segment[]{Segment.STANDARD}),
    ECOSPORT(       "EcoSport",       227,      new Segment[]{Segment.STANDARD}),
    GRANDECMAX(     "Grands C-MAX",   213,      new Segment[]{Segment.STANDARD}),
    FOCUSCMAX(      "Focus C-MAX",    189,      new Segment[]{Segment.STANDARD}),
    KA(             "KA",             188,      new Segment[]{Segment.STANDARD}),
    EDGE(           "EDGE",           188,      new Segment[]{Segment.STANDARD}),
    ESCAPE(         "Escape",         142,      new Segment[]{Segment.STANDARD}),
    TRANSIT(        "Transit",        128,      new Segment[]{Segment.STANDARD}),
    RANGER(         "Ranger",         126,      new Segment[]{Segment.STANDARD}),
    TRANSITCUSTOM(  "Transit Custom", 123,      new Segment[]{Segment.STANDARD}),
    BMAX(           "B-MAX",          120,      new Segment[]{Segment.STANDARD}),

    //Alfa Romeo models 1370
    STELVIO(        "Stelvio",  353, new Segment[]{Segment.STANDARD}),
    ONEFIVENINE(    "159",      248, new Segment[]{Segment.STANDARD}),
    GIULIA(         "Giulia",   244, new Segment[]{Segment.STANDARD}),
    GIULIETTA(      "Giulietta",232, new Segment[]{Segment.STANDARD}),
    MITO(           "Mito",     127, new Segment[]{Segment.STANDARD}),
    ONEFOURSEVEN(   "147",      79,  new Segment[]{Segment.STANDARD});

    
    private final String name;
    private final Integer commonness;
    private final Segment[] segment;

    // Creating new list of Model with all the values from enum Model.
    private static final List<Model> MODEL_LIST = Collections.unmodifiableList(Arrays.asList(values()));

    //Now we check size of the list above.
    private static final int SIZE = MODEL_LIST.size();

    Model(String name, Integer commonness, Segment[] segment) {
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

    public Segment[] getSegments() {
        return segment;
    }

    public String getRandomSegment(){
        int i = Helper.RNG.nextInt(segment.length);
        Segment segment = this.segment[i];
        return segment.getName();
    }

    public static List<Model> getModelList(){
        return MODEL_LIST;
    }
}