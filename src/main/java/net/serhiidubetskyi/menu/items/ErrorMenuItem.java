package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorMenuItem implements MenuItem {
    private static final String COMMAND = "error";
    private static final String DESCRIPTION = "Logs an error message";
    private static Logger logger = LoggerFactory.getLogger(ErrorMenuItem.class);

    @Override
    public boolean execute(String[] args) {
        if (args.length > 0) {
            System.out.println("Error: " + args[0]);
            logger.error("Error: {}", args[0]);
        } else {
            System.out.println("Error");
            logger.error("Error");
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
