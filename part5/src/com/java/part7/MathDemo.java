package com.java.part7;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Jax on 2016/11/16.
 */
public class MathDemo {
    int a = Math.abs(-3);

    /**
     * 三角函数，开方，指数，取整，取模之类的的都是Math类里的，不作赘述
     * 在这里顺便说一下 BigDecimal , 这个是精度很高的浮点数类型
     *
     * 在使用BigDecimal时，首选基于String的构造器，其次是valueOf来创建
     */
    @Test
    public void test() {
        System.out.println(a);

        BigDecimal bString = new BigDecimal("0.1");
        System.out.println("基于String的BigDecimal： "+bString);

        BigDecimal bValue = BigDecimal.valueOf(0.1);
        System.out.println("基于valueOf的BigDecimal： "+bValue);

        BigDecimal bNormal = new BigDecimal(0.1);
//        bNormal.doubleValue();
        System.out.println("Normal: "+ bNormal);
    }
}
