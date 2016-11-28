package com.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Jax on 2016/11/28.
 */
public class LinkDemo {

    public static class ListNode {
        int val;
        ListNode next;
    }

    public static void printEle(ListNode root) {

        Deque<ListNode> deque = new ArrayDeque<>();
        while (root!= null) {
            deque.push(root);
            root = root.next;
        }

        ListNode tem = null;
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst().val+" ");
        }
    }

    public static void printRecursive(ListNode root) {
        if (root != null) {
            printRecursive(root.next);
            System.out.println(root.val+ " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;
        printEle(root);
        System.out.println();
        printRecursive(root);
    }
}
