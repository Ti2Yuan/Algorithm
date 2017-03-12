/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度O(n^2)
 * 空间复杂读O(1)
 * 稳定
 */
public class InsertSorter {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = new Integer[]{1,4,7,8,9,1,5,10};
		//insertSort(data);
		binaryInsertSort(data);
	}
	
	/**
	 * 插入排序
	 * TODO
	 * @param data
	 * void
	 */
	public static <T extends Comparable<T>> void insertSort(T[] data){
		if(data == null || data.length <= 0){
			return;
		}
		int len = data.length;
		for(int i = 1;i<len;i++){
			T temp = data[i];
			int j = i - 1;
			for(;j>=0 && temp.compareTo(data[j]) < 0;j--){
					data[j+1] = data[j];
			}
			data[j+1] = temp;
		}
		System.out.println(Arrays.toString(data));
	}
	
	/**
	 * 折半插入排序
	 * TODO
	 * @param data
	 * void
	 */
	public static <T extends Comparable<T>> void binaryInsertSort(T[] data){
		if(data == null || data.length <= 0){
			return;
		}
		int len = data.length;
		for(int i = 1;i<len;i++){
			T temp = data[i];
			int low = 0;
			int high = i-1;
			while(low<=high){
				int mid = low+((high-low) >> 1);
			    if(temp.compareTo(data[mid]) < 0)
			    	high = mid - 1;
			    else {
					low = mid + 1;
				}
			}
			for(int j = i-1;j>= low;j--)
				data[j+1] = data[j];
			data[low] = temp; 
		}
		System.out.println(Arrays.toString(data));
	}

}
