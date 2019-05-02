package com.gao;

public class Son extends Father {
    private int i = test ();
    private static int j = method ();

    static {
        System.out.println ("(6)");
    }

    Son() {
        System.out.println ("(7)");
    }

    {
        System.out.println ("(8)");
    }

    private int test() {
        System.out.println ("(9)");
        return 1;
    }

    private static int method() {
        System.out.println ("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son ();


    }

}
