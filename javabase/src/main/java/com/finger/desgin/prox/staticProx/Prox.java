package com.finger.desgin.prox.staticProx;

public class Prox implements Sourceable{

    private Source source;

    public Prox(){
        this.source = new Source();
    }

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
