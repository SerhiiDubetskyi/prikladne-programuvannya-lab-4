package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SaveTaxiDepotItem implements MenuItem {
    private static final String COMMAND = "saveTaxiDepot";
    private static final String DESCRIPTION = "Save taxi depot to file";
    private static final Logger logger = LoggerFactory.getLogger(SaveTaxiDepotItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public SaveTaxiDepotItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            if (taxiDepots.containsKey(args[0])) {
                boolean result;
                TaxiDepot taxiDepot = taxiDepots.get(args[0]);

                logger.info("Saving taxi depot {}", args[0]);
                System.out.println("Saving taxi depot " + args[0]);

                if (args.length > 1) {
                    result = taxiDepot.saveToFile(args[1]);
                } else {
                    result = taxiDepot.saveToFile();
                }

                if (result) {
                    logger.info("Taxi depot {} saved successfully", args[0]);
                    System.out.println("Taxi depot " + args[0] + " saved successfully");
                } else {
                    logger.info("Taxi depot {} saving failed", args[0]);
                    System.out.println("Taxi depot " + args[0] + " saving failed");
                }
            } else {
                logger.info("Taxi depot {} not found", args[0]);
                System.out.println("Taxi depot " + args[0] + " not found");
            }
        } else {
            logger.info("Saving taxi depot failed");
            System.out.println("Please specify a name for the taxi depot to save");
        }
        return false;
    }

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
