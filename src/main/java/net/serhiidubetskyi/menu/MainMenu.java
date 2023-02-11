package net.serhiidubetskyi.menu;

import net.serhiidubetskyi.menu.items.*;
import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiDepot;
import net.serhiidubetskyi.taxi.taxis.BusinessTaxi;
import net.serhiidubetskyi.taxi.taxis.ComfortTaxi;
import net.serhiidubetskyi.taxi.taxis.EconomyTaxi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MainMenu {
    private static Logger logger = LoggerFactory.getLogger(MainMenu.class);
    private Map<String, MenuItem> menuItems;
    private Scanner scanner;
    private Map<String, TaxiDepot> taxiDepots;
    private Map<String, Taxi> cachedTaxis;

    public MainMenu() {
        setCachedTaxis();
        taxiDepots = new LinkedHashMap<>();
        menuItems = new LinkedHashMap<>();
        putMenuItem(new InfoMenuItem());
        putMenuItem(new ErrorMenuItem());
        putMenuItem(new ExitMenuItem());
        putMenuItem(new LogSpamMenuItem());
        putMenuItem(new ListAvailableTaxisItem(cachedTaxis));
        putMenuItem(new CreateTaxiDepotItem(taxiDepots));
        putMenuItem(new RemoveTaxiDepotItem(taxiDepots));
        putMenuItem(new ListTaxiDepotsItem(taxiDepots));
        putMenuItem(new AddTaxiItem(taxiDepots, cachedTaxis));
        putMenuItem(new RemoveTaxiItem(taxiDepots));
        putMenuItem(new ListTaxisItem(taxiDepots));
        putMenuItem(new ListByFuelConsumptionItem(taxiDepots));
        putMenuItem(new TaxiBySpeedItem(taxiDepots));
        putMenuItem(new GetTaxiDepotCostItem(taxiDepots));
        putMenuItem(new SaveTaxiDepotItem(taxiDepots));
        putMenuItem(new LoadTaxiDepotItem(taxiDepots));
        putMenuItem(new ListSavesItem());
        putMenuItem(new HelpMenuItem(menuItems));
    }

    public void commandLoop() {
        scanner = new Scanner(System.in);
        logger.info("Command loop started");
        System.out.println("Print 'help' for the list of available commands");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command == null) {
                logger.info("Command is null");
                continue;
            }

            if (execute(command)) {
                logger.info("Command loop stopped");
                break;
            }
        }

        scanner.close();
    }

    private boolean execute(String command) {
        String[] args = command.split(" ");
        boolean exit = false;

        if (args.length > 0) {
            MenuItem item = menuItems.get(args[0]);
            if (item != null) {
                logger.info("Executing command {}", args[0]);
                exit = item.execute(Arrays.copyOfRange(args, 1, args.length));
            } else {
                System.out.println("Unknown command");
                logger.info("Command not found");
            }
        }

        return exit;
    }

    private void putMenuItem(MenuItem item) {
        logger.info("Registered new command: {}", item.getClass().getSimpleName());
        menuItems.put(item.getCommand(), item);
    }

    private void setCachedTaxis() {
        cachedTaxis = new LinkedHashMap<>();
        putTaxi(new EconomyTaxi());
        putTaxi(new ComfortTaxi());
        putTaxi(new BusinessTaxi());
    }

    private void putTaxi(Taxi taxi) {
        cachedTaxis.put(taxi.getName(), taxi);
    }
}