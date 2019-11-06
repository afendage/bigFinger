package com.finger.desgin.factory.methodFactory;

public class EmailFactory implements Provider{

    public Sender produce() {
        return new EmailSender();
    }
}
