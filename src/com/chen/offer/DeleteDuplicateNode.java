/**
 * 
 */
package com.chen.offer;

/**
 * 删除链表中重复的结点
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点， 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 */
public class DeleteDuplicateNode {

	public static class ListNode {
		int val;
		ListNode next = null;

		/**
		 * 
		 */
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode pHead = new ListNode(1);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(3);
		ListNode f = new ListNode(4);
		ListNode g = new ListNode(4);
		pHead.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		System.out.println(deleteDuplication(pHead));
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null)
			return null;
		ListNode pre = new ListNode(0);
		pre.next = pHead;
		ListNode node = pHead;
		ListNode root = pre;
		root.next = pHead;
		boolean flag = false;
		while(node != null){
			ListNode nextNode = node.next;
			if(nextNode == null)
				break;
			if(nextNode.val == node.val){
				while(nextNode != null && nextNode.val == node.val){
					nextNode = nextNode.next;
				}
				pre.next = nextNode;
				node = nextNode;
			}else {
				if(!flag){
					root.next = node;
					flag = true;
				}
				pre = node;
				node = nextNode;
			}
		}
		return root.next;
	}

	public static ListNode deleteDuplication2(ListNode pHead) {

		if (pHead == null)
			return null;
		ListNode p = pHead;
		ListNode n = new ListNode(0);
		ListNode pre = n;
		n.next = pHead;
		boolean flag = false;
		while (p != null) {
			ListNode q = p.next;
			if (q == null)
				break;
			if (q.val == p.val) {
				while (q != null && q.val == p.val) {
					q = q.next;
				}
				pre.next = q;
				p = q;
			} else {
				if (!flag) {
					n.next = p;
					flag = true;
				}
				pre = p;
				p = q;
			}
		}
		return n.next;
	}

}
