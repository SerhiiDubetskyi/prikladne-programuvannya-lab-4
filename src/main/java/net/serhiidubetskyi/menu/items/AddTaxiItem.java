package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

public class AddTaxiItem implements MenuItem {
    private static final String COMMAND = "addTaxi";
    private static final String DESCRIPTION = "Adds taxi to the depot";
    private static final Logger logger = LoggerFactory.getLogger(AddTaxiItem.class);
    private Map<String, TaxiDepot> taxiDepots;
    private Map<String, Taxi> cachedTaxis;

    public AddTaxiItem(Map<String, TaxiDepot> taxiDepots, Map<String, Taxi> cachedTaxis) {
        this.taxiDepots = taxiDepots;
        this.cachedTaxis = cachedTaxis;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length < 3) {
            logger.info("Invalid number of arguments");
            System.out.println("Invalid number of arguments");
        } else if (!taxiDepots.containsKey(args[0])) {
            logger.info("Taxi depot with name {} does not exist", args[0]);
            System.out.println("Taxi depot with name " + args[0] + " does not exist");
        } else if (!cachedTaxis.containsKey(args[1])) {
            logger.info("Taxi with name {} does not exist", args[1]);
            System.out.println("Taxi with name " + args[1] + " does not exist");
        } else {
            Taxi taxi = cachedTaxis.get(args[1]);
            taxi.randParams(new Random());
            taxi.setName(args[2]);
            taxiDepots.get(args[0]).addTaxi(taxi);
            logger.info("Taxi '{}' added to the depot {}", taxi.getName(), args[0]);
            System.out.println("Taxi '" + taxi.getName() + "' added to the depot " + args[0]);
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
