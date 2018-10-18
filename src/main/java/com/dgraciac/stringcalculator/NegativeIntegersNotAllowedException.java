package com.dgraciac.stringcalculator;

public class NegativeIntegersNotAllowedException extends RuntimeException{
    public NegativeIntegersNotAllowedException(String message) {
        super(message);
    }
}
