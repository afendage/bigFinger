package com.finger.desgin.Flyweight.webSiteDemo;

public class ConcreateWebsite extends Website{

    private String name;

    public ConcreateWebsite(String name){
        this.name=name;
    }

    public void use() {
        System.out.println("网站分类："+name);
    }

}
