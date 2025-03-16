package com.finger.desgin.prox.staticProx;

/**
 * 被代理对象具体实现
 */
public class Source implements Sourceable{

    public void method() {
        System.out.println("method run.....");
    }
}
