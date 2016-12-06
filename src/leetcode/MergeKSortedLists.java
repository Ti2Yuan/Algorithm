package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * �㷨1����ɵ������������1��2�ϲ���12�����3�ϲ���123�����4�ϲ�����,123..k-1�����k�ϲ������Ǽ���һ�¸��Ӷȡ�
 *  1��2�ϲ�������2n���ڵ�
 *  12�����3�ϲ�������3n���ڵ�
   123�����4�ϲ�������4n���ڵ� 
    ��
   123..k-1�����k�ϲ�������kn���ڵ�
        �ܹ������Ľڵ���ĿΪn(2+3+��+k) = n*(k^2+k-2)/2, ���ʱ�临�Ӷ���O(n*(k^2+k-2)/2) = O(nk^2)���������£�
 *
 * �㷨2�����÷��ε�˼��Ѻϲ�k������ֳ������ϲ�k/2�����������һֱ���֣�֪��������ֻʣһ�����������������
 * ���Ժܼ򵥵��õݹ���ʵ�֡�����㷨���Ӷ�ΪT(k) = 2T(k/2) + O(nk),�ܼ򵥿����Ƶ��õ��㷨���Ӷ�ΪO��nklogk��
 * �ݹ�Ĵ���Ͳ����ˡ������Ƿǵݹ�Ĵ���ǵݹ��˼���ǣ����ĸ�����Ϊ������                   ���ĵ�ַ
    1��3�ϲ����ϲ�����ŵ�1��λ��
    2��4�ϲ����ϲ�����ŵ�2��λ��
        �ٰ�1��2�ϲ����൱��ԭ����13 �� 24�ϲ���
 *
 * �㷨3��ά��һ��k����С����С�ѣ���ʼ������Ԫ��Ϊÿ�������ͷ��㣬ÿ�δӶ���ѡ����С��Ԫ�ؼ��뵽�������
 * ��ѡ�����СԪ�������������һ���ڵ���뵽���С���������Ϊ��ʱ����������Ľڵ㶼�Ѿ������˽������
 * Ԫ�ؼ�����еĸ��Ӷ�ΪO��longk�����ܹ���kn��Ԫ�ؼ�����У���ˣ����Ӷ�Ҳ���㷨2һ����O��nklogk��
 * 
 * �˴�ֻʵ���㷨2���㷨3
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
	
	
	//���ڶ�
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
	 * �㷨һ
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
