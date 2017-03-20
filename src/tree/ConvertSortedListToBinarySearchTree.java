/**
 * 
 */
package tree;

/**
 * Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
	
	private static ListNode current;

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = head.next = new ListNode(2);
		node = node.next = new ListNode(3);
		node = node.next = new ListNode(4);
		node = node.next = new ListNode(5);
		node = node.next = new ListNode(6);
		node = node.next = new ListNode(7);
		node = node.next = new ListNode(8);
		node = node.next = new ListNode(9);
		TreeNode root = sortedListToBST(head);
		
	}
	
	/**
	 * 从下到上创建结点，然后将他们连接到父节点
	 * TODO
	 * @param head
	 * @return
	 * TreeNode
	 */
	public static TreeNode sortedListToBST(ListNode head){
		TreeNode root = null;
		if(head == null)
			return root;
		int size;
		current = head;
		size = getListLength(head);
		root = helper(0,size-1);
		return root;
	}

	/**
	 * TODO 从下到上创建结点
	 * @param size
	 * @return
	 * TreeNode
	 */
	private static TreeNode helper(int start, int end) {
		if(start>end){
			return null;
		}
		int mid = start + (end - start)/2;
		TreeNode left = helper(start, mid-1);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = helper(mid+1,end);
		
		root.left = left;
		root.right = right;
		return root;
	}

	/**
	 * 得到链表的长度
	 * TODO
	 * @param head
	 * @return
	 * int
	 */
	private static int getListLength(ListNode head){
		int size = 0;
		while(head != null){
			size++;
			head = head.next;
		}
		return size;
	}
	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
