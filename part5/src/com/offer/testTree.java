package com.offer;

/**
 * Created by Jax on 2016/11/29.
 */
public class testTree {

    public static void main(String[] args) {
        Integer[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};

        System.out.println(preorder[0].equals(inorder[3]));
        int aa = 0;

        for (int i = 0; i < 60; i++) {
            if (i == 30) {
                aa = i;
                break;
            }
        }
        System.out.println(aa);
    }
}
