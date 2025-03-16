package com.finger.desgin.command;

import org.junit.Test;


public class CommandTest {


    @Test
    public void commandTest(){
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}
