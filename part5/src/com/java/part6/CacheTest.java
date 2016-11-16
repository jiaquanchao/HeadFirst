package com.java.part6;

/**
 * Created by Jax on 2016/11/14.
 */
public class CacheTest {
    public static void main(String[] args) {
        CacheName cn1 = CacheName.valueOf("jax", 2360);
        CacheName cn2 = CacheName.valueOf("jax", 2360);
        CacheName cn3 = CacheName.valueOf("jax1", 2361);
        CacheName cn4 = CacheName.valueOf("jax2", 2362);


        System.out.println(cn1 == cn2);
        System.out.println("cn1 : " + cn1.getName().hashCode());
        System.out.println("cn2 : " + cn2.getName().hashCode());
        System.out.println(cn1 == cn3);
        System.out.println(cn1.hashCode()+" <-- cn1-----cn2 --> "+cn2.hashCode());
    }
}
