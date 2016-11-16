package com.java.part7;

import org.junit.Test;

/**
 * Created by Jax on 2016/11/16.
 */
public class StringDemo {

    StringBuilder sb = new StringBuilder();

    @Test
    public void test() {
        sb = sb.append(String.valueOf(666));
        System.out.println("内容： " + sb +"\n"+
                            "长度： "+ sb.length()+
                            "\n容量： " + sb.capacity());

        sb.append(" youre the best!");
        System.out.println("内容： " + sb +"\n"+
                "长度： "+ sb.length()+
                "\n容量： " + sb.capacity());

        sb.replace(3, 4, ",");
        sb.append(" youre the best!");
        System.out.println("内容： " + sb +"\n"+
                "长度： "+ sb.length()+
                "\n容量： " + sb.capacity());

        sb.setLength(10);
        System.out.println("内容： " + sb +"\n"+
                "长度： "+ sb.length()+
                "\n容量： " + sb.capacity());

        sb.setCharAt(4, 'z');
        System.out.println("内容： " + sb +"\n"+
                "长度： "+ sb.length()+
                "\n容量： " + sb.capacity());

        sb.delete(3, 4);
        System.out.println("内容： " + sb +"\n"+
                "长度： "+ sb.length()+
                "\n容量： " + sb.capacity());
    }

}
