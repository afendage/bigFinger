package com.finger.desgin.prox.dynamicProx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Prox<T> implements InvocationHandler {

    private T target;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = method.invoke(target,args);
        return obj;
    }
}
