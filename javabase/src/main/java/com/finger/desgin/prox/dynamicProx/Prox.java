package com.finger.desgin.prox.dynamicProx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 */
public class Prox<T> implements InvocationHandler {

    private final T target;

    public Prox(T target) {
        this.target= target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method before...");
        Object result = method.invoke(target,args);
        System.out.println("method before...");
        return result;
    }
}
