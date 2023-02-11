package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TaxiBySpeedItem implements MenuItem {
    private static final String COMMAND = "taxiBySpeed";
    private static final String DESCRIPTION = "Find taxi by speed";
    private static final Logger logger = LoggerFactory.getLogger(TaxiBySpeedItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public TaxiBySpeedItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length < 3) {
            logger.info("Invalid number of arguments");
            System.out.println("Invalid number of arguments");
        } else if (!taxiDepots.containsKey(args[0])) {
            logger.info("Taxi depot with name {} does not exist", args[0]);
            System.out.println("Taxi depot with name " + args[0] + " does not exist");
        } else {
            int minSpeed = Integer.parseInt(args[1]);
            int maxSpeed = Integer.parseInt(args[2]);
            for (Taxi taxi : taxiDepots.get(args[0]).getTaxisBySpeed(minSpeed, maxSpeed)) {
                System.out.println(taxi);
            }
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