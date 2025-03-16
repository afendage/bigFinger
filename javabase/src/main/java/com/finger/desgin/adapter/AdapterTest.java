package com.finger.desgin.adapter;

import org.junit.Test;

public class AdapterTest {

    /**
     * 类的适配器模式
     */
    @Test
    public void classAdapterTest(){
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

    /**
     * 对象的适配器模式
     */
    @Test
    public void targetAdapterTest(){
        Source source=new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }

    /**
     * 接口的适配器模式
     */
    @Test
    public void absAdapterTest(){
        Targetable target1= new AbsExt1();
        Targetable target2 = new AbsExt2();
        target1.method1();
        target2.method2();
    }
}
