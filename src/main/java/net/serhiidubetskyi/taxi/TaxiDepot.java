package net.serhiidubetskyi.taxi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class TaxiDepot implements Serializable {
    private final static Logger logger = LoggerFactory.getLogger(TaxiDepot.class);
    private String name;
    private Map<String, Taxi> taxis;

    public TaxiDepot(String name) {
        this.name = name;
        taxis = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public boolean addTaxi(Taxi taxi) {
        if (!taxis.containsKey(taxi.getName())) {
            taxis.put(taxi.getName(), taxi);
            return true;
        }

        return false;
    }

    public boolean removeTaxi(String name) {
        if (taxis.containsKey(name)) {
            taxis.remove(name);
            return true;
        }

        return false;
    }

    public Map<String, Taxi> getTaxis() {
        return taxis;
    }

    public Taxi getTaxi(String key) {
        return taxis.get(key);
    }

    public int getTaxisCount() {
        return taxis.size();
    }

    public int getTaxisPrice() {
        int price = 0;

        for (Taxi taxi : taxis.values()) {
            price += taxi.getPrice();
        }

        return price;
    }

    public Taxi getTaxiByNumber(String number) {
        for (Taxi taxi : taxis.values()) {
            if (taxi.getNumber().equals(number)) {
                return taxi;
            }
        }

        return null;
    }

    public ArrayList<Taxi> getTaxisBySpeed(int minSpeed, int maxSpeed) {
        ArrayList<Taxi> result = new ArrayList<>();

        for (Taxi taxi : taxis.values()) {
            if (taxi.getSpeed() >= minSpeed && taxi.getSpeed() <= maxSpeed) {
                result.add(taxi);
            }
        }

        return result;
    }

    public int getTaxisFuelConsumption() {
        int fuelConsumption = 0;

        for (Taxi taxi : taxis.values()) {
            fuelConsumption += taxi.getFuelConsumption();
        }

        return fuelConsumption;
    }

    public boolean saveToFile(String fileName) {
        File dir = new File("./taxi_depots");
        if (!dir.exists()) {
            logger.info("Directory {} does not exist", dir.getAbsolutePath());
            try {
                if (!dir.mkdir()) {
                    logger.info("Cannot create directory {}", dir.getAbsolutePath());
                    return false;
                }
                logger.info("Directory {} created", dir.getAbsolutePath());
            } catch (Exception e) {
                logger.error(e.getMessage());
                return false;
            }
        }

        File file = new File(dir + "/" + fileName + ".td");
        if (file.exists()) {
            logger.info("File {} already exists", file.getAbsolutePath());
            return false;
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
            logger.info("Taxi depot {} saved to file {}", name, file.getAbsolutePath());
            return true;
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            return false;
        }
    }

    public boolean saveToFile() {
        return saveToFile(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")));
    }

    public static TaxiDepot loadFromFile(String fileName) {
        File dir = new File("./taxi_depots");
        if (!dir.exists()) {
            logger.info("Directory {} does not exist", dir.getAbsolutePath());
            return null;
        }

        File file = new File(dir, fileName + ".td");
        if (!file.exists()) {
            logger.info("File {} does not exist", file.getAbsolutePath());
            return null;
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            TaxiDepot taxiDepot = (TaxiDepot) ois.readObject();
            logger.info("Taxi depot {} loaded from file {}", taxiDepot.getName(), file.getAbsolutePath());
            return taxiDepot;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static ArrayList<File> getSaves() {
        File dir = new File("./taxi_depots");
        ArrayList<File> files = new ArrayList<>();
        if (!dir.exists()) {
            logger.info("Directory {} does not exist", dir.getAbsolutePath());
        } else {
            try {
                for (File file : Objects.requireNonNull(dir.listFiles())) {
                    if (file.getName().endsWith(".td")) {
                        files.add(file);
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        return files;
    }
}
