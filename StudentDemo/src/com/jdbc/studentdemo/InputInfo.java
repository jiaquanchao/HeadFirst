package com.jdbc.studentdemo;

import java.util.Scanner;

/**
 * Created by Jax on 2016/11/5.
 */
public class InputInfo {
    public static void inputInfo() throws Exception {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学号： ");
        student.setId(scanner.nextLong());
        System.out.println("请输入姓名： ");
        student.setName(scanner.next());
        System.out.println("请输入电话： ");
        student.setphoneNumber(scanner.next());

        String sql = "INSERT INTO UT VALUES (?,?,?)";
        JDBCTools.updateStudentInfo(sql, student.getId(),
                student.getName(),
                student.getphoneNumber());
    }
}
