package com.dgraciac.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerParserShould {
    @Test
    public void produce_an_integer_when_integer_as_string_is_passed() {
        IntegerParser integerParser = new IntegerParser();

        assertThat(integerParser.parse("0")).isEqualTo(0);
        assertThat(integerParser.parse("1")).isEqualTo(1);
        assertThat(integerParser.parse("-1")).isEqualTo(-1);
    }
}
