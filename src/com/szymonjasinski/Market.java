package com.szymonjasinski;

import java.util.*;
import java.lang.*;

public class Market {
    private ArrayList<Car> cars;
    private ArrayList<Client> clients;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void carsGenerator(Integer number) {

        ArrayList<Car> cars = new ArrayList<>();

        if (getCars() != null) {
            cars.addAll(getCars());
        }

        for (int i = 0; i < number; i++) {
            //Brand brandRandom = Brand.randomBrand(); // Takes one random enum constant and assigns it to brand variable. E.g. MERCEDES which has var name "Mercedes-Benz" and String[] of models.
            Brand brandRandom = Brand.randomBrand();
            Model brandModelRandom = brandRandom.randomModel(); // Now we take from brand variable (E.g. MERCEDES) a random model specific to a brand (E.g. CLASSC).
            Segment segment = brandModelRandom.getSegment();

            String brandName = brandRandom.getName(); // Now we get name of the brand. If it is e.g. MERCEDES it will give us "Mercedes-Benz".
            String modelName = brandModelRandom.getName(); // Taking model name as String. E.g. "Class C".

            Integer defaultValue = brandModelRandom.getValue();

            // TODO #007, #015
            // Randomizing age in between (exclusive) ageMin and ageMax values.
            // For now I am manually weighting it, can't find better solution for now.
            Map<Integer, Double> map = new HashMap<>();

            map.put(5, 2.0);
            map.put(6, 4.0);
            map.put(7, 8.0);
            map.put(8, 11.0);
            map.put(9, 12.0);
            map.put(10, 12.0);
            map.put(11, 12.0);
            map.put(12, 8.0);
            map.put(13, 3.0);
            map.put(14, 2.0);
            map.put(15, 2.0);
            map.put(16, 1.0);


            int ageMin = 5;
            int ageMax = 16; // not used actually but may be in the future

            /*
            for (int j = ageMin; j <= ageMax; j++) {
                if (j >= 9 && j <= 11)
                    map.put(j, 14.0);
                else if (j == 8 || j == 12)
                    map.put(j, 12.0);
                else if (j == 7 || j == 13)
                    map.put(j, 10.0);
                else if (j == 6 || j == 14)
                    map.put(j, 8.0);
                else if (j == 15)
                    map.put(j, 6.0);
                else if (j == 16)
                    map.put(j, 4.0);
                else
                    map.put(j, 1.0);
            }
            */
            Integer ageRandom = Helper.getWeightedRandom(map);
            map.clear(); // Clears everything inside map.

            // TODO #015
            // Randomizing mileage in between (exclusive both values) distMin and distMax.
            // This code below simply means something like "it is possible to
            // make between 6 and 16 thousands kilometers in a year" with weighting values
            // to more like 8 - 12 k kms a year. After that I multiply it by age of car.
            int distMin = 5;
            int distMax = 16;

            for (int k = distMin; k <= distMax; k++) {
                if (k >= 10 && k <= 11)
                    map.put(k, 8.0);
                else if ((k >= 8 && k <= 9) || k == 12)
                    map.put(k, 6.0);
                else if (k == 7 || k == 13)
                    map.put(k, 4.0);
                else if (k == 6 || k == 14)
                    map.put(k, 2.0);
                else
                    map.put(k, 1.0);
            }

            Integer traveledDist = Helper.getWeightedRandom(map);
            map.clear();

            double randomN = Helper.RNG.nextDouble(1000.0);

            // Take car age, multiply by random weighted value between distMin and distMax multiplied by
            // 10,000 and add some random value [0.0, 1000.0) on the end, so it looks more natural.
            Double mileageRandom = ageRandom * (double) traveledDist * 1000.0 + randomN;

            // TODO #010
            // Real, objective value of a car.
            // Based on a segment we are randomizing car value a little.
            // Taking value of a car and multiplying it by some multiplier. After that 'converting' it to thousands.
            Double valueFullyRepaired;

            if (segment == Segment.BUDGET) {
                valueFullyRepaired = Math.ceil(defaultValue * Helper.RNG.nextDouble(0.9, 1.1)) * 1000;
            } else if (segment == Segment.STANDARD) {
                valueFullyRepaired = Math.ceil(defaultValue * Helper.RNG.nextDouble(0.9, 1.1)) * 1000;
            } else { // else means Segment.PREMIUM in that case
                valueFullyRepaired = Math.ceil(defaultValue * Helper.RNG.nextDouble(0.95, 1.2)) * 1000;
            }

            valueFullyRepaired = ageToValue(ageMin, ageRandom, valueFullyRepaired); // value of this car at current age.

            boolean engine;
            boolean transmission;
            boolean body;
            boolean suspension;
            boolean brakes;

            /*
             * Trying to rework that part a little. I have some ideas.
             * One of my ideas is to random engine, then assign values to other parts to true if it's broken.
             */
            engine = Helper.RNG.nextBoolean();
            transmission = Helper.RNG.nextBoolean();
            body = Helper.RNG.nextBoolean();
            suspension = Helper.RNG.nextBoolean();
            brakes = Helper.RNG.nextBoolean();

            // Basically I want to prevent minimize situations where cars have broken engine, transmission and body.
            if (!engine) {
                transmission = true;
                body = true;
            } else if (!transmission) {
                engine = Helper.RNG.nextBoolean();
            }

            // TODO #017 Randomizing price of a car based on parts it has to repair.
            double price;

            // Subjective price of a car.
            // Based on a segment we are randomizing car value a little.
            // Taking value of a car and multiplying it by some RNG and then rounding it to the nearest value set in roundingTo variable.
            int roundingTo = 1000;
            if (valueFullyRepaired <= 1000.0)
                roundingTo = 10;
            else if (valueFullyRepaired <= 10000.0)
                roundingTo = 50;
            else if (valueFullyRepaired <= 30000.0)
                roundingTo = 500;
            else if (valueFullyRepaired > 125000.0)
                roundingTo = 5000;

            if (segment == Segment.BUDGET) {
                price = Math.round(valueFullyRepaired / roundingTo * Helper.RNG.nextDouble(0.9, 1.1)) * roundingTo;
            } else if (segment == Segment.STANDARD) {
                price = Math.round(valueFullyRepaired / roundingTo * Helper.RNG.nextDouble(0.9, 1.1)) * roundingTo;
            } else { // else means Segment.PREMIUM in that case
                price = Math.round(valueFullyRepaired / roundingTo * Helper.RNG.nextDouble(0.95, 1.2)) * roundingTo;
            }

            /*
             * This is something like seller subtracting from original price.
             * Seller wants to get $10k for a car which is worth 11k, but his car has broken transmission.
             * Okay, so he takes that $10k, subtract $2.5k (10k * 0.25 = 2.5k) and gets his final price, $7.5k
             * This is what he wants for that car.
             *
             * Later when you have that car you will repair it for price that is adequate to car value
             * (real value! not some random guy price that he wants to get...)
             *
             * */
            double enginePrice = price * 0.3;
            double transmissionPrice = price * 0.25;
            double bodyPrice = price * 0.25;
            double suspensionPrice = price * 0.08;
            double brakesPrice = price * 0.02;

            double valueCurrent = valueFullyRepaired;

            if (!engine) {
                price -= enginePrice;
                valueCurrent -= enginePrice;
            }
            if (!transmission) {
                price -= transmissionPrice;
                valueCurrent -= transmissionPrice;
            }
            if (!body) {
                price -= bodyPrice;
                valueCurrent -= bodyPrice;
            }
            if (!suspension) {
                price -= suspensionPrice;
                valueCurrent -= suspensionPrice;
            }
            if (!brakes) {
                price -= brakesPrice;
                valueCurrent -= brakesPrice;
            }
            /*
                // debugging purposes.
            else
                System.out.println("Perfect car!");
            */

            Color colorRandom = Color.getRandomColor();

            valueFullyRepaired = Math.ceil(valueFullyRepaired / roundingTo * Helper.RNG.nextDouble(1.05, 1.15)) * roundingTo; // adding 5-15% value to a car, so player can make some money actually

            if (engine && transmission && body && suspension && brakes) {
                valueCurrent = valueFullyRepaired;
            }

            Car carRandom = new Car(brandName, modelName, ageRandom, mileageRandom, valueFullyRepaired, price, colorRandom, engine, transmission, body, suspension, brakes);

            // Assigning car part value.
            double ageValue = ageToValue(ageMin, ageRandom, (double) defaultValue * 1000.0);

            carRandom.setEngineRepairPrice(ageValue * 0.3);
            carRandom.setTransmissionRepairPrice(ageValue * 0.25);
            carRandom.setBodyRepairPrice(ageValue * 0.25);
            carRandom.setSuspensionRepairPrice(ageValue * 0.08);
            carRandom.setBrakesRepairPrice(ageValue * 0.02);

            carRandom.setValue(valueCurrent);

            if (!engine || !transmission || !body || !suspension || !brakes) {
                double engineMultiplier = 0.0;
                double transmissinMultiplier = 0.0;
                double bodyMultiplier = 0.0;
                double suspensionMultiplier = 0.0;
                double brakesMultiplier = 0.0;
                if (!engine) {
                    engineMultiplier = 1.0;
                }
                if (!transmission) {
                    transmissinMultiplier = 1.0;
                }
                if (!body) {
                    bodyMultiplier = 1.0;
                }
                if (!suspension) {
                    suspensionMultiplier = 1.0;
                }
                if (!brakes) {
                    brakesMultiplier = 1.0;
                }

                double wholeCost = carRandom.getBuyingPrice()
                        + carRandom.getEngineRepairPrice() * engineMultiplier
                        + carRandom.getTransmissionRepairPrice() * transmissinMultiplier
                        + carRandom.getBodyRepairPrice() * bodyMultiplier
                        + carRandom.getSuspensionRepairPrice() * suspensionMultiplier
                        + carRandom.getBrakesRepairPrice() * brakesMultiplier;

                if (carRandom.getValueFullyRepaired() + 1000 <= wholeCost) {
                    carRandom.setValueFullyRepaired(wholeCost * 1.15);
                }
            }

            cars.add(carRandom);
        }
        setCars(cars);
    }

    // This method simulate losing value of a car with age.
    private Double ageToValue(Integer ageMin, Integer age, Double value) {
        if (age != ageMin) {
            for (int k = 0; k < age - ageMin; k++) {
                if (value >= 200000.0)
                    value -= 10000.0;
                else if (value >= 130000.0)
                    value -= 20000.0;
                else if (value >= 100000.0)
                    value -= 15000.0;
                else if (value >= 25000.0)
                    value -= 10000.0;
                else if (value >= 15000.0)
                    value -= 5000.0;
                else if (value >= 5000.0)
                    value -= 2500.0;
                else break;
            }
        }
        return value;
    }

    public void clientsGenerator(Integer number) {
        ArrayList<Client> clients = new ArrayList<>();

        if (getClients() != null) {
            clients.addAll(getClients());
        }

        for (int i = 0; i < number; i++) {

            // Randomizing brands
            ArrayList<Brand> brandList = new ArrayList<>();

            // For checking if this is the same brand as previous one.
            Brand firstBrand = null;

            for (int j = 0; j < 2; j++) {
                Brand rBrand = Brand.randomBrand();
                if (rBrand != firstBrand) {
                    firstBrand = rBrand;
                    brandList.add(rBrand);
                } else {
                    --j;
                }
            }

            // Random chance if client is interested in personal cars
            double rDoubleNumber = Helper.RNG.nextDouble();
            Boolean interestedPersonal = false;
            Boolean interestedCargo = false;

            if (rDoubleNumber < 0.1) { // 10%
                interestedPersonal = true;
                interestedCargo = true;
            } else if (rDoubleNumber < 0.7) { // 60%
                interestedPersonal = true;
                interestedCargo = false;
            } else { // 30%
                interestedPersonal = false;
                interestedCargo = true;
            }

            // Randomizing will to buy broken/damaged car
            rDoubleNumber = Helper.RNG.nextDouble();
            Boolean willBuyBrokenCar = false; // fully destroyed
            Boolean willBuyDamagedCar = false; // brakes/suspension not working

            if (rDoubleNumber < 0.05) {
                willBuyBrokenCar = true;
                willBuyDamagedCar = true;
            } else if (rDoubleNumber < 0.15) {
                willBuyDamagedCar = true;
            }

            Client client = new Client(interestedCargo, interestedPersonal, brandList, willBuyBrokenCar, willBuyDamagedCar);
            clients.add(client);
        }
        setClients(clients);
    }

    public void printClients(Player player, Calendar calendar) {
        char input2 = 97;

        do {
            System.out.println("Your clientele below:");

            // get ArrayList of clients and then printing all clients in this Array to console. What exactly is printed is defined with toString().
            ArrayList<Client> clients = this.getClients();

            Boolean willBuyBrokenCar = false;
            Boolean willBuyDamagedCar = false;

            // TODO #014 - Restricting loops.
            // TODO #020
            int i; // it is here to make this first letter that shows what will happen when you click it.
            int clientsSize = clients.size();
            int clientsToPrint = 10; // how many rows containing clients names we want to print on one site.
            int offset = 0;
            int max = Math.min(clientsToPrint, clientsSize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.
            int totalSites = (int) Math.ceil(clientsSize / (double) clientsToPrint); // total number of sites.
            int currentSite = 1;
            int lastPageCorrection = 0;

            do {
                i = 97; // 97 represents lowercase a.
                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                    Client client = clients.get(j);

                    willBuyBrokenCar = client.getWillBuyBrokenCar();
                    willBuyDamagedCar = client.getWillBuyDamagedCar();
                    String willBuyBrokenCarString = "";
                    String willBuyDamagedCarString = "";

                    if (willBuyBrokenCar && willBuyDamagedCar)
                        willBuyBrokenCarString = " Can buy broken car!";
                    else if (willBuyDamagedCar)
                        willBuyDamagedCarString = " Can buy without brakes and/or suspension!";


                    System.out.printf("%c - This client will buy %s and %s.%s%s\n", (char) i, client.getInterestedBrand(0), client.getInterestedBrand(1), willBuyBrokenCarString, willBuyDamagedCarString);
                    i++;

                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is less objects to print than clientsToPrint.
                        System.out.println("Site " + currentSite + "/" + totalSites);

                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
                        System.out.println(getMessageDependsOnSiteWeAreOn(currentSite, totalSites, "a client"));

                        input2 = Helper.scanner.next().charAt(0);

                        if (input2 == 60 && currentSite != 1) { // 60 is '<'
                            lastPageCorrection = 0;
                            offset -= clientsToPrint;
                            currentSite -= 1;
                            break;
                        } else if (input2 == 62 && currentSite != totalSites) { // 62 is '>'
                            lastPageCorrection = 0;
                            offset += clientsToPrint;
                            // This if is for correction on last page that can contain less than clientsSize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                            if (offset + clientsToPrint > clientsSize) {
                                lastPageCorrection = offset + clientsToPrint - clientsSize;
                            }
                            currentSite += 1;
                            break;
                        } else if (input2 >= 97 && input2 < 97 + max - lastPageCorrection) {

                            client = clients.get(input2 - 97 + offset);

                            System.out.println("Which car would you like to sell to them?");

                            char sellInput = 97;

                            ArrayList<Car> cars = player.getCars();

                            if (cars == null || cars.size() == 0) {
                                System.out.println("You have no cars in your parking lot.");

                            } else {
                                System.out.println("You have following cars in your parking lot:");
                                // It is a lambda expression.
                                // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
                                cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

                                // TODO #014 - Restricting loops.
                                // TODO #020
                                int k; // it is here to make this first letter that shows what will happen when you click it.
                                int carsArraySize = cars.size();
                                int carsToPrint = 10; // how many rows containing cars names we want to print on one site.
                                int offset2 = 0;
                                int max2 = Math.min(carsToPrint, carsArraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.
                                int totalSites2 = (int) Math.ceil(carsArraySize / (double) carsToPrint); // total number of sites.
                                int currentSite2 = 1;
                                int lastPageCorrection2 = 0;

                                do {
                                    k = 97; // 97 represents lowercase a.
                                    for (int l = offset2; l < max2 + offset2 - lastPageCorrection2; l++) {
                                        Car car = cars.get(l);
                                        //System.out.println((char) i + " - " + car.getProducer() + " " + car.getModel() + " " + Helper.moneyPretty(car.getPrice()) + " " + car.getShape());
                                        System.out.printf("%c - %s %s %s %s, which you spent on %s\n", (char) k, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getValue()), car.getShape(), Helper.moneyPretty(car.getSumCashSpent()));
                                        k++;

                                        if (k == 97 + max2 - lastPageCorrection2) { // var max2 here, because it will then properly display first page if there is less objects to print than carsToPrint.
                                            System.out.println("Site " + currentSite2 + "/" + totalSites2);

                                            // Which message will be displayed depends on current site (first, last, first and last at the same time).
                                            System.out.println(getMessageDependsOnSiteWeAreOn(currentSite2, totalSites2, "a car"));

                                            sellInput = Helper.scanner.next().charAt(0);

                                            if (sellInput == 60 && currentSite2 != 1) { // 60 is '<'
                                                lastPageCorrection2 = 0;
                                                offset2 -= carsToPrint;
                                                currentSite2 -= 1;
                                                break;
                                            } else if (sellInput == 62 && currentSite2 != totalSites2) { // 62 is '>'
                                                lastPageCorrection2 = 0;
                                                offset2 += carsToPrint;
                                                // This if is for correction on last page that can contain less than carsArraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                                                if (offset2 + carsToPrint > carsArraySize) {
                                                    lastPageCorrection2 = offset2 + carsToPrint - carsArraySize;
                                                }
                                                currentSite2 += 1;
                                                break;
                                            } else if (sellInput >= 97 && sellInput < 97 + max2 - lastPageCorrection2) {

                                                car = cars.get(sellInput - 97 + offset2);
                                                String brandName1 = client.getInterestedBrand(0).toLowerCase();
                                                String brandName2 = client.getInterestedBrand(1).toLowerCase();
                                                String carProducer = car.getProducer().toLowerCase();

                                                if (!carProducer.equals(brandName1) && !carProducer.equals(brandName2)) {
                                                    System.out.println("Client won't buy car made by this brand.");
                                                } else {
                                                    if (client.getWillBuyDamagedCar()) {
                                                        if (car.getEngine() && car.getTransmission() && car.getBody() && (car.getSuspension() || car.getBrakes())) {

                                                            Double playerCash = player.getCash();

                                                            clients.remove(input2 - 97 + offset);
                                                            this.setClients(clients);
                                                            System.out.println("Debug: client removed.");

                                                            player.setCash(car.getValue() + playerCash);
                                                            System.out.println("Debug: Cash added to player account.");

                                                            cars.remove(sellInput - 97 + offset2);
                                                            player.setCars(cars);
                                                            System.out.println("Debug: Car removed from parking lot.");

                                                            // When removing client we need to let the loop above know about it, as we first declare this variable outside the loop,
                                                            // so if not updating it now, we never update it. It will try to print a client that is not in this list, so we will leave bounds of an array.
                                                            clientsSize = clients.size();
                                                            carsArraySize = cars.size();

                                                            // Changing new max if on new first page will be less than clientsToPrint clients (ie 10).
                                                            max = Math.min(clientsToPrint, clientsSize);
                                                            max2 = Math.min(carsToPrint, carsArraySize);

                                                            if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                                totalSites -= 1;
                                                                currentSite -= 1;
                                                                lastPageCorrection = 0;
                                                                offset -= clientsToPrint;
                                                            } else {
                                                                // Basically check if we now have fewer pages.
                                                                totalSites = (int) Math.ceil(clientsSize / (double) clientsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                            }

                                                            if (currentSite2 == totalSites2 && currentSite2 != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                                totalSites2 -= 1;
                                                                currentSite2 -= 1;
                                                                lastPageCorrection2 = 0;
                                                                offset2 -= clientsToPrint;
                                                            } else {
                                                                // Basically check if we now have fewer pages.
                                                                totalSites2 = (int) Math.ceil(carsArraySize / (double) carsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                            }

                                                            // Passing a day, because car was bought.
                                                            calendar.nextDay();
                                                            checkDay(calendar.getTurns());
                                                            clientsGenerator(2);

                                                            break;
                                                        } else {
                                                            System.out.println("You cannot sell this car to this client!");
                                                        }
                                                    } else if (client.getWillBuyBrokenCar()) {

                                                        Double playerCash = player.getCash();

                                                        clients.remove(input2 - 97 + offset);
                                                        this.setClients(clients);
                                                        System.out.println("Debug: client removed.");

                                                        player.setCash(car.getValue() + playerCash);
                                                        System.out.println("Debug: Cash added to player account.");

                                                        cars.remove(sellInput - 97 + offset2);
                                                        player.setCars(cars);
                                                        System.out.println("Debug: Car removed from parking lot.");

                                                        // When removing client we need to let the loop above know about it, as we first declare this variable outside the loop,
                                                        // so if not updating it now, we never update it. It will try to print a client that is not in this list, so we will leave bounds of an array.
                                                        clientsSize = clients.size();
                                                        carsArraySize = cars.size();

                                                        // Changing new max if on new first page will be less than clientsToPrint clients (ie 10).
                                                        max = Math.min(clientsToPrint, clientsSize);
                                                        max2 = Math.min(carsToPrint, carsArraySize);

                                                        if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                            totalSites -= 1;
                                                            currentSite -= 1;
                                                            lastPageCorrection = 0;
                                                            offset -= clientsToPrint;
                                                        } else {
                                                            // Basically check if we now have fewer pages.
                                                            totalSites = (int) Math.ceil(clientsSize / (double) clientsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                        }

                                                        if (currentSite2 == totalSites2 && currentSite2 != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                            totalSites2 -= 1;
                                                            currentSite2 -= 1;
                                                            lastPageCorrection2 = 0;
                                                            offset2 -= clientsToPrint;
                                                        } else {
                                                            // Basically check if we now have fewer pages.
                                                            totalSites2 = (int) Math.ceil(carsArraySize / (double) carsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                        }

                                                        // Passing a day, because car was bought.
                                                        calendar.nextDay();
                                                        checkDay(calendar.getTurns());
                                                        clientsGenerator(2);

                                                        break;
                                                    } else if (car.getEngine() && car.getTransmission() && car.getBody() && car.getSuspension() && car.getBrakes()) {
                                                        Double playerCash = player.getCash();

                                                        clients.remove(input2 - 97 + offset);
                                                        this.setClients(clients);
                                                        System.out.println("Debug: client removed.");

                                                        player.setCash(car.getValue() + playerCash);
                                                        System.out.println("Debug: Cash added to player account.");

                                                        cars.remove(sellInput - 97 + offset2);
                                                        player.setCars(cars);
                                                        System.out.println("Debug: Car removed from parking lot.");

                                                        // When removing client we need to let the loop above know about it, as we first declare this variable outside the loop,
                                                        // so if not updating it now, we never update it. It will try to print a client that is not in this list, so we will leave bounds of an array.
                                                        clientsSize = clients.size();
                                                        carsArraySize = cars.size();

                                                        // Changing new max if on new first page will be less than clientsToPrint clients (ie 10).
                                                        max = Math.min(clientsToPrint, clientsSize);
                                                        max2 = Math.min(carsToPrint, carsArraySize);

                                                        if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                            totalSites -= 1;
                                                            currentSite -= 1;
                                                            lastPageCorrection = 0;
                                                            offset -= clientsToPrint;
                                                        } else {
                                                            // Basically check if we now have fewer pages.
                                                            totalSites = (int) Math.ceil(clientsSize / (double) clientsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                        }

                                                        if (currentSite2 == totalSites2 && currentSite2 != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                                            totalSites2 -= 1;
                                                            currentSite2 -= 1;
                                                            lastPageCorrection2 = 0;
                                                            offset2 -= clientsToPrint;
                                                        } else {
                                                            // Basically check if we now have fewer pages.
                                                            totalSites2 = (int) Math.ceil(carsArraySize / (double) carsToPrint); // This one also need to be updated if we are going to buy last client on the last page.
                                                        }

                                                        // Passing a day, because car was bought.
                                                        calendar.nextDay();
                                                        checkDay(calendar.getTurns());
                                                        clientsGenerator(2);

                                                        break;
                                                    } else {
                                                        System.out.println("Cannot sell this car to this client. It is too damaged.");
                                                    }
                                                }
                                            } else {
                                                if (sellInput != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                                    System.out.println(">:(");
                                            }
                                        }
                                    }
                                } while (sellInput == 62 || sellInput == 60 || !(sellInput >= 97 && sellInput <= 97 + max2)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
                            }
                            break;
                        } else {
                            if (input2 != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                System.out.println(">:(");
                        }
                    }
                }
            } while (input2 == 62 || input2 == 60 || (input2 >= 97 && input2 <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
        } while (input2 != 'x');
    }

    public void printCarsAvailableToBuy(Player player, Calendar calendar, int rowsToPrint) {

        System.out.println("\nThese are the cars you are able to buy. If you have enough $$$ of course ;)");

        char input = 97;

        do {
            // get ArrayList of cars and then printing all cars in this Array to console. What exactly is printed is defined with toString().
            ArrayList<Car> cars = this.getCars();

            // It is a lambda expression(?).
            // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
            cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

            // TODO #014 - Restricting loops.
            // TODO #020
            int i; // it is here to make this first letter that shows what will happen when you click it.
            int arraySize = cars.size();
            // int rowsToPrint = 10; // how many rows containing cars names we want to print on one site.
            int offset = 0;
            int max = Math.min(rowsToPrint, arraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.

            int totalSites = (int) Math.ceil(arraySize / (double) rowsToPrint); // total number of sites.
            int currentSite = 1;
            int lastPageCorrection = 0;

            do {
                i = 97; // 97 represents lowercase a.
                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                    Car car = cars.get(j);
                    System.out.printf("%c - %s %s %s %s \n", (char) i, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getBuyingPrice()), car.getShape());
                    i++;

                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is fewer objects to print than rowsToPrint.
                        System.out.println("Site " + currentSite + "/" + totalSites);

                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
                        System.out.println(getMessageDependsOnSiteWeAreOn(currentSite, totalSites, "a car"));

                        // Buying car part:

                        input = Helper.scanner.next().charAt(0);

                        if (input == 60 && currentSite != 1) { // 60 is '<'
                            lastPageCorrection = 0;
                            offset -= rowsToPrint;
                            currentSite -= 1;
                            break;
                        } else if (input == 62 && currentSite != totalSites) { // 62 is '>'
                            lastPageCorrection = 0;
                            offset += rowsToPrint;
                            // This if is for correction on last page that can contain less than arraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                            if (offset + rowsToPrint > arraySize) {
                                lastPageCorrection = offset + rowsToPrint - arraySize;
                            }
                            currentSite += 1;
                            break;
                        } else if (input >= 97 && input < 97 + max - lastPageCorrection) {

                            car = cars.get(input - 97 + offset);
                            System.out.println(car.getCarStringPrice());

                            char buyInput;
                            System.out.println("\nPress x to continue or b to buy this car (buying pass a day).");

                            do {
                                buyInput = Helper.scanner.next().charAt(0);

                                if (buyInput == 'b') {
                                    Double playerCash = player.getCash();
                                    Double carPrice = car.getBuyingPrice();

                                    if (playerCash < carPrice) {
                                        System.out.println("You don't have enough cash for this transaction.");
                                    } else {
                                        player.setCash(playerCash - carPrice);
                                        System.out.println("Debug: player cash adjusted.");

                                        cars.remove(input - 97 + offset);
                                        System.out.println("Debug: car removed.");

                                        player.addCar(car);
                                        System.out.println("Debug: car added to player parking.");

                                        ArrayList<String> newTransaction = new ArrayList<>(car.getTransactions());
                                        newTransaction.add("Car was bought for " + Helper.moneyPretty(carPrice));
                                        car.setTransactions(newTransaction);

                                        car.setSumCashSpent(car.getSumCashSpent() + carPrice);

                                        // When removing car we need to let the loop above know about it, as we first declare this variable outside the loop,
                                        // so if not updating it now, we never update it. It will try to print a car that is not in this list, so we will leave bounds of an array.
                                        arraySize = cars.size();

                                        // Changing new max if on new first page will be less than rowsToPrint cars (ie 10).
                                        max = Math.min(rowsToPrint, arraySize);

                                        if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                            totalSites -= 1;
                                            currentSite -= 1;
                                            lastPageCorrection = 0;
                                            offset -= rowsToPrint;
                                        } else {
                                            // Basically check if we now have fewer pages.
                                            totalSites = (int) Math.ceil(arraySize / (double) rowsToPrint); // This one also need to be updated if we are going to buy last car on the last page.
                                        }

                                        // Passing a day, because car was bought.
                                        calendar.nextDay();
                                        checkDay(calendar.getTurns());
                                    }
                                } else {
                                    System.out.println(">:(");
                                }
                            } while (buyInput != 'x' && buyInput != 'b');
                            break;
                        } else {
                            if (input != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                System.out.println(">:(");
                        }
                    }
                }
            } while (input == 62 || input == 60 || (input >= 97 && input <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
        } while (input != 'x'); // x means "go back"
    }

    public void checkDay(int turns) {
        // Every 7 days/turns adding 3 car to buy.
        if (turns % 7 == 0) {
            carsGenerator(3);
        }
    }

    // I want to do that, but so spaghetti... Not sure about it...
    /*public void printCarsToBuy(int rowsToPrint, int offset, int lastPageCorrection, int currentSite) {

        ArrayList<Car> cars = this.getCars();
        cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

        int totalSites = (int) Math.ceil(cars.size() / (double) rowsToPrint);
        int max = Math.min(rowsToPrint, cars.size());

        int interactiveLetter = 97; // the letter we want to start with - 'a' in this case

        System.out.println("\nThese the cars you are able to buy. If you have enough $$$ of course ;)");

        for (int i = offset; i < max + offset - lastPageCorrection; i++) {
            Car car = cars.get(i);
            System.out.printf("%c - %s %s %s %s \n", (char) interactiveLetter, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getBuyingPrice()), car.getShape());
            interactiveLetter++;
        }
    }*/


    public void printCarsAvailableToBuyTesting(Player player, Calendar calendar, int rowsToPrint, int arraySize, int max) {

        System.out.println("\nThese are the cars you are able to buy. If you have enough $$$ of course ;)");

        char input = 97;

        do {
            // get ArrayList of cars and then printing all cars in this Array to console. What exactly is printed is defined with toString().
            ArrayList<Car> cars = this.getCars();

            // It is a lambda expression(?).
            // Honestly don't know how does that works, but it sorts cars by String producer and String Model.
            cars.sort(Comparator.comparing(Car::getProducer).thenComparing(Car::getModel));

            // TODO #014 - Restricting loops.
            // TODO #020
            int i; // it is here to make this first letter that shows what will happen when you click it.
            //int arraySize = cars.size();
            // int rowsToPrint = 10; // how many rows containing cars names we want to print on one site.
            int offset = 0;
            //int max = Math.min(rowsToPrint, arraySize); // takes the lower value of these two which then we are using later as maximum in our for loop. Prevents java.lang.IndexOutOfBoundsException.

            int totalSites = (int) Math.ceil(arraySize / (double) rowsToPrint); // total number of sites.
            int currentSite = 1;
            int lastPageCorrection = 0;

            do {
                i = 97; // 97 represents lowercase a.
                for (int j = offset; j < max + offset - lastPageCorrection; j++) {
                    Car car = cars.get(j);
                    System.out.printf("%c - %s %s %s %s \n", (char) i, car.getProducer(), car.getModel(), Helper.moneyPretty(car.getBuyingPrice()), car.getShape());
                    i++;

                    if (i == 97 + max - lastPageCorrection) { // var max here, because it will then properly display first page if there is fewer objects to print than rowsToPrint.
                        System.out.println("Site " + currentSite + "/" + totalSites);

                        // Which message will be displayed depends on current site (first, last, first and last at the same time).
                        System.out.println(getMessageDependsOnSiteWeAreOn(currentSite, totalSites, "a car"));

                        // Buying car part:

                        input = Helper.scanner.next().charAt(0);

                        if (input == 60 && currentSite != 1) { // 60 is '<'
                            lastPageCorrection = 0;
                            offset -= rowsToPrint;
                            currentSite -= 1;
                            break;
                        } else if (input == 62 && currentSite != totalSites) { // 62 is '>'
                            lastPageCorrection = 0;
                            offset += rowsToPrint;
                            // This if is for correction on last page that can contain less than arraySize values, so it is to prevent java.lang.IndexOutOfBoundsException.
                            if (offset + rowsToPrint > arraySize) {
                                lastPageCorrection = offset + rowsToPrint - arraySize;
                            }
                            currentSite += 1;
                            break;
                        } else if (input >= 97 && input < 97 + max - lastPageCorrection) {

                            car = cars.get(input - 97 + offset);
                            System.out.println(car.getCarStringPrice());

                            char buyInput;
                            System.out.println("\nPress x to continue or b to buy this car (buying pass a day).");

                            do {
                                buyInput = Helper.scanner.next().charAt(0);

                                if (buyInput == 'b') {
                                    Double playerCash = player.getCash();
                                    Double carPrice = car.getBuyingPrice();

                                    if (playerCash < carPrice) {
                                        System.out.println("You don't have enough cash for this transaction.");
                                    } else {
                                        player.setCash(playerCash - carPrice);
                                        System.out.println("Debug: player cash adjusted.");

                                        cars.remove(input - 97 + offset);
                                        System.out.println("Debug: car removed.");

                                        player.addCar(car);
                                        System.out.println("Debug: car added to player parking.");

                                        // When removing car we need to let the loop above know about it, as we first declare this variable outside the loop,
                                        // so if not updating it now, we never update it. It will try to print a car that is not in this list, so we will leave bounds of an array.
                                        arraySize = cars.size();

                                        // Changing new max if on new first page will be less than rowsToPrint cars (ie 10).
                                        max = Math.min(rowsToPrint, arraySize);

                                        if (currentSite == totalSites && currentSite != 1) { //if this is last page, but if this is first and last page... Then TODO #020
                                            totalSites -= 1;
                                            currentSite -= 1;
                                            lastPageCorrection = 0;
                                            offset -= rowsToPrint;
                                        } else {
                                            // Basically check if we now have fewer pages.
                                            totalSites = (int) Math.ceil(arraySize / (double) rowsToPrint); // This one also need to be updated if we are going to buy last car on the last page.
                                        }

                                        // Passing a day, because car was bought.
                                        calendar.nextDay();
                                        checkDay(calendar.getTurns());
                                    }
                                } else {
                                    System.out.println(">:(");
                                }
                            } while (buyInput != 'x' && buyInput != 'b');
                            break;
                        } else {
                            if (input != 'x') // simply because when I was clicking to get back my own program gave me a heckin' angry face. >:( god-damn it. But now its fixed smileyFace.
                                System.out.println(">:(");
                        }
                    }
                }
            } while (input == 62 || input == 60 || (input >= 97 && input <= 97 + max)); // be careful to not exceed a 120 (x) as you will never leave from this loop.
        } while (input != 'x'); // x means "go back"
    }

    public String getMessageDependsOnSiteWeAreOn(int currentSite, int totalSites, String objectName) {
        if (currentSite == 1 && currentSite == totalSites) {
            return "Choose " + objectName + " or get back (x).";
        } else if (currentSite == 1)
            return "Choose " + objectName + ", go to next site (>) or get back (x).";
        else if (currentSite == totalSites)
            return "Choose " + objectName + ", go to previous site (<) or get back (x).";
        else
            return "Choose " + objectName + ", go to next site (>), previous site (<) or get back (x).";
    }
}

