package com.gao.commonProxy;

import java.lang.reflect.InvocationTargetException;

public class CommonProxyTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Dog dog = new Dog ();
        String food = "骨头";
        InvocationHandler timeHanlder = new TimeHanlder (dog);
        Animal o = (Animal) CommonProxy.newProxyInstance (Animal.class, timeHanlder);
        o.eat (food);

    }
}
