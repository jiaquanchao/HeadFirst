package offer;

public class MergeList {
	
	public static class ListNode {
	    int value;
	    ListNode next;
	}
	
	public static ListNode mergeList(ListNode head1, ListNode head2) {
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		
		ListNode root = new ListNode();
		ListNode pointer = root;
		while(head1 != null && head2 !=null) {
			if(head1.value > head2.value) {
				pointer.next = head2;
				head2 = head2.next;
			} else {
				pointer.next = head1;
				head1 = head1.next;
			}
			pointer = pointer.next;
		}

		if(head1 == null){
			pointer.next = head2;
		}
		if(head2 == null){
			pointer.next = head1;
		}
		return root.next;
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
        ListNode head2 = new ListNode();
        head2.value = 1;
        head2.next = new ListNode();
        head2.next.value = 3;
        head2.next.next = new ListNode();
        head2.next.next.value = 5;
        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;
        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;
        head = mergeList(head, head2);
//        head = merge2(head, head2);
        printList(head);
    }
}
