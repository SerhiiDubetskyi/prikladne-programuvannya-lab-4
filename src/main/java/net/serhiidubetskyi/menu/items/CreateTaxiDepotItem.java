package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CreateTaxiDepotItem implements MenuItem {
    private static final String COMMAND = "createTaxiDepot";
    private static final String DESCRIPTION = "Create a new taxi depot";
    private static final Logger logger = LoggerFactory.getLogger(CreateTaxiDepotItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public CreateTaxiDepotItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            if (taxiDepots.containsKey(args[0])) {
                logger.info("Creating a taxi depot with name '{}' failed", args[0]);
                System.out.println("Taxi depot with name '" + args[0] + "' already exists");
            } else {
                logger.info("Creating a taxi depot with name '{}'", args[0]);
                System.out.println("Taxi depot with name '" + args[0] + "' created");
                taxiDepots.put(args[0], new TaxiDepot(args[0]));
            }
        } else {
            logger.info("Creating a new taxi depot failed");
            System.out.println("Please specify a name for the new taxi depot");
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
