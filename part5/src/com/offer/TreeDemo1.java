package com.offer;

/**
 * Created by Jax on 2016/11/29.
 */
public class TreeDemo1 {

    public static class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;
    }

    public static  TreeNode findNode(int[] s, int[] z) {

        if(s == null || z == null || s.length != z.length || s.length < 1) {
            return null;
        }
        return findNode(s, 0, s.length-1, z, 0, z.length-1);
    }

    public static TreeNode findNode(int[] s, int startS, int stopS, int[] z, int startZ, int stopZ) {
        if(startS > stopS) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = s[startS];
        int flag = startZ;
//        for (int i = startZ; i < stopZ; i++) {
//            if (z[i]==s[startS]) {
//                flag = i;
//                break;
//            }
//        }
        while (flag<=stopZ && z[flag] != s[startS]) {
            flag ++;
        }
        //左向
        root.left = findNode(s, startS+1, startS + flag - startZ, z, startZ, flag - 1);
        //右向
        root.right = findNode(s, startS + flag - startZ + 1, stopS, z, flag + 1, stopZ);

        return root;
    }

    //foreach
    public static  void printTree(TreeNode tree) {
        if (tree!=null) {
            printTree(tree.left);
            System.out.print(tree.val+" ");
            printTree(tree.right);
        }
    }


    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = findNode(preorder, inorder);
        printTree(root);
    }
}