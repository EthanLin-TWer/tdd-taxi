package com.jiker.keju;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TaximeterTest {
    @Test
    public void should_return_basic_price_when_mileage_is_less_than_2_kilometers() {
        int result = new Taximeter(1).calculatePrice();

        assertThat(result, is(6));
    }

    @Test
    public void should_charge_0_point_8_chy_for_mileages_exceeds_2_kilometers_but_less_than_8_kilometers_and_do_a_rounding() {
        int result = new Taximeter(3).calculatePrice();

        assertThat(result, is(7));
    }
}
