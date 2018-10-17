package com.dgraciac.stringcalculator;

class Splitter {

    private static final String DELIMITER = ",";

    String[] split(String text) {
        return text.split(DELIMITER);
    }
}
