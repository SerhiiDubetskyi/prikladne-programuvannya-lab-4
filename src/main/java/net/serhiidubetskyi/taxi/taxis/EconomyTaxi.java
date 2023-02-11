package net.serhiidubetskyi.taxi.taxis;

import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiColor;

import java.util.Random;

public class EconomyTaxi extends Taxi {
    public EconomyTaxi() {
        super("EconomyTaxi", "", "", 0, 0, 0, 4, 0);
    }

    @Override
    public void randParams(Random random) {
        super.randParams(random);
        this.price = 10000 + random.nextInt(10000);
        this.speed = 100 + random.nextInt(50);
        this.fuelConsumption = 7 + random.nextInt(5);
        this.fare = 10 + random.nextInt(10);
    }

    @Override
    public void setName(String name) {
        this.name = this.getClass().getSimpleName() + "_" + name;
    }
}
