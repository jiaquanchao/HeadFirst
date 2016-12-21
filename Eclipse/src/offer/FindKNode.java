package offer;

public class FindKNode {

	public static class ListNode {
		int value;
		ListNode next;
	}
	public static void findK(ListNode head, int k) {
		ListNode pointer = head;
		ListNode header = head;
		
		for(int i = 1; i < k; i++) {
			pointer = pointer.next;
			//TODO
		}
		
		while(pointer.next != null) {
			pointer = pointer.next;
			header = header.next;
		}
		System.out.println(header.value);
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
        findK(head, 1); // 倒数第一个
        findK(head, 5); // 中间的一个
        findK(head, 9); // 倒数最后一个就是顺数第一个
        findK(head, 10);
    }	
 }
