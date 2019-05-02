package com.gao.commonProxy;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class DogProxy implements Animal {
    private InvocationHandler handler;

    public DogProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void eat(String food) {
        try {
            Method method = Animal.class.getMethods ()[0];
            Method eat = Animal.class.getMethod ("eat", method.getParameterTypes ());
            handler.Invoke (this, eat, food);
        } catch (Exception e) {
            e.printStackTrace ();
        }


    }

    @Override
    public void play() {
        try {
            Method[] methods = Animal.class.getMethods ();
            String name = null;
            Method methd = null;
            for (Method method : methods) {
                name = method.getName ();
                if ("play".equals (name)) {
                    methd = method;
                    break;
                }
            }
            Class<?>[] parameterTypes = methd.getParameterTypes ();
            Method eat = Animal.class.getMethod ("play", parameterTypes);
            handler.Invoke (this, eat);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog ();
        TimeHanlder timeHanlder = new TimeHanlder (dog);
        DogProxy dogProxy = new DogProxy (timeHanlder);
        dogProxy.eat ("骨头");
        TimeUnit.SECONDS.sleep (2);
        dogProxy.play ();

    }


}