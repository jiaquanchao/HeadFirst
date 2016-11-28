package com.offer.visitor;

/**
 * Created by Jax on 2016/11/28.
 */
public interface IVisitor {
    void visitor(Banana banana);

    public void visitor(Apple apple);
}
