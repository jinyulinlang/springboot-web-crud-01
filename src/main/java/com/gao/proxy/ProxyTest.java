package com.gao.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ProxyTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
/*        CglibProxy cglibProxy = new CglibProxy ();
        Train proxy = (Train) cglibProxy.getProxy (Train.class);
        proxy.move ();*/
        MoveAble o = (MoveAble) Proxy.newProxyInstance (MoveAble.class);
        o.move ();
    }
}
