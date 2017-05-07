/**
 * 
 */
package linkedlist;

/**
 *接下来我们使用快排的另一种思路来解答。我们只需要两个指针p和q，这两个指针均往next方向移动，
 *移动的过程中保持p之前的key都小于选定的key，p和q之间的key都大于选定的key，那么当q走到末尾的时候便完成了一次支点的寻找。
 * 既然两个指针都是从前往后遍历，那么链表值进行交换就简单了。找到支点后，支点左边和支点右边进行子问题递归，就回到快排原来的思路上去了
 * 
 * 单链表的实现为
 *1. 使第一个节点为中心点
 *2. 创建2个指针(p，q)，p指向头结点，q指向p的下一个节点
 *3. q开始遍历,如果发现q的值比中心点的值小，则此时p=p->next，并且执行当前p的值和q的值交换，q遍历到链表尾即可
 *4. 把头结点的值和p的值执行交换。此时p节点为中心点,并且完成1轮快排
 *5. 使用递归的方法即可完成排序

 */
public class QuickSortOnLinkedList {
	
	private static class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode l1 = new ListNode(-1);
		ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(-4);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(30);
        ListNode l7 = new ListNode(0);
        
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        ListNode p = head;
        while(p.next != null){
        	System.out.print(p.val+" ");
        	p = p.next;
        }
        
        System.out.println(p.val);
        
        ListNode begin = head, end = p;
        quickSort(begin, end);
        
        p = head;
        while(p != null){
        	System.out.print(p.val+" ");
        	p = p.next;
        }
	}

	/**
	 *单向链表的快速排序
	 */
	private static void quickSort(ListNode begin, ListNode end) {
		//是否为空，或者只有一个节点
		if(begin == null || end == null || begin == end){
			return;
		}
		//设置了两个指针
		ListNode first = begin;
		ListNode second = begin.next;
		
		int mid = first.val;
		
		while(second != end.next && second != null){
			if(second.val < mid){
				first = first.next;
				if(first != second){
					int temp = first.val;
					first.val = second.val;
					second.val = temp;
				}
			}
			second = second.next;
		}
		
		//判断有些情况是不用换的，提升性能
		if(begin != first){
			int temp = begin.val;
			begin.val = first.val;
			first.val = temp;
		}
		
		quickSort(begin, first);
		quickSort(first.next, end);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
