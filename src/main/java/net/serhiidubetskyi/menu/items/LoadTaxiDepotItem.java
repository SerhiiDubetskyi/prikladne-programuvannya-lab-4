package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LoadTaxiDepotItem implements MenuItem {
    private static final String COMMAND = "loadTaxiDepot";
    private static final String DESCRIPTION = "Load taxi depot from file";
    private static final Logger logger = LoggerFactory.getLogger(LoadTaxiDepotItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public LoadTaxiDepotItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            if (taxiDepots.containsKey(args[0])) {
                logger.info("Taxi depot {} already exists", args[0]);
                System.out.println("Taxi depot " + args[0] + " already exists");
            } else {
                logger.info("Loading taxi depot {}", args[0]);
                System.out.println("Loading taxi depot " + args[0]);
                TaxiDepot taxiDepot = TaxiDepot.loadFromFile(args[0]);

                if (taxiDepot != null) {
                    taxiDepots.put(args[0], taxiDepot);
                    logger.info("Taxi depot {} loaded", args[0]);
                    System.out.println("Taxi depot " + args[0] + " loaded");
                } else {
                    logger.info("Taxi depot {} not loaded", args[0]);
                    System.out.println("Taxi depot " + args[0] + " not loaded");
                }
            }
        } else {
            logger.info("Loading taxi depot failed");
            System.out.println("Please specify a name for the taxi depot to load");
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
