/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;

/**
 *Dual-Pivot Quick Sort (双轴快速排序)
 *
 *将数组分成三个区，分别是x<pivotValue1, pivotValue<x<pivotValue2, x>pivotValue2
 *然后再递归对这三个区进行双轴快速排序
 */
public class QuickSortDualPivot {

	public static void main(String[] args) {
		int[] data = new int[]{4,7,4,9,1,5,7,18,23,41,4,10,3,2,45,12,5,4};
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

		int pivotValue1 = nums[left];
		int pivotValue2 = nums[right];
		
		if(pivotValue1 > pivotValue2){
			swap(nums, left, right);
			pivotValue1 = nums[left];
			pivotValue2 = nums[right];
		}		
		
		int low = left+1;
		int high = right-1;
		int i = left+1;
		
		while(i <= high){
			if(nums[i] < pivotValue1){ //小于pivotValue1
				swap(nums, i, low);
				i++;
				low++;
			}else if(nums[i] > pivotValue2){  //大于pivotValue2
				swap(nums, i, high);
				high--;
			}else{  //大于pivotValue1, 小于pivotValue2
				i++;
			}
		}
		
		System.out.println(low+" "+high+" "+i);
		
		swap(nums, left, --low);
		swap(nums, right, ++high);
		
		sort(nums,left,low-1);
		sort(nums, low+1, high-1);
		sort(nums, high+1, right);
		
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
