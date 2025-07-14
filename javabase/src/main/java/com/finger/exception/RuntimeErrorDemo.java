package com.finger.exception;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuntimeErrorDemo {

    /**
     *  OutOfMemoryError	内存不足(Java heap space)
     */
    @Test
    public void HeapOomTest(){
        List<byte[]> list = new ArrayList<>();
        while (true) {
            // 每次分配 1MB 内存，持续申请直到堆内存耗尽
            list.add(new byte[1024 * 1024]);
            System.out.println("Allocated " + list.size() + " MB");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *  StackOverflowError	无限递归导致栈溢出
     */
    @Test
    public void StackOverflowErrorTest(){
        this.recursiveCall();
    }

    public static void recursiveCall() {
        recursiveCall(); // 无限递归，栈帧不断累积
    }

    /**
     *  NoClassDefFoundError	运行时缺失类定义
     */
    @Test
    public void NoClassDefFoundErrorTest(){}

    /**
     *  UnsatisfiedLinkError	加载本地库失败
     */
    @Test
    public void UnsatisfiedLinkErrorTest(){}

}
