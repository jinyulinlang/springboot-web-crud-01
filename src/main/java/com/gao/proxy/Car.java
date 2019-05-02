package com.gao.proxy;

import java.util.concurrent.TimeUnit;

public class Car implements MoveAble {
    @Override
    public void move() {
        System.out.println ("汽车处于行驶状态");
        try {
            TimeUnit.SECONDS.sleep (1);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
