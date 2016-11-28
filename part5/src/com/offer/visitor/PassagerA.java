package com.offer.visitor;

/**
 * Created by Jax on 2016/11/28.
 */
public class PassagerA implements IVisitor {
    @Override
    public void visitor(Banana banana) {

        //// TODO: 2016/11/28  
    }

    @Override
    public void visitor(Apple apple) {
        System.out.println(apple.name+" : "+apple.price);
    }
}
