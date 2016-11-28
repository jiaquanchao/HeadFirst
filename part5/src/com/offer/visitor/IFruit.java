package com.offer.visitor;

/**
 * Created by Jax on 2016/11/28.
 */
public interface IFruit {
    float price = 0;
    String name = null;

    public abstract void accept(IVisitor iVisitor);
}
