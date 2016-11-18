package com.java.part9;

/**
 * Created by Jax on 2016/11/18.
 */
public class Main {

    public static void main(String[] args) throws Exception{

        Float f;
        f = 1.22f;
        f += 1;
//        Class apple = Class.forName("com.java.part9.A");
        A a = new A("44");
        System.out.println(a.getT());
        System.out.println(f);

    }
}
