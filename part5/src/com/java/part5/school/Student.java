package com.java.part5.school;

/**
 * Created by Jax on 2016/11/10.
 */
public class Student{
    // define member variable
    private int age;
    private String name,gender,phone,address,email;
    // setter and getter methods.
    public void setAge(int age){
        if(age>120 || age<0){
            System.out.println("年纪不合法！");
            return;
        }else{
            this.age = age;
        }
    }
    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        if(name.length()>6 || name.length()<2){
            System.out.println("姓名不合法");
            return;
        }else{
            this.name = name;
        }
    }
    public String getName(){
        return this.name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }

    public void setPhone(String phone){
        if(phone.length()!=11){
            System.out.println("error phone number");
            return;
        }else{
            this.phone = phone;
        }
    }
    public String getPhone(){
        return this.phone;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    // 默认构造函数
    public Student(){
        this.name = "nobody";
        this.age = 0;
        this.gender = "男";
        this.phone = "10086";
        this.address = "address";
        this.email = "alsodragon@gmail.com";
    }
    // 带成员变量的构造函数
    public Student(int age, String name, String gender, String phone, String address, String email){
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
    // 描述吃、喝、玩、睡的方法
    public void eat(){
        System.out.println("eat");
    }
    public void drink(){
        System.out.println("drink");
    }
    public void play(){
        System.out.println("play");
    }
    public void sleep(){
        System.out.println("sleep");
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
// main
class t1{
    public static void main(String[] args){
        Student student = new Student();
        System.out.println(student.getPhone());
    }

}