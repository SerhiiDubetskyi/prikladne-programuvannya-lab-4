package net.serhiidubetskyi.taxi;

import java.io.Serializable;
import java.util.Random;

public class Taxi implements Serializable {
    protected String name;
    private String number;
    private String color;
    protected int price;
    protected int speed;
    protected int fuelConsumption;
    private int passengersMax;
    protected int fare;

    public Taxi(String name, String number, String color, int price, int speed, int fuelConsumption, int passengersMax, int fare) {
        this.name = name;
        this.number = number;
        this.color = color;
        this.price = price;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
        this.passengersMax = passengersMax;
        this.fare = fare;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public float getSpeed() {
        return speed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPassengersMax() {
        return passengersMax;
    }

    public int getFare() {
        return fare;
    }

    public void setName(String name) {
        this.name = this.getClass().getSimpleName() + "_" + name;
    }

    public void randParams(Random random) {
        this.number = String.format("AA%04dAA", random.nextInt(9999));
        this.color = TaxiColor.values()[random.nextInt(TaxiColor.values().length)].toString();
    }

    @Override
    public String toString() {
        return name + " (" + number + ") is "
                + color + ". It costs " + price + " dollars, has a maximum speed of "
                + speed + " km/h, consumes " + fuelConsumption + " liters of fuel per 100 km, can carry "
                + passengersMax + " passengers, and the fare is " + fare + " dollars.";
    }
}
