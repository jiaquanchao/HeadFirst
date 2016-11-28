package com.offer;

/**
 * Created by Jax on 2016/11/28.
 */
public class TreeDemo {

    public static class TreeNode<T>{
        T val = null;
        TreeNode<T> left = new TreeNode<>();
        TreeNode<T> right = new TreeNode<>();

        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }

    public <T> TreeNode<T> findNode(T[] s, T[] z) {
        TreeNode<T> root = new TreeNode<>();

        root.setVal(s[0]);

        TreeNode<T> beforeN = new TreeNode<>();
        TreeNode<T> temN = new TreeNode<>();
        TreeNode<T> afterN = new TreeNode<>();
        int numL;
        int numR;
        int flag = 0;
        // flag is left's length and right's - 1
        for (int i = 0; i < z.length; i++) {
            if (z[i] == s[0]) {
                flag = i;
                break;
            }
        }
        numL = ((int)flag/2)+1;
        numR = ((int)(s.length-flag-1))+1;
        beforeN = root;
        for (int i = 0; i < numL; i++) {
            temN.setVal(s[--flag]);
            beforeN.left = temN;
            temN.left = afterN

        }


    }
}
