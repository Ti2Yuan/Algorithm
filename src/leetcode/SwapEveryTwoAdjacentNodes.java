package leetcode;

import leetcode.MergeKSortedLists.ListNode;

public class SwapEveryTwoAdjacentNodes {

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		root = swapPairs(root);
		System.out.println(root.val);
		System.out.println(root.next.val);
		System.out.println(root.next.next.val);
		System.out.println(root.next.next.next.val);
	}

	public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode node = root.next;
        ListNode temp = null;
        ListNode pre = root;
        while(node != null){
            temp = node.next;
            if(temp == null){
                break;
            }
            node.next = temp.next;
            temp.next = node;
            pre.next = temp;
            pre = node;
            node = node.next;
        }
        return root.next;
    }
	
//	 Definition for singly-linked list.
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

}
