package net.serhiidubetskyi.taxi.taxis;

import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiColor;

import java.util.Random;

public class ComfortTaxi extends Taxi {
    public ComfortTaxi() {
        super("ComfortTaxi", "", "", 0, 0, 0, 4, 0);
    }

    @Override
    public void randParams(Random random) {
        super.randParams(random);
        this.price = 15000 + random.nextInt(10000);
        this.speed = 120 + random.nextInt(50);
        this.fuelConsumption = 7 + random.nextInt(5);
        this.fare = 15 + random.nextInt(12);
    }

    @Override
    public void setName(String name) {
        this.name = this.getClass().getSimpleName() + "_" + name;
    }
}
