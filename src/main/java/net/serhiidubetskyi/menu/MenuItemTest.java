package net.serhiidubetskyi.menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuItemTest {

    @Test
    public void execute() {
        MenuItem menuItem = new MenuItem() {
            @Override
            public boolean execute(String[] args) {
                return false;
            }
        };
        assertFalse(menuItem.execute(null));
    }

    @Test
    public void getCommand() {
        MenuItem menuItem = new MenuItem() {
            @Override
            public boolean execute(String[] args) {
                return false;
            }
        };
        assertEquals("INCORRECT_COMMAND", menuItem.getCommand());
    }

    @Test
    public void getDescription() {
        MenuItem menuItem = new MenuItem() {
            @Override
            public boolean execute(String[] args) {
                return false;
            }
        };
        assertEquals("INCORRECT_DESCRIPTION", menuItem.getDescription());
    }
}