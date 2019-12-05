package com.finger.desgin.strategy;

public class Multiply extends AbsCalculator implements ICalculator {

    public int calculator(String exp) {
        int[] arrInt = split(exp,"\\*");
        return arrInt[0]*arrInt[1];
    }
}
