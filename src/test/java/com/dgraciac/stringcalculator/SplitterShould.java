package com.dgraciac.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterShould {

    private Splitter splitter;

    @Before
    public void setUp() {
        splitter = new Splitter();
    }

    @Test
    public void produce_an_array_with_an_empty_string_when_empty_string_is_passed() {
        assertThat(splitter.split("")).containsExactly("");
    }

    @Test
    public void produce_an_array_with_one_number_when_only_one_number_is_passed() {
        assertThat(splitter.split("1")).containsExactly("1");
        assertThat(splitter.split("2")).containsExactly("2");
        assertThat(splitter.split("3")).containsExactly("3");
    }

    @Test
    public void produce_an_array_with_n_numbers_when_n_numbers_are_passed() {
        assertThat(splitter.split("1,2")).containsExactly("1", "2");
        assertThat(splitter.split("1,2,3,4")).containsExactly("1", "2", "3", "4");
        assertThat(splitter.split("12,24")).containsExactly("12", "24");
    }

    @Test
    public void handle_new_lines() {
        assertThat(splitter.split("1\n2")).containsExactly("1", "2");
        assertThat(splitter.split("1\n2,3")).containsExactly("1", "2", "3");
    }

    @Test
    public void handle_any_delimiter() {
        assertThat(splitter.split("//;\n1;2")).containsExactly("1", "2");
        assertThat(splitter.split("//|\n1|3")).containsExactly("1", "3");
        assertThat(splitter.split("//*\n1*2")).containsExactly("1", "2");
        assertThat(splitter.split("//\\\n1\\2")).containsExactly("1", "2");
    }

    @Test
    public void handle_any_delimiter_of_any_length() {
        assertThat(splitter.split("//[;;]\n1;;2;;3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("//[...]\n1...2...3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("//[****]\n1****2****3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("//[\\d]\n1\\d2")).containsExactly("1", "2");
    }

    @Test
    public void handle_multiple_delimiters() {
        assertThat(splitter.split("//[&][%]\n1&2%3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("//[&][%][/]\n1&2%3/0")).containsExactly("1","2","3","0");
        assertThat(splitter.split("//[&&][%%%][////]\n1&&2%%%3////0")).containsExactly("1","2","3","0");
        assertThat(splitter.split("//[@][%]\n1@2%3")).containsExactly("1", "2", "3");
    }
}
