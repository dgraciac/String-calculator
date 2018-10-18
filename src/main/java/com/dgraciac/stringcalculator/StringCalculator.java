package com.dgraciac.stringcalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        Splitter splitter = new Splitter();
        NumberChecker numberChecker = new NumberChecker();
        String[] splitNumbersAsText = splitter.split(numbers);

        splitNumbersAsText = Arrays.stream(splitNumbersAsText)
                .filter(number->!number.isEmpty())
                .toArray(String[]::new);

        IntegerParser integerParser = new IntegerParser();
        Integer[] integers = Arrays.stream(splitNumbersAsText)
                .map(integerParser::parse)
                .filter(numberChecker::smallerOrEqualThan1000)
                .toArray(Integer[]::new);

        String negatives = Arrays.stream(integers)
                .filter(number-> number < 0)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        if(!negatives.isEmpty()){
            throw new NegativeIntegersNotAllowedException("Negatives not allowed:" + negatives);
        }

        Adder adder = new Adder();
        return adder.add(integers);
    }
}
