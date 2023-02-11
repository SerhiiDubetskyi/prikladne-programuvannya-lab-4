package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import net.serhiidubetskyi.taxi.Taxi;

import java.util.Map;

public class ListAvailableTaxisItem implements MenuItem {
    private static final String COMMAND = "listAvailableTaxis";
    private static final String DESCRIPTION = "List all available taxis";
    private Map<String, Taxi> cachedTaxis;

    public ListAvailableTaxisItem(Map<String, Taxi> cachedTaxis) {
        this.cachedTaxis = cachedTaxis;
    }

    @Override
    public boolean execute(String[] args) {
        for (String name : cachedTaxis.keySet()) {
            System.out.println(name);
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
