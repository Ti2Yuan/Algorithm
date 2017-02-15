package leetcode;

import leetcode.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST
 */
public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
		ListNode head = ListNode.createListNode(nums);
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
		TreeNode rootNode = sortedListToBST(head);
		inOrder(rootNode);
	}

	public static TreeNode sortedListToBST(ListNode head){
		return sortedListToBST(head, null);
	}
	public static TreeNode sortedListToBST(ListNode start, ListNode end){
		if(start == end){
			return null;
		}else if(start.next == end){
			return new TreeNode(start.value);
		}else {
			ListNode fast = start,slow = start;
			while(fast.next != end && fast.next.next != end){
				fast = fast.next.next;
				slow = slow.next;
			}
			TreeNode left = sortedListToBST(start, slow);
			TreeNode right = sortedListToBST(slow.next, end);
			TreeNode root = new TreeNode(slow.value);
			root.leftNode = left;
			root.rightNode = right;
			return root;
		}
	}
	
	public static void inOrder(TreeNode rootNode){
		if(rootNode == null)
			return;
		inOrder(rootNode.leftNode);
		System.out.println(rootNode.value);
		inOrder(rootNode.rightNode);
		return;
	}
	
	
	public static class ListNode{
		int value;
		ListNode next;
		public ListNode(){};
		public ListNode(int value){
			this.value = value;
		}
		public static ListNode createListNode(int[] nums){
			int length=nums.length;
			ListNode head = null;
			head = new ListNode(nums[0]);
			ListNode root = head;
			ListNode temp = null;
			for(int i=1;i<length;i++){
				temp = new ListNode(nums[i]);
				head.next = temp;
				head = temp;
			}
			return root;
		}
	}
	
}
