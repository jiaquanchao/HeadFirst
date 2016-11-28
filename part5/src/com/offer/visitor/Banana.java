package com.offer.visitor;

/**
 * Created by Jax on 2016/11/28.
 */
public class Banana implements IFruit{

    float price;
    String name;

    public Banana(float price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visitor(this);
    }
}
