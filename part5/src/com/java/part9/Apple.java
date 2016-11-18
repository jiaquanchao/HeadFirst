package com.java.part9;

/**
 * Created by Jax on 2016/11/18.
 */
public class Apple<T> {

    T t;
    public Apple() {

    }
    public Apple(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}
