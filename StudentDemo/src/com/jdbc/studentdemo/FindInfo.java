package com.jdbc.studentdemo;

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
        int type = StudentConsole.getFindType();

        Scanner scanner = new Scanner(System.in);
        if (type==1){
            System.out.println("请输入姓名： ");
            String name = scanner.next();
            student = JDBCTools.findByName(name);
        }else {
            System.out.println("请输入电话号码： ");
            String phoneNumber = scanner.next();
            student = JDBCTools.findByPhoneNumber(phoneNumber);
        }

        return student;
    }
}
