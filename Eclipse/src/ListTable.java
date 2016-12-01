import java.util.ArrayDeque;
import java.util.Deque;

public class ListTable {
	public static class ListNode {
		int val;
		ListNode nxt;
	}
	
	public static void printList(ListNode node) {
		if(node.nxt!=null){
			printList(node.nxt);
		}
		System.out.println(node.val);
	}
	
	public static void printPrintPrint(ListNode node) {
		
		Deque<ListNode> deque = new ArrayDeque<>();
		ListNode temNode = node;
		while(temNode!=null){
			deque.push(temNode);
			temNode = temNode.nxt;
		}
		while(!deque.isEmpty()) {
			System.out.println(deque.pollFirst().val);
		}
	}
	
    public static void main(String[] args) {  
        ListNode root = new ListNode();  
        root.val = 1;  
        root.nxt = new ListNode();  
        root.nxt.val = 2;  
        root.nxt.nxt = new ListNode();  
        root.nxt.nxt.val = 3;  
        root.nxt.nxt.nxt = new ListNode();  
        root.nxt.nxt.nxt.val = 4;  
        root.nxt.nxt.nxt.nxt = new ListNode();  
        root.nxt.nxt.nxt.nxt.val = 5;  
        printList(root);  
        System.out.println();  
        printPrintPrint(root);  
    }	

}
