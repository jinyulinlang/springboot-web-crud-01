package com.gao.commonProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface InvocationHandler {
    void Invoke(Object o, Method method, Object... args) throws InvocationTargetException, IllegalAccessException;
}
