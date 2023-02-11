package net.serhiidubetskyi.taxi.taxis;

import net.serhiidubetskyi.taxi.Taxi;
import net.serhiidubetskyi.taxi.TaxiColor;

import java.util.Random;

public class BusinessTaxi extends Taxi {
    public BusinessTaxi() {
        super("BusinessTaxi", "", "", 0, 0, 0, 4, 0);
    }

    @Override
    public void randParams(Random random) {
        super.randParams(random);
        this.price = 20000 + random.nextInt(20000);
        this.speed = 150 + random.nextInt(50);
        this.fuelConsumption = 7 + random.nextInt(5);
        this.fare = 25 + random.nextInt(15);
    }

    @Override
    public void setName(String name) {
        this.name = this.getClass().getSimpleName() + "_" + name;
    }
}
