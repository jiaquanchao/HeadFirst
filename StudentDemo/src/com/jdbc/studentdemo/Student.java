package com.jdbc.studentdemo;

/**
 * Created by Jax on 2016/11/5.
 */
public class Student {

    private long id;

    private String name;

    private String phoneNumber;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setphoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
