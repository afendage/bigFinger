package com.finger.desgin.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题：具体的明星
 */
public class ConcreateStar implements Star{

    private List<Fan> list = new ArrayList<Fan>();

    private String name;

    public ConcreateStar(String name){
        this.name = name;
    }

    public void addFan(Fan fan) {
        list.add(fan);  //添加粉丝
    }

    public void delFan(Fan fan) {
        list.remove(fan); // 拉黑粉丝
    }

    public void notify(String message) {
        for(Fan fan:list){
            fan.update(message);    //通知每个粉丝消息
        }
    }
}
