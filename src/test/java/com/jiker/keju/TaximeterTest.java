package com.jiker.keju;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TaximeterTest {
    @Test
    public void should_return_basic_price_when_mileage_is_less_than_2_kilometers() {
        double result = new Taximeter(2).calculatePrice();

        assertThat(result, is(6.0));
    }
}
