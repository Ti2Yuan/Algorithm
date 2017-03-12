/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;

/**
 * 简单选择排序
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)之间
 * 不稳定
 */
public class SelectSorter {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = new Integer[]{1,4,7,8,9,1,5,10,18,23,41,19};
		selectSort(data);
		System.out.println(Arrays.toString(data));
	}
	
	public static <T extends Comparable<T>>  void selectSort(T[] r){
		if(r == null || r.length <= 0)
			return;
		int n = r.length;
		T temp;
		for(int i = 0;i<n-1;i++){
			int k = i;
			for(int j = i+1;j<n;j++){
				if(r[j].compareTo(r[k]) < 0)
					k = j;
			}
			if(k != i){
				temp = r[i];
				r[i] = r[k];
				r[k] = temp;
			}
		}
	}

}
