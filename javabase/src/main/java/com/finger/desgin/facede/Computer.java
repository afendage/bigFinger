package com.finger.desgin.facede;

public class Computer {

    private CPU cpu;

    private Memory memory;

    private Disk disk;

    public Computer(){
        this.cpu=new CPU();
        this.memory=new Memory();
        this.disk=new Disk();
    }

    public void startup(){
        System.out.println("computer start...");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("computer started");
    }

    public void shutdown(){
        System.out.println("computer shutdown...");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed");
    }

}
