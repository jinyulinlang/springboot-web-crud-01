package com.gao;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

public class DemoTest {
    @Test
    public void testfe() {
        int a = 1, b = 1, c = 0;
        System.out.println ("斐波那契数列前20项为：");
        System.out.print (a + "\t" + b + "\t");
        //因为前面还有两个1、1 所以i<=18
        for (int i = 1; i <= 18; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print (c + "\t");
            if ((i + 2) % 5 == 0) System.out.println ();
        }
    }

    @Test
    public void feibonaqie() {
        int arr[] = new int[20];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println ("斐波那契数列的前20项如下所示：");
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0) {
                System.out.println ();
            } else {
                System.out.print (arr[i] + "\t");
            }
        }
    }

    // 使用递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return getFibo (i - 1) + getFibo (i - 2);
        }
    }

    @Test
    public void testDemo() {
        System.out.println ("斐波那契数列的前20项为：");
        for (int j = 1; j <= 20; j++) {
            System.out.print (getFibo (j) + "\t");
            if (j % 5 == 0) {
                System.out.println ();
            }
        }

    }

    @Test
    public void loopTest() {
        System.out.println (loop (8));
    }

    private int loop(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    @Test
    public void testFixedValue() throws Exception {
        Enhancer enhancer = new Enhancer ();
        enhancer.setSuperclass (SampleClass2.class);
        enhancer.setCallback ((FixedValue) () -> "Hello cglib!");
        SampleClass2 proxy = (SampleClass2) enhancer.create ();
    }

    static class SampleClass2 {

    }
}
