package com.java.part5;

/**
 * Created by Jax on 2016/11/9.
 */




public class Son extends Father {

    public String str = "son";

    public void say() {

        System.out.println("this is son");

        }

    public void test() {

        System.out.println("this is son's str : "+str);
    }

    public void sonMethod() {

        System.out.println("son's method");
        }


    public static void main(String[] args) {

        Father f = new Father();
        System.out.println(f.str);
        f.say();
        f.test();

        Son s = new Son();
        System.out.println(s.str);
        s.say();
        s.test();

        Father fs = new Son(); //此时，编译时为Father， 运行时为Son，也就是说编译时会将Father相关的进行编译
        System.out.println("这是fs的str: "+fs.str+"\n    此时的str并不是Son的str，现在的str是编译时的str");
        System.out.println("这是fs的say(), 与Son的相同，并没有用到Father的Say()");
        fs.say();
        System.out.println("这是fs的test(), 与Son的相同，同时该方法的str是son, 也就是运行时的str。这就是运行时与编译时的差别");
        fs.test();

    }

}