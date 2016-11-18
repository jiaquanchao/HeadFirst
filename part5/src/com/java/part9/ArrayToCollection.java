package com.java.part9;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jax on 2016/11/18.
 */
public class ArrayToCollection {

    public <T> void trans(T[] t, Collection<T> c) {
        for (T tin :
                t) {
            c.add(tin);
        }

        for(T tin:
                c) {
            System.out.println(tin);
        }
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[5];
        Collection<Integer> integers = new ArrayList<>();
        try {
            ArrayToCollection atc = new ArrayToCollection();
            atc.trans(ints, integers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
