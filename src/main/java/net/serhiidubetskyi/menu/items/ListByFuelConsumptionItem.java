package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Map;

public class ListByFuelConsumptionItem implements MenuItem {
    private static final String COMMAND = "listByFuelConsumption";
    private static final String DESCRIPTION = "List all taxis sorted by fuel consumption";
    private static final Logger logger = LoggerFactory.getLogger(ListByFuelConsumptionItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public ListByFuelConsumptionItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            if (taxiDepots.containsKey(args[0])) {
                logger.info("Listing taxis in the depot {}", args[0]);
                System.out.println("Taxis in the depot " + args[0] + " sorted by fuel consumption:");
                taxiDepots.get(args[0]).getTaxis().values().stream()
                        .sorted(Comparator.comparingDouble(Taxi::getFuelConsumption))
                        .forEach(System.out::println);
                System.out.println("Total fuel consumption: " + taxiDepots.get(args[0]).getTaxisFuelConsumption());
            } else {
                logger.info("Taxi depot {} not found", args[0]);
                System.out.println("Taxi depot " + args[0] + " not found");
            }
        } else {
            logger.info("Listing taxis failed");
            System.out.println("Please specify a name for the taxi depot to list taxis from");
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
