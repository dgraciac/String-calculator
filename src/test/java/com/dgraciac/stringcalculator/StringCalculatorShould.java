package com.dgraciac.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {
    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void produce_0_when_empty_string() {
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void produce_number_when_only_one_number_is_provided() {
        assertThat(stringCalculator.add("1")).isEqualTo(1);
        assertThat(stringCalculator.add("2")).isEqualTo(2);
    }

    @Test
    public void produce_sum_when_multiple_numbers_are_provided() {
        assertThat(stringCalculator.add("1,2")).isEqualTo(3);
        assertThat(stringCalculator.add("3,4")).isEqualTo(7);
        assertThat(stringCalculator.add("1,2,3")).isEqualTo(6);
    }
}
