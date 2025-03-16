package com.finger.desgin.observer;

import org.junit.Test;

public class ObserverTest {


    @Test
    public void observerTest(){
        // 第一步：有一个明显
        Star star = new ConcreateStar("刘德华");
        // 第二步：有很多粉丝
        Fan fan1 = new ConcreateFan("张三");
        Fan fan2 = new ConcreateFan("李四");
        Fan fan3 = new ConcreateFan("王五");
        // 第三步：拉关注
        star.addFan(fan1);
        star.addFan(fan2);
        star.addFan(fan3);
        // 第四步：发布动态
        star.notify("我要发布新专辑了！！！");
    }
}
