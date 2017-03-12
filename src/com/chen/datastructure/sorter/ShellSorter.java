/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;

/**
 * 希尔排序，也是一种插入排序
 * 时间复杂度O(nlogn)-O(n^2)之间
 * 空间复杂度O(1)
 * 不稳定
 */
public class ShellSorter {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = new Integer[]{1,4,7,8,9,1,5,10,18,23,41,19};
		shellSort(data);
	}
	
	/**
	 * 希尔排序
	 * TODO
	 * @param data
	 * void
	 */
	public static <T extends Comparable<T>> T[] shellSort(T[] data){
		if(data == null || data.length <= 0){
			return null;
		}
		for(int d = data.length/2; d >= 1;d /= 2){
			for(int i = d;i<data.length;i++){
				T temp = data[i];
				int j = i - d;
				for(; j>=0 && temp.compareTo(data[j]) < 0;j -= d){
					data[j + d] = data[j];
				}
				data[j + d] = temp;
			}
		}
		System.out.println(Arrays.toString(data));
		return data;
	}

}
