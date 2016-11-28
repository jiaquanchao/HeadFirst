package com.offer.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jax on 2016/11/28.
 */
public class Test {

    public static void main(String[] args) {

        List<IFruit> iFruits = new ArrayList<>();
        Apple apple1 = new Apple(5.5f, "烟台苹果");
        Apple apple2 = new Apple(3.5f, "本地苹果");
        Banana banana1 = new Banana(2.2f, "海南香蕉");
        Banana banana2 = new Banana(6.2f, "黑龙江香蕉");
        PassagerA passagerA = new PassagerA();
        PassagerB passagerB = new PassagerB();
        Waiter waiter = new Waiter();
        iFruits.add(apple1);
        iFruits.add(banana1);
        iFruits.add(banana2);
        iFruits.add(apple2);
        System.out.println("++++++PassagerA++++++");
        for (IFruit i:
             iFruits) {
            i.accept(passagerA);
        }
        System.out.println("++++++PassagerB++++++");
        for (IFruit i:
             iFruits) {
            i.accept(passagerB);
        }
        System.out.println("++++++++Waiter++++++++");
        for (IFruit i:
                iFruits) {
            i.accept(waiter);
        }
    }
}
