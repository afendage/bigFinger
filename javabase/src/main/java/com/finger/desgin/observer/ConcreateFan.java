package com.finger.desgin.observer;

/**
 * 具体的观察者（concreteObserver）：具体的粉丝
 */
public class ConcreateFan implements Fan{

    private String name;

    public ConcreateFan(String name){
        this.name= name;
    }

    public void update(String message) {
        System.out.println(name +" 收到了，最新更新消息："+message);
    }
}
