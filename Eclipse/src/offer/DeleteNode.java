package offer;

import java.math.BigDecimal;

public class DeleteNode {

	public static class ListNode {
		int val;
		ListNode next;
	}
	
	public static ListNode deleteNode(ListNode head, ListNode del) throws InterruptedException {
		if (head==null || del==null) {
			return head;
		}
		
		if (head == del) {
			return head.next;
		}
		ListNode tem = head;
		while(tem.next != null) {
			if(tem.next==del) {
				tem.next = del.next;
				return head;
			}
			tem = tem.next;
		}
		System.err.println("无此节点！");
		Thread.sleep(10);
		return head;
	}

    public static void printList(ListNode head) {  
        while (head != null) {  
            System.out.print(head.val + "->");  
            head = head.next;  
        }  
        System.out.println("null");  
    }  	
	
    public static void main(String[] args) throws InterruptedException {  
        ListNode head = new ListNode();  
        head.val = 1;  
        head.next = new ListNode();  
        head.next.val = 2;  
        head.next.next = new ListNode();  
        head.next.next.val = 3;  
        head.next.next.next = new ListNode();  
        head.next.next.next.val = 4;  
        ListNode middle = head.next.next.next.next = new ListNode();  
        head.next.next.next.next.val = 5;  
        head.next.next.next.next.next = new ListNode();  
        head.next.next.next.next.next.val = 6;  
        head.next.next.next.next.next.next = new ListNode();  
        head.next.next.next.next.next.next.val = 7;  
        head.next.next.next.next.next.next.next = new ListNode();  
        head.next.next.next.next.next.next.next.val = 8;  
        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();  
        head.next.next.next.next.next.next.next.next.val = 9;  
        head = deleteNode(head, null); // 删除的结点为空  
        printList(head);  
        ListNode node = new ListNode();  
        node.val = 12;  
        head = deleteNode(head, head); // 删除头结点  
        printList(head);  
        head = deleteNode(head, last); // 删除尾结点  
        printList(head);  
        head = deleteNode(head, middle); // 删除中间结点  
        printList(head);  
        head = deleteNode(head, node); // 删除的结点不在链表中  
        printList(head);  
        double d = 1/2;
        System.out.println((1.0/2)*3*4);
        System.out.println(d);
    }  	
}
