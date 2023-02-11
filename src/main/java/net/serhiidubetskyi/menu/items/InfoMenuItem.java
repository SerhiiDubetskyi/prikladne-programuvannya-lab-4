package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;

public class InfoMenuItem implements MenuItem {
    private static final String COMMAND = "info";
    private static final String DESCRIPTION = "Show information about the application";

    @Override
    public boolean execute(String[] args) {
        System.out.println("Lab 4 application");
        System.out.println("Version 1.0");
        System.out.println("Author: Serhii Dubetskyi");

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
