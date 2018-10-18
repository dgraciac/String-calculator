package com.dgraciac.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @Test
    public void produce_sum_when_multiple_numbers_with_new_lines_are_provided() {
        assertThat(stringCalculator.add("1\n2")).isEqualTo(3);
        assertThat(stringCalculator.add("1\n2,3")).isEqualTo(6);
        assertThat(stringCalculator.add("1\n2,3\n4,5")).isEqualTo(15);
    }

    @Test
    public void produce_sum_when_multiple_numbers_with_a_custom_delimiter_is_provided() {
        assertThat(stringCalculator.add("//;\n1;2")).isEqualTo(3);
        assertThat(stringCalculator.add("//\\\n1\\2")).isEqualTo(3);
        assertThat(stringCalculator.add("//*\n1*2")).isEqualTo(3);
    }

    @Test
    public void throw_an_exception_when_there_are_negative_numbers() {
        assertThatExceptionOfType(NegativeIntegersNotAllowedException.class)
                .isThrownBy(() -> stringCalculator.add("-1"));
        assertThatExceptionOfType(NegativeIntegersNotAllowedException.class)
                .isThrownBy(() -> stringCalculator.add("-2"));
    }

    @Test
    public void throw_an_exception_with_the_expected_message() {
        Throwable throwable = catchThrowable(()-> stringCalculator.add("-1"));
        Throwable throwableWithThreeNumbers = catchThrowable(() -> stringCalculator.add("-1\n3\n-2"));
        assertThat(throwable).hasMessage("Negatives not allowed:-1");
        assertThat(throwableWithThreeNumbers).hasMessage("Negatives not allowed:-1,-2");
    }

    @Test
    public void produce_sum_ignoring_numbers_bigger_than_thousand_for_any_provided_numbers() {
        assertThat(stringCalculator.add("1002")).isEqualTo(0);
        assertThat(stringCalculator.add("//;\n1;3;1002;4")).isEqualTo(8);
    }

    @Test
    public void produce_sum_when_has_arbitrary_length_delimiter() {
        assertThat(stringCalculator.add("//[***]\n1***2***3")).isEqualTo(6);
        assertThat(stringCalculator.add("//[]\n123")).isEqualTo(6);
        assertThat(stringCalculator.add("//[g]\n1g2g3")).isEqualTo(6);
    }

    @Test
    public void produce_sum_when_multiple_delimiters() {
        assertThat(stringCalculator.add("//[&][%]\n1&2%3")).isEqualTo(6);
        assertThat(stringCalculator.add("//[&][%][/]\n1&2%3/0")).isEqualTo(6);
        assertThat(stringCalculator.add("//[&&][%%%][////]\n1&&2%%%3////0")).isEqualTo(6);
    }
}
