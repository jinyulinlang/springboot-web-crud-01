package com.gao.proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer ();


    public Object getProxy(Class clazz) {
        enhancer.setSuperclass (clazz);
        enhancer.setCallback (this);
        Object o = enhancer.create ();

        return o;

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println ("日志开始-----");
        methodProxy.invokeSuper (obj, objects);
        System.out.println ("日志结束-------");
        return null;
    }

}
