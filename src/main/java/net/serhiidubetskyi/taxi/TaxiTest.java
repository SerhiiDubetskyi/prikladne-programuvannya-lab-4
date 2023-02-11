package net.serhiidubetskyi.taxi;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TaxiTest {

    @Test
    public void getName() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals("name", taxi.getName());
    }

    @Test
    public void getNumber() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals("number", taxi.getNumber());
    }

    @Test
    public void getColor() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals("color", taxi.getColor());
    }

    @Test
    public void getPrice() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals(1, taxi.getPrice());
    }

    @Test
    public void getSpeed() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals(1, taxi.getSpeed(), 0);
    }

    @Test
    public void getFuelConsumption() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals(1, taxi.getFuelConsumption());
    }

    @Test
    public void getPassengersMax() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals(1, taxi.getPassengersMax());
    }

    @Test
    public void getFare() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals(1, taxi.getFare());
    }

    @Test
    public void setName() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        taxi.setName("newName");
        assertEquals("Taxi_newName", taxi.getName());
    }

    @Test
    public void randParams() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        Random random = new Random(5);
        taxi.randParams(random);
        assertNotEquals("number", taxi.getNumber());
        assertNotEquals("color", taxi.getColor());
    }

    @Test
    public void testToString() {
        Taxi taxi = new Taxi("name", "number", "color", 1, 1, 1, 1, 1);
        assertEquals("name (number) is color. It costs 1 dollars, has a maximum speed of 1 km/h, " +
                "consumes 1 liters of fuel per 100 km, can carry 1 passengers, and the fare is 1 dollars.",
                taxi.toString()
        );
    }
}