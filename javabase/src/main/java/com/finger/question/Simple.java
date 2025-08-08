package com.finger.question;

import org.junit.Test;

public class Simple {

    /**
     * “==”对于基本类型，比较的是值是否相同。对于引用类型，比较的是引用是否相同。
     * equals比较的是值是否相等。
     */
    @Test
    public void areEqualByValue(){
        String a ="Hello World";
        String b =new String("Hello World");
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }

    @Test
    public void javaBaseType(){
        byte a=10,b= 10;
        short c=10;
        int d=10;
        long e=10;
        float f=10;
        double g=10;
        boolean h=true;
        char i='a';
        System.out.println(a==f);
    }


}
