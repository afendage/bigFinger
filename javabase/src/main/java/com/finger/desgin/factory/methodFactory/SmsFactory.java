package com.finger.desgin.factory.methodFactory;

public class SmsFactory implements Provider{

    public Sender produce() {
        return new SmsSender();
    }
}
