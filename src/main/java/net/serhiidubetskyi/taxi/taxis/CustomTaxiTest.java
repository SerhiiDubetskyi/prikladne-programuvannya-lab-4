package net.serhiidubetskyi.taxi.taxis;

import java.util.Random;

import static org.junit.Assert.*;

public class CustomTaxiTest {
        @org.junit.Test
        public void randParams() {
            BusinessTaxi businessTaxi = new BusinessTaxi();
            ComfortTaxi comfortTaxi = new ComfortTaxi();
            EconomyTaxi economyTaxi = new EconomyTaxi();
            Random random = new Random(5);

            businessTaxi.randParams(random);
            comfortTaxi.randParams(random);
            economyTaxi.randParams(random);

            assertNotEquals(0, businessTaxi.getPrice());
            assertNotEquals(0, comfortTaxi.getSpeed());
            assertNotEquals(0, economyTaxi.getFuelConsumption());
        }

        @org.junit.Test
        public void setName() {
            BusinessTaxi businessTaxi = new BusinessTaxi();
            ComfortTaxi comfortTaxi = new ComfortTaxi();
            EconomyTaxi economyTaxi = new EconomyTaxi();

            businessTaxi.setName("test");
            comfortTaxi.setName("test");
            economyTaxi.setName("test");

            assertEquals("BusinessTaxi_test", businessTaxi.getName());
            assertEquals("ComfortTaxi_test", comfortTaxi.getName());
            assertEquals("EconomyTaxi_test", economyTaxi.getName());
        }
}