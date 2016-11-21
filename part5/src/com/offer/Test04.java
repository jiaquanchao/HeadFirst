package com.offer;

/**
 * Created by Jax on 2016/11/19.
 */
public class Test04 {

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * @param string     要转换的字符数组
     * @param usedLength 字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public static int replaceBlank(char[] string, int usedLength) {
        // 判断输入是否合法
        if (string == null || string.length < usedLength) {
            return -1;
        }

        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置

        // 字符中有空白字符，一直处理到所有的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // 否则移动字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }

        return tmp;
    }

    public static String replaceB(char[] chars, int usedLength) {

        if(chars == null || usedLength > chars.length) {
            return "无数据或数据溢出!";
        }

        int blankNum = 0;
        for (int i = 0; i < usedLength; i++) {
            if (chars[i] == ' ') {
                blankNum ++;
                System.out.println("发现空格 +1");
            }
        }

        if (blankNum == 0) {
            return "无空格...";
        }

        int targetLength = usedLength + blankNum*2;
        if(targetLength > chars.length) {
            return "目标字符串长度溢出！";
        }

        int fOri = usedLength - 1;
        int fNew = targetLength - 1;

        for (int i = fOri; i >= 0; i --) {
            if (chars[i] != ' ') {
                chars[fNew --] = chars[i];
            } else {
                chars[fNew --] = '0';
                chars[fNew --] = '2';
                chars[fNew --] = '%';
            }
        }
        return new String(chars, 0, targetLength);
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

//        int length = replaceBlank(string, 12);
//        System.out.println(new String(string, 0, length));
        int length = 12;
        System.out.println(new String(string, 0, length));
        System.out.println(replaceB(string, length));
    }
}
