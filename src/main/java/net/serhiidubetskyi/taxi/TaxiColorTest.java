package net.serhiidubetskyi.taxi;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiColorTest {

    @Test
    public void values() {
        assertEquals(13, TaxiColor.values().length);
    }

    @Test
    public void valueOf() {
        assertEquals(TaxiColor.White, TaxiColor.valueOf("White"));
    }
}