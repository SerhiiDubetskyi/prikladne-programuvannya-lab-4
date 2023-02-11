package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;

public class ExitMenuItem implements MenuItem {
    private static final String COMMAND = "exit";
    private static final String DESCRIPTION = "Exit the application";

    @Override
    public boolean execute(String[] args) {
        return true;
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
