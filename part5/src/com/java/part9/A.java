package com.java.part9;

import org.junit.Test;

/**
 * Created by Jax on 2016/11/18.
 */
public class A extends Apple<String> {
    String s = null;
    public A(String s) {
        super(s);
        this.s = s;
    }

    @Override
    public void setT(String s) {
        super.setT(s);
    }

    @Override
    public String getT() {
        return "子类"+s;
    }

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        A a = (A) Class.forName("A").newInstance();

        a.setT("son");
        System.out.println(a.getT());
    }
}
