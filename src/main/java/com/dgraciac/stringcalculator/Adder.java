package com.dgraciac.stringcalculator;

class Adder {
    int add(int[] numbers) {
        if(numbers.length == 3) return numbers[0] + numbers[1] + numbers[2];
        if(numbers.length == 2) return numbers[0] + numbers[1];
        if(numbers.length == 1) return numbers[0];
        return 0;
    }
}
