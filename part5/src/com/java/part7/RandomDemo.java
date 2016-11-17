package com.java.part7;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Jax on 2016/11/17.
 */
public class RandomDemo {

    /**
     * 伪随机数，Random和ThreadLocalRandom（与多线程有关）
     */
    @Test
    public void test() {
        Random random = new Random();
        byte[] nums = new byte[10];
        random.nextBytes(nums);
        for (byte b:
             nums) {
            System.out.println(b);
        }
    }
}
