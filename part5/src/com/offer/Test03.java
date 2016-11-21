package com.offer;

/**
 * Created by Jax on 2016/11/19.
 * 本例中犯错：
 *      应该先判断最终需求的结果，若不符合再判断其他
 *      例如本例应先判断本次循环取到的数是否等于要求的数，然后再判断别的情况
 *
 *      二维数组.length返回行数，二维数组[0].length返回列数
 */
public class Test03 {

    public static boolean find(int[][] ints, int num) {

        if(ints == null || ints.length < 1 || ints[0].length < 1) {
            return false;
        }
        int rows = ints.length;
        int columns = ints[0].length;
        int row = 0;
        int column = columns - 1;
        try {
            while (row < rows && column >= 0) {
                if(ints[row][column] == num) {
                    return true;
                }else if(ints[row][column] > num) {
                    column --;
                }else {
                    row ++;
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println("数组缺失元素");
            return false;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6}
        };
        int[] testEg = {7, 5, 1, 15, 0, 16};
        for (int i:
             testEg) {
            System.out.println(find(matrix, i));    // 要查找的数在数组中
            System.out.println("*****************************");
            Thread.sleep(20);

        }
//        System.out.println(find(matrix, 7));    // 要查找的数在数组中
//        System.out.println(find(matrix, 5));    // 要查找的数不在数组中
//        System.out.println(find(matrix, 1));    // 要查找的数是数组中最小的数字
//        System.out.println(find(matrix, 15));   // 要查找的数是数组中最大的数字
//        System.out.println(find(matrix, 0));    // 要查找的数比数组中最小的数字还小
//        System.out.println(find(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(find(null, 16));     // 健壮性测试，输入空指针
    }


}
