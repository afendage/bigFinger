package com.finger.desgin.facede;

import org.junit.Test;

public class FacedeTest {

    @Test
    public void facedeStartTest(){
        Computer computer = new Computer();
        computer.startup();
    }

    @Test
    public void facedeShutdownTest(){
        Computer computer = new Computer();
        computer.shutdown();
    }
}
