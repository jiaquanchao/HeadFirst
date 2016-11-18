package com.offer;

import org.junit.Test;

/**
 * Created by Jax on 2016/11/18.
 */
public class Singleton {


    /**
     * 懒汉式
     */
    public static class Singleton0{
        private static Singleton0 INSTANCE = null;
        private Singleton0() {}

        public Singleton0 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton0();
            }
            return INSTANCE;
        }

        public void say() {
            System.out.println("懒汉式，线程不安全");
        }
    }

    /**
     * 饿汉式
     */
    public static class Singleton1{
        private final static Singleton1 INSTANCE = new Singleton1();
        private Singleton1() {}
        public Singleton1 getInstance() {
            return INSTANCE;
        }

        public void say() {
            System.out.println("饿汉式，线程安全，但无法设置参数");
        }
    }


    /**
     * 静态内部类
     */
    public static class Singleton2{
        private static class SingletonHolder {
            private static final Singleton2 INSTANCE = new Singleton2();
        }

        private Singleton2() {}

        public static final Singleton2 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    public enum Singleton3{
        INSTANCE;
        public void say() {
            System.out.println("枚举式，优雅优雅~");
        }
    }
    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;
        private Singleton7() {
        }
        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

    @Test
    public void test() {
        Singleton3 singleton3 = Singleton3.INSTANCE;
        Singleton3 singleton31 = Singleton3.INSTANCE;
        singleton3.say();
        System.out.println(singleton3 == singleton31);
    }
}
