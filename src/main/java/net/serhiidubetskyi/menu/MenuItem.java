package net.serhiidubetskyi.menu;

public interface MenuItem {
    String COMMAND = "INCORRECT_COMMAND";
    String DESCRIPTION = "INCORRECT_DESCRIPTION";

    boolean execute(String[] args);

    default String getCommand() {
        return COMMAND;
    }

    default String getDescription() {
        return DESCRIPTION;
    }
}
