package com.dgraciac.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdderShould {
    @Test
    public void produces_0_when_an_empty_array_is_passed() {
        Adder adder = new Adder();
        assertThat(adder.add(new Integer[0])).isEqualTo(0);
    }

    @Test
    public void produces_number_when_only_one_number_is_passed() {
        Adder adder = new Adder();
        assertThat(adder.add(new Integer[]{0})).isEqualTo(0);
        assertThat(adder.add(new Integer[]{1})).isEqualTo(1);
        assertThat(adder.add(new Integer[]{2})).isEqualTo(2);
    }

    @Test
    public void produces_number_when_2_numbers_are_passed() {
        Adder adder = new Adder();
        assertThat(adder.add(new Integer[]{1, 2})).isEqualTo(3);
        assertThat(adder.add(new Integer[]{2, 3})).isEqualTo(5);
        assertThat(adder.add(new Integer[]{3, 4})).isEqualTo(7);
    }

    @Test
    public void produces_number_when_n_numbers_are_passed() {
        Adder adder = new Adder();
        assertThat(adder.add(new Integer[]{1, 2, 3})).isEqualTo(6);
        assertThat(adder.add(new Integer[]{3,5,6})).isEqualTo(14);
    }
}
