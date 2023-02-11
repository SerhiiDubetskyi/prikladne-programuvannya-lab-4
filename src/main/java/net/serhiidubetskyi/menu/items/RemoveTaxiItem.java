package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RemoveTaxiItem implements MenuItem {
    private static final String COMMAND = "removeTaxi";
    private static final String DESCRIPTION = "Removes taxi from the depot";
    private static final Logger logger = LoggerFactory.getLogger(RemoveTaxiItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public RemoveTaxiItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length < 2) {
            logger.info("Invalid number of arguments");
            System.out.println("Invalid number of arguments");
        } else if (!taxiDepots.containsKey(args[0])) {
            logger.info("Taxi depot with name {} does not exist", args[0]);
            System.out.println("Taxi depot with name " + args[0] + " does not exist");
        } else if (!taxiDepots.get(args[0]).getTaxis().containsKey(args[1])) {
            System.out.println("Taxi with name " + args[1] + " does not exist");
        } else {
            taxiDepots.get(args[0]).removeTaxi(args[1]);
            System.out.println("Taxi " + args[1] + " removed from the depot " + args[0]);
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
