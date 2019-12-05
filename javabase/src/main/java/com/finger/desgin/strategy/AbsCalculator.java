package com.finger.desgin.strategy;

/**
 * 辅助类
 */
public abstract class AbsCalculator {

    public int[] split(String exp,String opt){
        String arr[] = exp.split(opt);
        int arrInt[] = new int[2];
        arrInt[0] = Integer.parseInt(arr[0]);
        arrInt[1] = Integer.parseInt(arr[1]);
        return arrInt;
    }

}
