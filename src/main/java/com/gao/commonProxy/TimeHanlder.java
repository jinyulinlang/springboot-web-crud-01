package com.gao.commonProxy;

import java.lang.reflect.Method;

public class TimeHanlder implements InvocationHandler {
    private Object target;

    public TimeHanlder(Object target) {
        this.target = target;

    }

    @Override
    public void Invoke(Object o, Method method, Object... args) {
        try {
            long startTime = System.currentTimeMillis ();
            System.out.println ("小狗开始" + method.getName () + "东西-------");
            method.invoke (target, args);
            System.out.println ("小狗" + method.getName () + "完东西-------\t 耗时:" + (System.currentTimeMillis () - startTime));
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
