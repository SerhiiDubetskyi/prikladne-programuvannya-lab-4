package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GetTaxiDepotCostItem implements MenuItem {
    private static final String COMMAND = "getTaxiDepotCost";
    private static final String DESCRIPTION = "Get the cost of all taxis in the depot";
    private static final Logger logger = LoggerFactory.getLogger(GetTaxiDepotCostItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public GetTaxiDepotCostItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            if (taxiDepots.containsKey(args[0])) {
                logger.info("Getting the cost of all taxis in the depot {}", args[0]);
                System.out.println("The cost of all taxis in the depot " + args[0] + " is "
                        + taxiDepots.get(args[0]).getTaxisPrice());
            } else {
                logger.info("Taxi depot {} not found", args[0]);
                System.out.println("Taxi depot " + args[0] + " not found");
            }
        } else {
            logger.info("Getting the cost of all taxis failed");
            System.out.println("Please specify a name for the taxi depot to get the cost of all taxis from");
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
