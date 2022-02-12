package com.szymonjasinski;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private Double goal;
    private Double cash = 0.0;
    private ArrayList<Car> cars;
    private ArrayList<String> transactions = new ArrayList<>(); // Maybe type will be changed.

    public Double getCash() {
        return cash;
    }

    // TODO #021
    public void setCash(Double cash) {
        if (this.transactions == null) {
            transactions = new ArrayList<>();
        }

        cash = Helper.roundMoney(cash);

        String cashDifferenceString = "";
        double cashDifference = Helper.roundMoney(cash - this.cash);

        if (cashDifference > 0) // if new cash we want to set is bigger than cash we had now then it means that transactions is adding cash to our account. So we want to see '+' sign.
            cashDifferenceString = "+" + Helper.moneyPretty(cashDifference);
        else
            cashDifferenceString = "-" + Helper.moneyPretty(cashDifference);

        transactions.add("Transaction ##### ---> " + cashDifferenceString);

        this.cash = cash;

        if (checkGoal()) {
            System.out.println("""
                                        
                                        
                    !!!!CONGRATS!!!!
                    You have won my game by doubling initial money you get on start of the game!
                    Great job, m8!
                                        
                                        
                    """);
        }
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (this.cars == null)
            cars = new ArrayList<>();
        cars.add(car);
    }

    public void printGarage(Calendar calendar, Market market) {

        char input2 = 97;

        ArrayList<Car> cars = this.getCars();

        if (cars == null || cars.size() == 0) {
            System.out.println("You have no cars in your parking lot.");

        } else {
            System.out.println("You have following cars in your parking lot:");
            // It is a lambda expression.
            // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
            cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

            // TODO #014 - Restricting loops.
            // TODO #020
            int i; // it is here to make this first letter that shows what will happen when you click it.
            int carsArraySize = cars.size();
            int carsToPrint = 10; // how many rows containing cars names we want to print on one site.
            int offset = 0;
            int max = Math.min(carsToPrint, carsArraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.
            int totalSites = (int) Math.ceil(carsArraySize / (double) carsToPrint); // total number of sites.
            int currentSite = 1;
            int lastPageCorrection = 0;

            do {
                i = 97; // 97 represents lowercase a.
                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                    Car car = cars.get(j);
                    System.out.printf("%c - %s %s %s %s, which you spent on %s\n", (char) i, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getValue()), car.getShape(), Helper.moneyPretty(car.getSumCashSpent()));
                    i++;

                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is less objects to print than carsToPrint.
                        System.out.println("Site " + currentSite + "/" + totalSites);

                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
                        if (currentSite == 1 && currentSite == totalSites) {
                            System.out.println("Choose a car or get back (x).");
                        } else if (currentSite == 1)
                            System.out.println("Choose a car, go to next site (>) or get back (x).");
                        else if (currentSite == totalSites)
                            System.out.println("Choose a car, go to previous site (<) or get back (x).");
                        else
                            System.out.println("Choose a car, go to next site (>), previous site (<) or get back (x).");

                        input2 = Helper.scanner.next().charAt(0);

                        if (input2 == 60 && currentSite != 1) { // 60 is '<'
                            lastPageCorrection = 0;
                            offset -= carsToPrint;
                            currentSite -= 1;
                            break;
                        } else if (input2 == 62 && currentSite != totalSites) { // 62 is '>'
                            lastPageCorrection = 0;
                            offset += carsToPrint;
                            // This if is for correction on last page that can contain less than carsArraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                            if (offset + carsToPrint > carsArraySize) {
                                lastPageCorrection = offset + carsToPrint - carsArraySize;
                            }
                            currentSite += 1;
                            break;
                        } else if (input2 >= 97 && input2 < 97 + max - lastPageCorrection) {

                            car = cars.get(input2 - 97 + offset);
                            System.out.println(car.getCarStringValue());

                            // These variables change usable keys.
                            char repairKey = 'r';
                            char washKey = 'w';
                            char carHistoryKey = 'h';

                            char input;

                            do {
                                System.out.printf("\nPress x to get back, %c to repair part, %c to view transactions regarding this car or %c to wash car.\n", repairKey, carHistoryKey, washKey);

                                input = Helper.scanner.next().charAt(0);

                                if (input == repairKey) {

                                    if (car.getEngine() && car.getTransmission() && car.getBody() && car.getSuspension() && car.getBrakes()) {
                                        System.out.println("This car does not need any repairs.");
                                    } else {

                                        char inputPartRepair;

                                        do {
                                            System.out.println("What would you like to repair?");
                                            System.out.println("a - engine " + Helper.moneyPretty(car.getEngineRepairPrice()));
                                            System.out.println("b - transmission " + Helper.moneyPretty(car.getTransmissionRepairPrice()));
                                            System.out.println("c - body " + Helper.moneyPretty(car.getBodyRepairPrice()));
                                            System.out.println("d - suspension " + Helper.moneyPretty(car.getSuspensionRepairPrice()));
                                            System.out.println("e - brakes " + Helper.moneyPretty(car.getBrakesRepairPrice()));
                                            System.out.println();
                                            System.out.println("x - get back");

                                            inputPartRepair = Helper.scanner.next().charAt(0);

                                            if (inputPartRepair == 'x') {
                                                System.out.println("Goin' back then.");
                                            } else if (inputPartRepair == 97) {
                                                car.setEngine(car.repairPart(this, calendar, market, car.getEngine(), car.getEngineRepairPrice()));
                                                ArrayList<String> newTransaction = new ArrayList<>(car.getTransactions());
                                                newTransaction.add("Enginge was repaired for " + Helper.moneyPretty(car.getEngineRepairPrice()));
                                                car.setTransactions(newTransaction);
                                                car.setSumCashSpent(car.getSumCashSpent() + car.getEngineRepairPrice());
                                            } else if (inputPartRepair == 98) {
                                                car.setTransmission(car.repairPart(this, calendar, market, car.getTransmission(), car.getTransmissionRepairPrice()));
                                                ArrayList<String> newTransaction = new ArrayList<>(car.getTransactions());
                                                newTransaction.add("Transmission was repaired for " + Helper.moneyPretty(car.getTransmissionRepairPrice()));
                                                car.setTransactions(newTransaction);
                                                car.setSumCashSpent(car.getSumCashSpent() + car.getTransmissionRepairPrice());
                                            } else if (inputPartRepair == 99) {
                                                car.setBody(car.repairPart(this, calendar, market, car.getBody(), car.getBodyRepairPrice()));
                                                ArrayList<String> newTransaction = new ArrayList<>(car.getTransactions());
                                                newTransaction.add("Body was repaired for " + Helper.moneyPretty(car.getBodyRepairPrice()));
                                                car.setTransactions(newTransaction);
                                                car.setSumCashSpent(car.getSumCashSpent() + car.getBodyRepairPrice());
                                            } else if (inputPartRepair == 100) {
                                                car.setSuspension(car.repairPart(this, calendar, market, car.getSuspension(), car.getSuspensionRepairPrice()));
                                                ArrayList<String> newTransaction = new ArrayList<>(car.getTransactions());
                                                newTransaction.add("Suspension was repaired for " + Helper.moneyPretty(car.getSuspensionRepairPrice()));
                                                car.setTransactions(newTransaction);
                                                car.setSumCashSpent(car.getSumCashSpent() + car.getSuspensionRepairPrice());
                                            } else if (inputPartRepair == 101) {
                                                car.setBrakes(car.repairPart(this, calendar, market, car.getBrakes(), car.getBrakesRepairPrice()));
                                                ArrayList<String> newTransaction = new ArrayList<>(car.getTransactions());
                                                newTransaction.add("Brakes were repaired for " + Helper.moneyPretty(car.getBrakesRepairPrice()));
                                                car.setTransactions(newTransaction);
                                                car.setSumCashSpent(car.getSumCashSpent() + car.getBrakesRepairPrice());
                                            } else {
                                                System.out.println(">:(");
                                            }
                                        } while (inputPartRepair != 'x');
                                    }
                                } else if (input == washKey) {
                                    if (car.getWashed())
                                        System.out.println("It is already washed.");
                                    else if (this.getCash() < 5.0) {
                                        System.out.println("You don't have enough cash to wash your car! haha, a bankrupt! lol");
                                    } else {
                                        this.setCash(this.getCash() - 5.0);
                                        car.setWashed(true);
                                        System.out.println("Car washed. It cost you $5.00");
                                    }
                                } else if (input == carHistoryKey) {
                                    if (car.getTransactions() != null && car.getTransactions().size() != 1) {
                                        System.out.println("Last transactions:");
                                        for (String transaction : car.getTransactions()) {
                                            System.out.println(transaction);
                                        }
                                    } else
                                        System.out.println("Last transaction:");
                                } else {
                                    if (input != 'x') {
                                        System.out.println(">:(");
                                    }
                                }
                            } while (input != 'x' && input != repairKey && input != washKey && input != carHistoryKey);
                            break;
                        } else {
                            if (input2 != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                System.out.println(">:(");
                        }
                    }
                }
            } while (input2 == 62 || input2 == 60 || (input2 >= 97 && input2 <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
        }
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public Boolean checkGoal() {
        if (this.getGoal() == null) {
            return false;
        } else return this.getCash() >= this.getGoal();
    }
}
