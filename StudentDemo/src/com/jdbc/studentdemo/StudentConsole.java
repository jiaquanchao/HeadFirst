package com.jdbc.studentdemo;

import java.util.Scanner;

/**
 * Created by Jax on 2016/11/5.
 */
public class StudentConsole {
    public static int getOperationTypeFromConsole() {
        int type = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("选择操作类型：1、添加学生信息 2、查询学生信息");
        type = Integer.parseInt(scanner.next());
        if (type != 1 && type != 2) {
            System.out.println("操作无效");
            getOperationTypeFromConsole();
        }

        return type;
    }

    public static int getFindType() {
        int type = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("查询条件：1、姓名 2、手机号码");
        type = Integer.parseInt(scanner.next());
        if (type!=1&&type!=2) {
            System.out.println("操作无效");
            getFindType();
        }

        return type;
    }
}
