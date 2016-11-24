package com.dataConstructure.part1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jax on 2016/11/23.
 */
public class Gcd {


    private int gcd(int big, int small) {
        System.out.println(big+" "+small);
        if (big<1||small<1) {
            System.out.println("error...");
            return -1;
        }
        if (big < small) {
            int temp = big;
            big = small;
            small = temp;
        }
        if (big%small == 0) {
            return small;
        }
        int temp = big%small;
        big = small;
        small = temp;
        return gcd(big, small);
    }

    @Test
    public void test() {

        int t = gcd(0, 26460);
        System.out.println(t);

//       int[] ints = new int[]{8,4,2};
        int[] ints = new int[5];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random()*100+1);
            System.out.println(ints[i]);
        }

        List<Integer> lists = new ArrayList<>();
        for (int i:
             ints) {
            lists.add(i);
        }

        System.out.println(lists);
        int res = lists.stream().reduce(lists.get(0), (x, y) -> gcd(x, y));
        System.out.println(res);
    }
}
