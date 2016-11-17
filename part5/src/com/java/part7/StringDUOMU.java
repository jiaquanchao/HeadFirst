package com.java.part7;

import org.junit.Test;

/**
 * Created by Jax on 2016/11/17.
 */
public class StringDUOMU {

    @Test
    public void test() {

        int i = 0;
        i=1;
        String module = i==1 ? "----- M1 -----\n" :
                i==2 ? "----- M2 -----\n" :
                        i==3 ? "----- M3 -----\n" :
                                "----- M4 -----\n";

        System.out.println(module);
    }
}
