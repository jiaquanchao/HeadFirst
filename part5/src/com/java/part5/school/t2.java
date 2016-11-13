package com.java.part5.school;

/**
 * Created by Jax on 2016/11/10.
 */
public class t2{
    public static void main(String[] args){
        // 定义一个数组，保存多个student对象作为通讯录数据
        Student[] st= new Student[3];
        st[0] = new Student(1,"name1","male","1233211","address1","email1");
        st[1] = new Student(2,"name2","male","1233212","address2","email2");
        st[2] = new Student(3,"name3","female","1233213","address3","email3");
        args = new String[]{"name1","email3","666"};
        for (String str : args) {
            // 是不否需要友好提示标志位
            int flagFind = 0;
            for (int i = 0; i < st.length; i++) {
                // 可以通过name,email,address查询
                if (str.equals(st[i].getName()) || str.equals(st[i].getEmail()) || str.equals(st[i].getAddress())) {
                    // 查询到
                    System.out.println("you find one student: " + st[i].toString());
                    flagFind++;
                }
            }

            // 提示
            if (0 == flagFind) {
                System.out.println("the student didn't exist!");
            }
        }
    }
}
