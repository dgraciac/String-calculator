package com.dgraciac.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberCheckerShould {
    @Test
    public void determine_if_number_is_smaller_or_equal_than_thousand() {
        NumberChecker numberChecker = new NumberChecker();
        assertThat(numberChecker.smallerOrEqualThan1000(1001)).isFalse();
        assertThat(numberChecker.smallerOrEqualThan1000(766)).isTrue();
        assertThat(numberChecker.smallerOrEqualThan1000(1000)).isTrue();
    }
}
