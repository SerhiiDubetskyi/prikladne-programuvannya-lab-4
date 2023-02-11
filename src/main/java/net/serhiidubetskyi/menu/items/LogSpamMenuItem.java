package net.serhiidubetskyi.menu.items;

import net.serhiidubetskyi.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSpamMenuItem implements MenuItem {
    private static final String COMMAND = "logSpam";
    private static final String DESCRIPTION = "Prints a lot of log messages";
    private static final Logger logger = LoggerFactory.getLogger(LogSpamMenuItem.class);

    @Override
    public boolean execute(String[] args) {
        for (int i = 0; i < 100; i++) {
            logger.info("Log spam message {}", i);
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
