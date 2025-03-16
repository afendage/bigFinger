package com.finger.desgin.prototype;

import org.junit.Test;

import java.io.IOException;

public class PrototypeTest {

    /**
     * 浅复制-基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的
     */
    @Test
    public void cloneTest(){
        Personal personal = new Personal();
        personal.setAge(20);
        personal.setName("finger");
        personal.setStudent(new Student("C001","二年级"));
        try {
            Personal personal1 = personal.clone();
            System.out.println("name:"+personal1.getName() +",age:"+personal1.getAge());
            System.out.println(personal==personal1);

            // 浅复制-引用对象， 没有进行复制。而是共同指向一个对象
            System.out.println("stu.cls="+personal1.getStudent().getCls());
            System.out.println(personal.getStudent()==personal1.getStudent());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 深复制-论是基本数据类型还有引用类型，都是重新创建的。
     * 简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底
     */
    @Test
    public void deepClone(){
        Personal personal = new Personal();
        personal.setAge(20);
        personal.setName("finger");
        personal.setStudent(new Student("C001","二年级"));

        try {
            Personal personal1 = (Personal) personal.deepClone();
            System.out.println(personal.getStudent()==personal1.getStudent());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
