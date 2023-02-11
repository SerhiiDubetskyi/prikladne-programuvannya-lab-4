package net.serhiidubetskyi.taxi;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiDepotTest {

    @Test
    public void getName() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        assertEquals("Test", taxiDepot.getName());
    }

    @Test
    public void addTaxi() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        assertTrue(taxiDepot.addTaxi(taxi));
    }

    @Test
    public void removeTaxi() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertTrue(taxiDepot.removeTaxi("Test"));
    }

    @Test
    public void getTaxis() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(1, taxiDepot.getTaxis().size());
    }

    @Test
    public void getTaxi() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(taxi, taxiDepot.getTaxi("Test"));
    }

    @Test
    public void getTaxisCount() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(1, taxiDepot.getTaxisCount());
    }

    @Test
    public void getTaxisPrice() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(0, taxiDepot.getTaxisPrice());
    }

    @Test
    public void getTaxiByNumber() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(taxi, taxiDepot.getTaxiByNumber("Test"));
    }

    @Test
    public void getTaxisBySpeed() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 0, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(1, taxiDepot.getTaxisBySpeed(0, 0).size());
    }

    @Test
    public void getTaxisFuelConsumption() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 10, 0, 0);
        taxiDepot.addTaxi(taxi);
        assertEquals(10, taxiDepot.getTaxisFuelConsumption());
    }

    @Test
    public void testSaveToFile() {
        TaxiDepot taxiDepot = new TaxiDepot("Test");
        Taxi taxi = new Taxi("Test", "Test", "Test", 0, 0, 10, 0, 0);
        taxiDepot.addTaxi(taxi);
        taxiDepot.saveToFile("Test");
        TaxiDepot taxiDepot1 = TaxiDepot.loadFromFile("Test");

        assertEquals(taxiDepot.getTaxisCount(), taxiDepot1.getTaxisCount());
    }
}