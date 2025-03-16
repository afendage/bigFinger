package com.finger.desgin.mediator;

import org.junit.Test;

public class MediatorTest {

    @Test
    public void mediatorTest(){
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }

}
