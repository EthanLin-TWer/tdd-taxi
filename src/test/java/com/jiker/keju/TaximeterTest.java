package com.jiker.keju;

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
    public void should_charge_extra_fifty_percent_of_long_distance_fare_for_parts_over_8_kilometers() {
        int result = new Taximeter(11).calculatePrice();

        assertThat(result, is(14));
    }

    @Test
    public void should_charge_0_point_25_chy_for_every_minutes_waiting_for_traffic() {
        int result = new Taximeter(2, 3).calculatePrice();

        assertThat(result, is(7));
    }

    @Test
    public void should_parse_test_input_and_give_result() {
        String result = TaximeterPrinter.process("1公里,等待0分钟");

        assertThat(result, is("收费6元"));
    }

    @Test
    public void should_parse_multiple_lines_of_test_input_and_give_result() {
        String result = TaximeterPrinter.process("1公里,等待0分钟" + "\n" + "3公里,等待0分钟\n" + "10公里,等待0分钟\n" + "2公里,等待3分钟");

        assertThat(result, is("收费6元\n收费7元\n收费13元\n收费7元"));
    }
}
