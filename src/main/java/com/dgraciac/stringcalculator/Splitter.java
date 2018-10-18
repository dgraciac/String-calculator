package com.dgraciac.stringcalculator;

class Splitter {
    private static final String DOUBLE_SLASH_AND_BRACKET = "//[";
    private static final String DOUBLE_SLASH = "//";
    private static final String UNIQUE_DELIMITER = "@";

    String[] split(String text) {
        String numbers = text;
        numbers = numbers.replace(",", UNIQUE_DELIMITER);
        if (text.startsWith(DOUBLE_SLASH_AND_BRACKET)) {
            int endOfDelimitersIndex = numbers.indexOf("\n");
            String delimiters = numbers.substring(2,endOfDelimitersIndex);
            String[] splitDelimiters = delimiters.substring(1,delimiters.length()-1).split("]\\[");
            numbers = text.substring(endOfDelimitersIndex + 1);
            for(String delimiter : splitDelimiters){
                numbers = numbers.replace(delimiter, UNIQUE_DELIMITER);
            }
        } else if (text.startsWith(DOUBLE_SLASH)) {
            String delimiter = text.substring(DOUBLE_SLASH.length(), DOUBLE_SLASH.length() + 1);
            numbers = text.substring(4);
            numbers = numbers.replace(delimiter, UNIQUE_DELIMITER);
        }
        numbers = numbers.replace("\n", UNIQUE_DELIMITER);
        return numbers.split(UNIQUE_DELIMITER);
    }
}

