package com.gao.commonProxy;

import java.util.concurrent.TimeUnit;

public class Dog implements Animal {
    @Override
    public void eat(String food) {
        System.out.println ("小狗正在吃" + food + "这种事物");
        try {
            TimeUnit.SECONDS.sleep (1);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public void play() {
        System.out.println ("小狗正在玩------");
        try {
            TimeUnit.SECONDS.sleep (3);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

}
