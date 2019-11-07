package com.finger.desgin.adapter;

/**
 * 使用适配器类-将Source 类方法扩展到 Targetable 接口
 */
public class Adapter extends Source implements Targetable{

    public void method2() {
        System.out.println("interface method2 ....");
    }
}
