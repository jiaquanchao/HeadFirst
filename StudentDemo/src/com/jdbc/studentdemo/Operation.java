package com.jdbc.studentdemo;

import java.util.Scanner;

/**
 * Created by Jax on 2016/11/5.
 */
public class Operation {
    /*
    1、需要在控制台选择操作类型：1、添加学生信息 2、查询学生信息
     */

    public static void operation() throws Exception {

        Student student = null;
        Scanner scanner = new Scanner(System.in);
        int operationType = StudentConsole.getOperationTypeFromConsole();

        if (operationType == 1) {
            InputInfo.inputInfo();
        } else {
            student = FindInfo.findInfo();
            System.out.println("loading ...");
            if (student!=null) {
                System.out.println(student.toString()+"\n是否继续查询？ Y/N");
                String continueType = scanner.next();
                if(continueType.equals("Y")) {
                    operation();
                } else {
                    System.out.println("Peace out...");
                }
            }else {
                System.out.println("没有数据...");
            }
        }
    }



    public static void main(String[] args) throws Exception {
        operation();
    }
}
