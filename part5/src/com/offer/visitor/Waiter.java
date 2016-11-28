package com.offer.visitor;

/**
 * Created by Jax on 2016/11/28.
 */
public class Waiter implements IVisitor {
    @Override
    public void visitor(Banana banana) {
        System.out.println(banana.name+" : "+banana.price);
    }

    @Override
    public void visitor(Apple apple) {
        System.out.println(apple.name+" : "+apple.price);
    }

}
