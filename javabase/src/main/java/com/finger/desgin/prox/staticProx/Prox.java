package com.finger.desgin.prox.staticProx;

/**
 * 代理类
 */
public class Prox implements Sourceable{

    private Source source;

    public Prox(){
        this.source = new Source();
    }

    /**
     * 进行代理及增强
     */
    public void method() {
        this.before();
        source.method();
        this.after();
    }

    private void before(){
        System.out.println("method before...");
    }
    private void after(){
        System.out.println("method after...");
    }
}
