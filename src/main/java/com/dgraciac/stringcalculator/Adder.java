package com.dgraciac.stringcalculator;

import java.util.Arrays;

public class Adder {
    public int add(Integer[] numbers) {
        return Arrays.stream(numbers).reduce(0, Integer::sum);
    }
}
