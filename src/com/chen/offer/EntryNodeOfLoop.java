/**
 * 
 */
package com.chen.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中环的入口结点
 * 
 * 一个链表中包含环，请找出该链表的环的入口结点
 */
public class EntryNodeOfLoop {

	public class ListNode {
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
	 * 首先是设置两个指针p1,p2，一个指针p1步长为1，p2步长为2，让两个指针都从头结点往后走，如果存在环的话，两者肯定会再次相遇，因为在两个指针都进入环的时候，一个步长为2，一个步长为1，那就是说两个指针之间的距离每走一步就缩小1个单位，所以两个指针肯定会再次相遇。
	 * 
	 * 在相遇的时候，假设指针p1走了x步，那么p2肯定走了2x步，因为每次p2都比p1多走了一步。
	 * 
	 * 同时，还会发现，这个p2多走的x步，肯定是多走在了换上，也就是说，x是环的长度n的整数倍，即有如下公式：
	 * 
	 * 
	 * 2x=x+k∗n k=1,2,3,… p2至少围着环转了一圈。
	 * 设起点到入口结点为t，入口结点到相遇点为w ，则：x = t + w
	 * 2x = x + k*n,则x = k*n,则k*n = t + w;则t = k*n-w
	 * 若 k =1，也就是说t等于环剩余的长度
	 * 若k>1，相当于围着环转了（k-1）圈，再从相遇点走剩余的长度
	 * 也就说，让一个指针指向环上的相遇点，一个指针指向头结点，同时以步长为1往后走，其碰头的那个结点，就是入口结点
	 *  TODO
	 * 
	 *  
         * 两个指针，一个指针步长为1，一个步长为2；
         * 先计算两个指针相交的位置点；
         * 然后让一个指针指向头结点，步长都为1，往后走，其相遇点就是入口点
         * 该规律可通过公式推导得出
	 * @param pHead
	 * @return ListNode
	 */
	public ListNode entryNodeOfLoop(ListNode pHead) {
		ListNode targetNode = new ListNode(3);
		if (pHead == null || pHead.next == null)
			return null;
		ListNode preNode = pHead.next;
		ListNode postNode = pHead.next.next;
		//找到相遇点
		while(preNode != postNode){
			preNode = preNode.next;
			postNode = postNode.next.next;
		}
		//将其中一个指针指向头结点
		preNode = pHead;
		//步长都为1，同时往后走，直到相遇，相遇点就是入口
		while(preNode != postNode){
			preNode = preNode.next;
			postNode = postNode.next;
		}
		targetNode = preNode;
		return targetNode;
	}

	/**
	 * 基本做法
	 * 
	 * 不考虑其中潜在的规律，就按照一般的方法，创建一个list，把扫描过的节点都存储在list中，知道下一个节点在list中已经存在，那就说明该节点就是入口节点。
	 * 
	 * 这种方式下的时间复杂度为O(n^2)
	 */
	public ListNode entryNodeOfLoop2(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return null;
		ListNode targetNode = null;
		List<ListNode> nodesList = new ArrayList<>();
		nodesList.add(pHead);
		targetNode = pHead.next;
		while (!nodesList.contains(targetNode)) {
			nodesList.add(targetNode);
			targetNode = targetNode.next;
		}
		return targetNode;
	}

}
