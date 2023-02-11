package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RemoveTaxiDepotItem implements MenuItem {
    private static final String COMMAND = "removeTaxiDepot";
    private static final String DESCRIPTION = "Remove a taxi depot";
    private static final Logger logger = LoggerFactory.getLogger(RemoveTaxiDepotItem.class);
    private Map<String, TaxiDepot> taxiDepots;


    public RemoveTaxiDepotItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            if (taxiDepots.containsKey(args[0])) {
                taxiDepots.remove(args[0]);
                logger.info("Taxi depot {} removed", args[0]);
                System.out.println("Taxi depot " + args[0] + " removed");
            } else {
                logger.info("Taxi depot {} not found", args[0]);
                System.out.println("Taxi depot " + args[0] + " not found");
            }
        } else {
            logger.info("Removing a taxi depot failed");
            System.out.println("Please specify a name for the taxi depot to remove");
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
