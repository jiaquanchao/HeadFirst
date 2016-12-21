package offer;

public class ReverseList {

    public static class ListNode {
        int value;
        ListNode next;
    }
    
    public static ListNode reverse(ListNode head) {
    	ListNode header = new ListNode();
    	header.next = null;
    	ListNode tem = new ListNode();
    	ListNode pointer = head;
    	while(pointer != null) {
    		tem = pointer.next;
    		pointer.next = header.next;
    		header.next = pointer;
    		pointer = tem;
    	}
//    	header = header.next;
    	return header.next;
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    
    
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode();
        head.next.value = 2;
        head.next.next = new ListNode();
        head.next.next.value = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;
        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
        printList(head);
        head = reverse(head);
        printList(head);
//        head = reverse(head);
//        printList(head);
    }
}
