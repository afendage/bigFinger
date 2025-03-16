package com.finger.desgin.decorator;

import org.junit.Test;

public class DocoratorTest {

    @Test
    public void DocoratorTest(){
        Sourceable source = new Source();
        Sourceable sourceable = new Docorator(source);
        sourceable.method();
    }
}
