package net.serhiidubetskyi;

import net.serhiidubetskyi.menu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");
        MainMenu menu = new MainMenu();
        menu.commandLoop();
        logger.info("Application finished");
    }
}