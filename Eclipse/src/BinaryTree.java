
public class BinaryTree {
	public static class BinaryTreeNode{
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
		if(preorder==null||inorder==null||preorder.length!=inorder.length||inorder.length<1) {
			return null;
		}
		
		return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		
		if (pe<ps) {
			return null;
		}
		int nodeVal = preorder[ps];
		int flag = is;
		while(inorder[flag] != nodeVal && flag <= ie) {
			flag ++;
		}
		if (flag > ie) {
			System.out.println("error!");
		}
		BinaryTreeNode node = new BinaryTreeNode();
		node.val = nodeVal;
		node.left = construct(preorder, ps + 1, ps + flag - is, inorder, is, flag - 1);
		node.right = construct(preorder, ps + flag - is + 1, pe, inorder, flag + 1, ie);
		return node;
	}
	
	public static void printTree(BinaryTreeNode node) {
		if (node != null) {
			
			printTree(node.left);
			System.out.println(node.val);
			printTree(node.right);
		}
	}
	
	public static void main(String[] args) {  
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};  
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  

}
