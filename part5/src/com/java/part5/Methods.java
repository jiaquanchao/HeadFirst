package com.java.part5;


/**
 * Created by Jax on 2016/11/9.
 */
public class Methods {

    private String name;
    private String cardId;
    private int i;

    public Methods() {
        this("no name", "no card");
        System.out.println("name: " + name +"\nCardId: " + cardId);
        System.out.println("无参");
    }

    public Methods(String name, String cardId) {
//        this();
        this.cardId = cardId;
        this.name = name;
        System.out.println("有参");
    }


    public void say() {
//        int i;
        System.out.println("nothing"+i);
    }



    public static void main(String[] args) {
        Methods m = new Methods();
        System.out.println("++++++++++++");
        m.say();
    }



}
