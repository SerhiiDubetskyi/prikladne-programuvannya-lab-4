package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;

import java.util.Map;

public class HelpMenuItem implements MenuItem {
    private static final String COMMAND = "help";
    private static final String DESCRIPTION = "Prints help information";
    private Map<String, MenuItem> menuItems;

    public HelpMenuItem(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean execute(String[] args) {
        System.out.println("Available commands:");
        for (MenuItem menuItem : menuItems.values()) {
            System.out.println(menuItem.getCommand() + " - " + menuItem.getDescription());
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
