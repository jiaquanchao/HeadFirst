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
        student.setID(scanner.next());
        System.out.println("请输入姓名： ");
        student.setNAME(scanner.next());
        System.out.println("请输入电话： ");
        student.setPHONENUMBER(scanner.next());

        String sql = "INSERT INTO UT VALUES (?,?,?)";
        JDBCTools.updateStudentInfo(sql, student.getID(),
                student.getNAME(),
                student.getPHONENUMBER());
    }
}
