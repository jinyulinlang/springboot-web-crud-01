package com.gao;

import org.junit.Test;

public class Exam {
    @Test
    public void test1() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println ("i=" + i);
        System.out.println ("j=" + j);
        System.out.println ("k=" + k);
    }
}
