/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序，也是一种选择排序
 * 时间复杂度O(nlog2n)
 * 空间复杂度O(log2n)-O(n)之间
 * 不稳定
 */
public class QuickSorter {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = new Integer[]{1,4,7,8,9,1,5,10,18,23,41,19};
		quickSort(data);
		quickSortNonRecursively(data, 0 , 11);
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] data){
		if(data == null || data.length <= 0)
			return;
		quickSortRecursively(data,0,data.length-1);
		System.out.println(Arrays.toString(data));
	}

	/**
	 * 递归快速排序
	 * @param data
	 * @param low
	 * @param high
	 * @param <T>
	 */
	private static <T extends Comparable<T>> void quickSortRecursively(T[] data, int low, int high) {
		if(low < high){
			int index = partition(data,low,high);
			quickSortRecursively(data,low,index-1);
			quickSortRecursively(data, index+1, high);
		}
	}

	
	private static <T extends Comparable<T>> int partition(T[] data, int low, int high) {
		T temp = data[low];
		while(low < high){
			while(low < high && temp.compareTo(data[high]) < 0){
				high--;
			}
			if(low < high)
				data[low++] = data[high];
			while(low < high && temp.compareTo(data[low]) > 0){
				low ++;
			}
			if(low < high)
				data[high--] = data[low];
		}
		data[low] = temp;
		return low;
	}

	/**
	 * 非递归实现快速排序
	 * @param nums
	 * @param start
	 * @param end
	 */
	private  static void quickSortNonRecursively(Integer[] nums, int start, int end){
		if(start >= end)
			return;
		Stack<Integer> startStack = new Stack<>();
		Stack<Integer> endStack = new Stack<>();

		startStack.push(start);
		endStack.push(end);

		while(!startStack.isEmpty() && !endStack.isEmpty()){
			int tempStart = startStack.pop();
			int tempEnd = endStack.pop();
			if(tempStart < tempEnd){
				int temp = nums[tempStart];
				int left = tempStart;
				int right = tempEnd;

				while(left < right){
					while(left < right && temp < nums[right]){
						--right;
					}
					if(left < right){
						nums[left++] = nums[right];
					}
					while(left < right && nums[left] < temp){
						++left;
					}
					if(left < right){
						nums[right--] = nums[left];
					}
				}
				startStack.push(tempStart);
				endStack.push(left - 1);
				startStack.push(left+1);
				endStack.push(tempEnd);
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
