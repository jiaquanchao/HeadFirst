package com.offer.visitor;

/**
 * Created by Jax on 2016/11/28.
 */
public class Apple implements IFruit{

    float price;
    String name;

    public Apple(float price, String name) {
        this.price = price;
        this.name = name;
    }
    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visitor(this);
    }
}
