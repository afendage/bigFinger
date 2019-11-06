package com.finger.desgin.factory.methodFactory;

public class QqFactory implements Provider{

    public Sender produce() {
        return new QqSender();
    }
}
