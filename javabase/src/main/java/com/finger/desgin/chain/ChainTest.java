package com.finger.desgin.chain;

import org.junit.Test;

public class ChainTest {


    @Test
    public void chainTest(){
        Handler handler1 = new MyHandler("h1");
        Handler handler2 = new MyHandler("h2");
        Handler handler3 = new MyHandler("h3");

        ((MyHandler) handler1).setHandler(handler2);
        ((MyHandler) handler2).setHandler(handler3);

        handler1.operator();
    }


}
