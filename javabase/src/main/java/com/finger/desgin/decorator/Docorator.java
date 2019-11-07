package com.finger.desgin.decorator;

public class Docorator implements Sourceable {

    private Sourceable sourceable;

    public Docorator(Sourceable sourceable){
        this.sourceable = sourceable;
    }

    public void method() {
        System.out.println("method before");
        sourceable.method();
        System.out.println("method after");
    }

}
