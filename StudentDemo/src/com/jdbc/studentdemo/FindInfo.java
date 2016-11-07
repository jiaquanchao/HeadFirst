package com.jdbc.studentdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jax on 2016/11/5.
 */
public class FindInfo {
    public static Student findInfo() {
        /*
        控制台输出根据什么查询
         */
        Student student = null;
        List<Student> studentList = new ArrayList<>();
        int type = StudentConsole.getFindType();

        Scanner scanner = new Scanner(System.in);
        if (type==1) {
            System.out.println("请输入姓名： ");
            String name = scanner.next();
//            student = JDBCTools.findByName(name);
            studentList = JDBCTools.findByNames(name);
            for (Student student1 : studentList) {
                System.out.println(student1);
            }

        }else {
            System.out.println("请输入电话号码： ");
            String phoneNumber = scanner.next();
//            student = JDBCTools.findByPhoneNumber(phoneNumber);
            studentList = JDBCTools.findByPhoneNumbers(phoneNumber);
            for(Student student1:studentList) {
                System.out.println(student1);
            }
        }

        return student;
    }
}
