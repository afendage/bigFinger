package com.finger.desgin.prox;

import com.finger.desgin.prox.dynamicProx.Personal;
import com.finger.desgin.prox.dynamicProx.Prox;
import com.finger.desgin.prox.dynamicProx.Student;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class PorxTest {
    @Test
    public  void T1(){
        Personal personal = new Student();
        Personal personalProx= (Personal) Proxy.newProxyInstance(
                personal.getClass().getClassLoader(),
                personal.getClass().getInterfaces(),
                new Prox<Personal>(personal)
                );
        personalProx.sing();
    }
}

