package com.java.part6;

/**
 * Created by Jax on 2016/11/14.
 */
class Person{
    private String name;
    private int age;

    public static void sop(Object o){
        System.out.println(o);
    }

    public Person(String name, int age){
        this.name =name;
        this.age =age;
    }

    public void setName(String name){
        this.name =name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age =age;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        return this.name+"::"+this.age;
    }

    //equals已经重写
    public boolean equals(Object obj){
        if(!(obj instanceof Person)){
            return false;
        }

        Person p =(Person)obj;

        //用来查看equals方法是否被调用
        sop(this.name +".......equals......."+ p.name);
        //认为名字相同并且年龄一样大的两个对象是一个
        return this.name.equals(p.name) && this.age == p.age;
    }

    public int hashCode(){
        System.out.println(this.name +"...hashCode");
        return 60;
    }
}