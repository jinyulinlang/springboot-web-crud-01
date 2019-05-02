package com.gao.proxy;

public class CarTimeProxy implements MoveAble {
    private MoveAble moveAble;

    public CarTimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis ();
        System.out.println ("汽车开始行行驶");
        moveAble.move ();
        long endTime = System.currentTimeMillis ();
        System.out.println ("汽车结束行驶-----，汽车行驶时间:" + (endTime - startTime) + "毫秒！");

    }
}
