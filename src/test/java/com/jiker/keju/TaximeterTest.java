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

    @Test
    public void should_charge_extra_fifty_percent_of_long_distance_fare_for_parts_over_8_kilometers_given_input_kilometers_is_10() {
        int result = new Taximeter(10).calculatePrice();

        assertThat(result, is(13));
    }

    @Test
    public void should_charge_extra_fifty_percent_of_long_distance_fare_for_parts_over_8_kilometers_given_input_kilometers_is_11() {
        int result = new Taximeter(11).calculatePrice();

        assertThat(result, is(14));
    }
}
