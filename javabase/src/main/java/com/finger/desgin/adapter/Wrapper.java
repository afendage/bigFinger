package com.finger.desgin.adapter;

/**
 * 对象的适配器模式- 持有Source类的实例，以达到解决兼容性的问题
 */
public class Wrapper implements Targetable{

    private Source source;

    public Wrapper(Source source){
        this.source= source;
    }

    public void method1() {
        source.method1();
    }

    public void method2() {
        System.out.println("interface method2 ....");
    }
}
