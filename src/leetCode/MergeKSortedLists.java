package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * 算法1：最傻的做法就是先1、2合并，12结果和3合并，123结果和4合并，…,123..k-1结果和k合并，我们计算一下复杂度。
 *  1、2合并，遍历2n个节点
 *  12结果和3合并，遍历3n个节点
   123结果和4合并，遍历4n个节点 
    …
   123..k-1结果和k合并，遍历kn个节点
        总共遍历的节点数目为n(2+3+…+k) = n*(k^2+k-2)/2, 因此时间复杂度是O(n*(k^2+k-2)/2) = O(nk^2)，代码如下：
 *
 * 算法2：利用分治的思想把合并k个链表分成两个合并k/2个链表的任务，一直划分，知道任务中只剩一个链表或者两个链表。
 * 可以很简单的用递归来实现。因此算法复杂度为T(k) = 2T(k/2) + O(nk),很简单可以推导得到算法复杂度为O（nklogk）
 * 递归的代码就不贴了。下面是非递归的代码非递归的思想是（以四个链表为例）：                   本文地址
    1、3合并，合并结果放到1的位置
    2、4合并，合并结果放到2的位置
        再把1、2合并（相当于原来的13 和 24合并）
 *
 * 算法3：维护一个k个大小的最小堆，初始化堆中元素为每个链表的头结点，每次从堆中选择最小的元素加入到结果链表，
 * 再选择该最小元素所在链表的下一个节点加入到堆中。这样当堆为空时，所有链表的节点都已经加入了结果链表。
 * 元素加入堆中的复杂度为O（longk），总共有kn个元素加入堆中，因此，复杂度也和算法2一样是O（nklogk）
 * 
 * 此处只实现算法2和算法3
 * @author chenti
 *
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		
		ListNode rootNode = new ListNode(1);
		rootNode.next = new ListNode(3);
		ListNode node1 = rootNode.next;
		node1.next = new ListNode(5);
		
		ListNode rootNode2 = new ListNode(1);
		rootNode2.next = new ListNode(3);
		ListNode node2 = rootNode2.next;
		node2.next = new ListNode(5);
		
		ListNode[] lists = new ListNode[]{rootNode,rootNode2};
		
		
	}
	
	
	//基于堆
	public Comparator<MergeKSortedLists.ListNode> ListNodeComparator = new Comparator<MergeKSortedLists.ListNode>() {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if(o1 == null){
				return 1;
			}else if (o2 == null) {
				return -1;
			}
			return o1.val - o2.val;
		}
	};
	
	 public ListNode mergeKListsByHeap(ListNode[] lists) {
	        if (lists == null || lists.length == 0) {
	            return null;
	        }
	        
	        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
	        for (int i = 0; i < lists.length; i++) {
	            if (lists[i] != null) {
	                heap.add(lists[i]);
	            }
	        }
	        
	        ListNode dummy = new ListNode(0);
	        ListNode tail = dummy;
	        while (!heap.isEmpty()) {
	            ListNode head = heap.poll();
	            tail.next = head;
	            tail = head;
	            if (head.next != null) {
	                heap.add(head.next);
	            }
	        }
	        return dummy.next;
	    }

	
	
	
	/**
	 * Divide & Conquer
	 * 算法一
	 * 
	 */
	    public ListNode mergeKListsByDivide(ListNode[] lists) {
	        if(lists == null || lists.length == 0){
	            return null;
	        }
	        
	        return mergeHelper(lists,0,lists.length-1);
	    }
	    
	    public ListNode mergeHelper(ListNode[] lists,int start,int end){
	        if(start == end){
	            return lists[start];
	        }
	        int mid = (start + end) / 2;
	        ListNode list1 = mergeHelper(lists,start,mid);
	        ListNode list2 = mergeHelper(lists,mid+1,end);
	        return sortTwoLists(list1,list2);
	    }
	    
	    public ListNode sortTwoLists(ListNode list1,ListNode list2){
	        if(list1 == null ){
	            return list2;
	        }
	        if(list2 == null ){
	            return list1;
	        }
	        ListNode result = new ListNode(0);
	        ListNode temp = result;
	        while(list1 != null && list2 != null){
	            if(list1.val < list2.val){
	                temp.next = list1;
	                temp = temp.next;
	                list1 = list1.next;
	            }else{
	                temp.next = list2;
	                temp = temp.next;
	                list2 = list2.next;
	            }
	        }
	        if(list1 != null){
	            temp.next = list1;
	        }
	        if(list2 != null){
	            temp.next = list2;
	        }
	        return result.next;
	    }
	
//	 Definition for singly-linked list.
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

}
