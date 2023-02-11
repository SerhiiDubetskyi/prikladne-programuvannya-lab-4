package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.TaxiDepot;

public class ListSavesItem implements MenuItem {
    private static final String COMMAND = "listSaves";
    private static final String DESCRIPTION = "List all saved taxi depots";

    @Override
    public boolean execute(String[] args) {
        TaxiDepot.getSaves().forEach(System.out::println);
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
