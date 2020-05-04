package com.finger.demo;

import org.junit.Test;

public class JucTest {

    @Test
    public void pp(){
        int i = 10 ;
        i = i++;
        System.out.println(i);
    }

    @Test
    public void pp1(){
        int i = 10 ;
        i = ++i;
        System.out.println(i);
    }
}
