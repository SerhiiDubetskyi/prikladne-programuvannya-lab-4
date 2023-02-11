package net.serhiidubetskyi.menu.items;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void getCommand() {
        AddTaxiItem addTaxiItem = new AddTaxiItem(null , null);
        CreateTaxiDepotItem createTaxiDepotItem = new CreateTaxiDepotItem(null);
        ExitMenuItem exitMenuItem = new ExitMenuItem();
        GetTaxiDepotCostItem getTaxiDepotCostItem = new GetTaxiDepotCostItem(null);
        HelpMenuItem helpMenuItem = new HelpMenuItem(null);
        InfoMenuItem infoMenuItem = new InfoMenuItem();
        ListAvailableTaxisItem listAvailableTaxisItem = new ListAvailableTaxisItem(null);
        ListByFuelConsumptionItem listByFuelConsumptionItem = new ListByFuelConsumptionItem(null);
        ListSavesItem listSavesItem = new ListSavesItem();
        ListTaxiDepotsItem listTaxiDepotsItem = new ListTaxiDepotsItem(null);
        ListTaxisItem listTaxisItem = new ListTaxisItem(null);
        LoadTaxiDepotItem loadTaxiDepotItem = new LoadTaxiDepotItem(null);
        LogSpamMenuItem logSpamMenuItem = new LogSpamMenuItem();
        RemoveTaxiDepotItem removeTaxiDepotItem = new RemoveTaxiDepotItem(null);
        RemoveTaxiItem removeTaxiItem = new RemoveTaxiItem(null);
        SaveTaxiDepotItem saveTaxiDepotItem = new SaveTaxiDepotItem(null);
        TaxiBySpeedItem taxiBySpeedItem = new TaxiBySpeedItem(null);

        assertEquals("addTaxi", addTaxiItem.getCommand());
        assertEquals("createTaxiDepot", createTaxiDepotItem.getCommand());
        assertEquals("exit", exitMenuItem.getCommand());
        assertEquals("getTaxiDepotCost", getTaxiDepotCostItem.getCommand());
        assertEquals("help", helpMenuItem.getCommand());
        assertEquals("info", infoMenuItem.getCommand());
        assertEquals("listAvailableTaxis", listAvailableTaxisItem.getCommand());
        assertEquals("listByFuelConsumption", listByFuelConsumptionItem.getCommand());
        assertEquals("listSaves", listSavesItem.getCommand());
        assertEquals("listTaxiDepots", listTaxiDepotsItem.getCommand());
        assertEquals("listTaxis", listTaxisItem.getCommand());
        assertEquals("loadTaxiDepot", loadTaxiDepotItem.getCommand());
        assertEquals("logSpam", logSpamMenuItem.getCommand());
        assertEquals("removeTaxiDepot", removeTaxiDepotItem.getCommand());
        assertEquals("removeTaxi", removeTaxiItem.getCommand());
        assertEquals("saveTaxiDepot", saveTaxiDepotItem.getCommand());
        assertEquals("taxiBySpeed", taxiBySpeedItem.getCommand());
    }

    @Test
    public void getDescription() {
        AddTaxiItem addTaxiItem = new AddTaxiItem(null , null);
        CreateTaxiDepotItem createTaxiDepotItem = new CreateTaxiDepotItem(null);
        ExitMenuItem exitMenuItem = new ExitMenuItem();
        GetTaxiDepotCostItem getTaxiDepotCostItem = new GetTaxiDepotCostItem(null);
        HelpMenuItem helpMenuItem = new HelpMenuItem(null);
        InfoMenuItem infoMenuItem = new InfoMenuItem();
        ListAvailableTaxisItem listAvailableTaxisItem = new ListAvailableTaxisItem(null);
        ListByFuelConsumptionItem listByFuelConsumptionItem = new ListByFuelConsumptionItem(null);
        ListSavesItem listSavesItem = new ListSavesItem();
        ListTaxiDepotsItem listTaxiDepotsItem = new ListTaxiDepotsItem(null);
        ListTaxisItem listTaxisItem = new ListTaxisItem(null);
        LoadTaxiDepotItem loadTaxiDepotItem = new LoadTaxiDepotItem(null);
        LogSpamMenuItem logSpamMenuItem = new LogSpamMenuItem();
        RemoveTaxiDepotItem removeTaxiDepotItem = new RemoveTaxiDepotItem(null);
        RemoveTaxiItem removeTaxiItem = new RemoveTaxiItem(null);
        SaveTaxiDepotItem saveTaxiDepotItem = new SaveTaxiDepotItem(null);
        TaxiBySpeedItem taxiBySpeedItem = new TaxiBySpeedItem(null);

        assertEquals("Adds taxi to the depot", addTaxiItem.getDescription());
        assertEquals("Create a new taxi depot", createTaxiDepotItem.getDescription());
        assertEquals("Exit the application", exitMenuItem.getDescription());
        assertEquals("Get the cost of all taxis in the depot", getTaxiDepotCostItem.getDescription());
        assertEquals("Prints help information", helpMenuItem.getDescription());
        assertEquals("Show information about the application", infoMenuItem.getDescription());
        assertEquals("List all available taxis", listAvailableTaxisItem.getDescription());
        assertEquals("List all taxis sorted by fuel consumption", listByFuelConsumptionItem.getDescription());
        assertEquals("List all saved taxi depots", listSavesItem.getDescription());
        assertEquals("List all taxi depots", listTaxiDepotsItem.getDescription());
        assertEquals("List all taxis in the depot", listTaxisItem.getDescription());
        assertEquals("Load taxi depot from file", loadTaxiDepotItem.getDescription());
        assertEquals("Prints a lot of log messages", logSpamMenuItem.getDescription());
        assertEquals("Remove a taxi depot", removeTaxiDepotItem.getDescription());
        assertEquals("Removes taxi from the depot", removeTaxiItem.getDescription());
        assertEquals("Save taxi depot to file", saveTaxiDepotItem.getDescription());
        assertEquals("Find taxi by speed", taxiBySpeedItem.getDescription());
    }
}