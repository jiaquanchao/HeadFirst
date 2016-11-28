package com.java.part7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jax on 2016/11/25.
 */
public class EnumDemo {

    enum Season{
        aa,bb,cc,dd,ee,ff,gg;
    }

    @Test
    public void test() {
        EnumSet es1 = EnumSet.allOf(Season.class);
        Iterator ei = es1.iterator();
        System.out.println(ei.next());
        System.out.println(ei.next());

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Iterator li = list.iterator();
        System.out.println(li.next());
        System.out.println(li.next());
    }
}
