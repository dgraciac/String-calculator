package com.dgraciac.stringcalculator;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        Splitter splitter = new Splitter();
        String[] splitNumbersAsText = splitter.split(numbers);
        int length = splitNumbersAsText.length;

        int sum = 0;
        IntegerParser integerParser = new IntegerParser();
        for (String aSplitNumbersAsText : splitNumbersAsText) {
            sum += integerParser.parse(aSplitNumbersAsText);
        }
        return sum;
    }
}
