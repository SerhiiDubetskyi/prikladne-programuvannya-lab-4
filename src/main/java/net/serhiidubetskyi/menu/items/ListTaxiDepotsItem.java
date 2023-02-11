package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ListTaxiDepotsItem implements MenuItem {
    private static final String COMMAND = "listTaxiDepots";
    private static final String DESCRIPTION = "List all taxi depots";
    private static final Logger logger = LoggerFactory.getLogger(ListTaxiDepotsItem.class);
    private Map<String, TaxiDepot> taxiDepots;

    public ListTaxiDepotsItem(Map<String, TaxiDepot> taxiDepots) {
        this.taxiDepots = taxiDepots;
    }

    @Override
    public boolean execute(String[] args) {
        if (taxiDepots.isEmpty()) {
            logger.info("No taxi depots found");
            System.out.println("No taxi depots found");
        } else {
            logger.info("Listing all taxi depots");
            System.out.println("Taxi depots:");
            taxiDepots.forEach((name, taxiDepot) -> System.out.println(name));
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