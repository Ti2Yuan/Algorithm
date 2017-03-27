/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;

/**
 * quicksort之前有个bug: 在数组里很多重复元素的时候, 效率会下降为O(N2). 原因是quicksort没有好好处理重复元素的问题.

于是Dijkstra提出了一个3-way partition的算法: 把数组分为三部分: 左边[lo, lt)严格小于pivot, 中间[lt, gt]等于pivot, 右边(gt, hi]严格大于pivot.

算法初始化lt=lo, gt=hi, i=lo, 用指针i向右扫描, [i,gt]为未处理到的部分. 
算法很subtle, invariant是这样的:

a[lo,lt-1] < pivot
a[lt, i-1] = pivot
a[i,gt] = unseen
a[gt+1, hi] > pivot
 */
public class QuickSort3Way {

	
	public static void main(String[] args) {
		int[] data = new int[]{4,7,3,9,1,4,2,4,8,3,41,2};
		sort(data);
		System.out.println(Arrays.toString(data));
	}
	
	public static void sort(int[] nums){
		if(nums == null || nums.length == 0)
			return;
		sort(nums, 0, nums.length-1);
	}

	public static void sort(int[] nums, int left, int right){
		if(left >= right)
			return;
		int low = left;
		int high = right;
		int i = low+1;
		
		int pivotIndex = low;
		int pivotValue = nums[low];
		
		while(i <= high){
			if(nums[i] == pivotValue){     //如果和pivotValue相等，继续向后扫描
				i++;
			}else if(nums[i] < pivotValue){  //如果小于pivotVlaue，则替换到pivot前面,然后i++,low++
				swap(nums, i, low);
				i++;
				low++;
			}else{     //如果大于pivotValue，则替换到后面,然后只能high--,继续检查第i个元素。
				swap(nums, i, high);
				high--;
			}
		}
		
		sort(nums, left, low-1);
		sort(nums, high+1, right);
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
