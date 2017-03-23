/**
 * 
 */
package com.chen.offer;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * 最大最小堆 复杂度 时间 O(NlogN) 空间 O(N)
 * 
 * 思路
 * 维护一个最大堆，一个最小堆。最大堆存的是到目前为止较小的那一半数，最小堆存的是到目前为止较大的那一半数，这样中位数只有可能是堆顶或者堆顶两个数的均值。
 * 而维护两个堆的技巧在于判断堆顶数和新来的数的大小关系，还有两个堆的大小关系。我们将新数加入堆后，要保证两个堆的大小之差不超过1。
 * 先判断堆顶数和新数的大小关系，有如下三种情况：
 * 1. 最小堆堆顶小于新数时，说明新数在所有数的上半部分。
 * 2. 最小堆堆顶大于新数，但最大堆堆顶小于新数时，说明新数将处在最小堆堆顶或最大堆堆顶，也就是一半的位置。
 * 3. 最大堆堆顶大于新数时，说明新数将处在所有数的下半部分。
 * 再判断两个堆的大小关系，如果新数不在中间，那目标堆不大于另一个堆时，将新数加入目标堆，否则将目标堆的堆顶加入另一个堆，再把新数加入目标堆。
 * 如果新数在中间，那加到大小较小的那个堆就行了（一样大的话随便，代码中是加入最大堆）。
 * 这样，每次新加进来一个数以后，如果两个堆一样大，则中位数是两个堆顶的均值，否则中位数是较大的那个堆的堆顶。
 * 
 * 注意
 * Java中实现最大堆是在初始化优先队列时加入一个自定义的Comparator，默认初始堆大小是11。Comparator实现compare方法时，用arg1
 * - arg0来表示大的值在前面
 * 
 * 此题和从亿级别的数组中找出最大的100个数相似，维护一个100的最小堆即可。
 * 
 * 如果要求第n/10个数字该怎么做？
 * A：改变两个堆的大小比例，当求n/2即中位数时，两个堆是一样大的。而n/10时，说明有n/10个数小于目标数，9n/10个数大于目标数。所以我们保证最小堆是最大堆的9倍大小就行了。
 */
public class DataStreamMedian {

	//利用两个队列来模拟堆
	static PriorityQueue<Integer> maxHeap;
	static PriorityQueue<Integer> minHeap;
	
	public static void main(String[] args) {
		maxHeap = new PriorityQueue<>(11,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		minHeap = new PriorityQueue<>();
	}

	public static void insert(Integer num) {
		//如果最大堆为空，或者该数小于最大堆堆顶，则加入最大堆
		if(maxHeap.size() == 0 || num < maxHeap.peek()){
			//如果最大堆大小超过最小堆，则要平衡一下
			if(maxHeap.size() > minHeap.size()){
				minHeap.offer(maxHeap.poll());
			}
			maxHeap.offer(num);
		}
		//数字大于最小堆堆顶，加入最小堆的情况
		else if (minHeap.size() == 0 || num >minHeap.peek()) {
			if(minHeap.size() > maxHeap.size()){
				maxHeap.offer(minHeap.poll());
			}
			minHeap.offer(num);
		}
		//数字在两个堆顶之间的情况
		else {
			if(maxHeap.size() <= minHeap.size()){
				maxHeap.offer(num);
			}else {
				minHeap.offer(num);
			}
		}
	}

	public static Double getMedian() {
		//返回大小较大的堆堆顶，如果大小一样说明是偶数个，则返回堆顶均值
		if(maxHeap.size() > minHeap.size()){
			return (double)maxHeap.peek();
		}else if (maxHeap.size() < minHeap.size()) {
			return (double)minHeap.peek();
		}else if (maxHeap.isEmpty() && minHeap.isEmpty()) {
			return 0.0;
		}else {
			return (maxHeap.peek() + minHeap.peek())/2.0;
		}
	}

	//简洁版
//	class MedianFinder {
//	    
//	    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
//	    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());
//	    
//	    // Adds a number into the data structure.
//	    public void addNum(int num) {
//	        maxheap.offer(num);
//	        minheap.offer(maxheap.poll());
//	        if(maxheap.size() < minheap.size()){
//	            maxheap.offer(minheap.poll());
//	        }
//	    }
//
//	    // Returns the median of current data stream
//	    public double findMedian() {
//	        return maxheap.size() == minheap.size() ? (double)(maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
//	    }
//	};

}
