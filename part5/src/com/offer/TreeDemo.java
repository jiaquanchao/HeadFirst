package com.offer;

/**
 * Created by Jax on 2016/11/28.
 */
public class TreeDemo {

    public static class TreeNode<T>{
        T val = null;
        TreeNode<T> left;
        TreeNode<T> right;
    }

    public static <T> TreeNode<T> findNode(T[] s, T[] z) {

        if(s == null || z == null || s.length != z.length || s.length < 1) {
            return null;
        }
        return findNode(s, 0, s.length-1, z, 0, z.length-1);
    }

    public static <T> TreeNode<T> findNode(T[] s, int startS, int stopS, T[] z, int startZ, int stopZ) {
        if(startS > stopS) {
            return null;
        }

        TreeNode<T> root = new TreeNode<>();
        root.val = s[startS];
        int flag = 0;
        for (int i = startZ; i <= stopZ; i++) {
            if (z[i].equals(s[startS])) {
                flag = i;
                break;
            }
        }
        //左向
        root.left = findNode(s, startS+1, startS + flag - startZ, z, startZ, flag - 1);
        //右向
        root.right = findNode(s, startS + flag - startZ + 1, stopS, z, flag + 1, stopZ);

        return root;
    }

    //foreach
    public static <T> void printTree(TreeNode<T> tree) {
        if (tree!=null) {
            printTree(tree.left);
            System.out.print(tree.val+" ");
            printTree(tree.right);
        }
    }


    public static void main(String[] args) {
        Integer[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode<Integer> root = findNode(preorder, inorder);
        printTree(root);
    }
}
