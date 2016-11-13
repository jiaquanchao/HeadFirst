package com.java.part6;

import org.junit.Test;

/**
 * Created by Jax on 2016/11/12.
 */
public class StringEquals {

    String s1 = "爱我中华";
    String s2 = "爱我";
    String s3 = "中华";

    String s4 = null;
    String s5 = null;

    @Test
    public void test() {
        s4 = s2 + s3;
        s5 = s2 + s3;
        System.out.println("s1 == s2 + s3 --> " + (s4 == s1));
        System.out.println("s4 == s5 --> " + (s4 == s5));
        System.out.println("s1 == s5 --> " + (s5 == s1));


        String s11 = new String("爱我中华").intern();
        System.out.println("s1 == s11 --> "+ (s1 == s11));

        StringEquals s = new StringEquals();
        System.out.println(s.getClass()+ " 这是s的class\n" + (s.getClass() == StringEquals.class));




    }
}
