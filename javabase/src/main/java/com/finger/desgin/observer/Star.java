package com.finger.desgin.observer;

/**
 * 定义抽象主题(Subject)：抽象明星
 */
public interface Star {

    // 增加粉丝
    public void addFan(Fan fan);

    // 拉黑粉丝
    public void delFan(Fan fan);

    // 告知粉丝我的动态
    public void notify(String message);

}
