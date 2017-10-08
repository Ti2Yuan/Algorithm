package com.chen.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenti
 * 
 * 求一个无序数组中的第K大的数字
 * 
 * 思路：
 * 
 * 1. 利用最小堆的原理，适合数据量大的情况
 * 2. 快速排序partition原理，O(n)
 * 3. 先排序再查找
 *
 */
public class KthMaxNumber {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int k = 0;
			String str = in.nextLine();
			k = in.nextInt();
			String[] strs = str.split(" ");
			Integer[] nums = new Integer[strs.length];
			for(int i = 0; i<strs.length; i++){
				nums[i] = Integer.parseInt(strs[i]);
			}
			process(nums, k);
		}
		in.close();
		
//		Integer[] nums = new Integer[]{45,67,33,21};
//		int k = 2;
//		process(nums, k);
	}

	private static void process(Integer[] nums, int k) {
		if(nums == null || nums.length < k || k <= 0 || nums.length <= 0){
			return;
		}
		int start = 0;
		int len = nums.length;
		int end = len - 1;
		int[] heap = new int[k];
		for(int i = 0; i< k; i++){
			heap[i] = nums[i];
		}
		for(int i = (k-1)/2;i>=0;i--){
			sift(heap, i, k-1);
		}
		for(int i = k; i<len; i++){
			if(nums[i] > heap[0]){
				heap[0] = nums[i];
				sift(heap, 0, k-1);
			}
		}
		System.out.println(heap[0]);
	}
	
	public static void sift(int[] r, int k, int len){
		int i = k;
		int j = 2*i+1;
		int temp;
		while(j <= len){
			if(j < len && r[j] > r[j+1])
				j++;
			if(r[i] > r[j]){
				temp = r[i];
				r[i] = r[j];
				r[j] = temp;
			}else {
				break;
			}
			i = j;
			j = 2*i+1;
		}
	}

	public static void heapSort(int[] r){
		if(r == null || r.length <= 0)
			return;
		int len = r.length;
		int temp ;
		for(int i = (len-1)/2;i>=0;i--){
			sift(r, i, len-1);
		}
		for (int i = 0; i < len; i++) {
			temp = r[0];
			r[0] = r[len-1-i];
			r[len-1-i] = temp;
			
			sift(r, 0, len-2-i);
			
			System.out.println(r[len-i-1]);
		}
	}

//	private static <T extends Comparable<T>> int partition(T[] data, int low, int high) {
//		T temp = data[low];
//		while(low < high){
//			while(low < high && temp.compareTo(data[high]) < 0){
//				high--;
//			}
//			if(low < high)
//				data[low++] = data[high];
//			while(low < high && temp.compareTo(data[low]) > 0){
//				low ++;
//			}
//			if(low < high)
//				data[high--] = data[low];
//		}
//		data[low] = temp;
//		return low;
//	}
}
