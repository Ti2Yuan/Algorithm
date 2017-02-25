/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 折半查找，也称二分查找、二分搜索，是一种在有序数组中查找某一特定元素的搜索算法。
 * 搜素过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜素过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组已经为空，则表示找不到指定的元素。 这种搜索算法每一次比较都使搜索范围缩小一半，其时间复杂度是O(logN)。
 */
public class BinarySearch {

	public static void main(String[] args) {
		Integer[] x = new Integer[] { 2, 5, 7, 10, 3, 9, 20 };
		Arrays.sort(x);
		System.out.println(Arrays.toString(x));
		System.out.println(binarySearch(x, 9, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if ((o1 - o2) > 0)
					return 1;
				else if ((o1 - o2) == 0) {
					return 0;
				}
				return -1;
			}
		}));
		System.out.println(binarySearchByRecursive(x, 0, x.length - 1, 9));
	}

	/**
	 * 需要注意的是计算中间位置时不应该使用(high+ low) / 2的方式，因为加法运算可能导致整数越界，
	 * 这里应该使用以下三种方式之一：low + (high – low) / 2或low + (high – low) >> 1或(low + high) >>> 1（>>>是逻辑右移，是不带符号位的右移） 
	 * TODO
	 * @param x
	 * @param key
	 * @param comp
	 * @return int
	 */

	// 循环实现的二分查找
	public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
		if (x == null || x.length == 0)
			return -1;
		int low = 0;
		int high = x.length - 1;
		int mid = 0;
		while (low <= high) {
			 // mid = (low + high) >> 1; 不应该这么写，可能会导致整数越界
			mid = low + (high - low) >> 1;
			if (comp.compare(key, x[mid]) == 0) {
				return mid;
			} else if (comp.compare(key, x[mid]) > 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// 递归实现二分查找
	public static <T extends Comparable<T>> int binarySearchByRecursive(T[] x, int low, int high, T key) {
		if (low <= high) {
			int mid = low + (high - low) >> 1;
			if (key.compareTo(x[mid]) == 0) {
				return mid;
			} else if (key.compareTo(x[mid]) > 0) {
				return binarySearchByRecursive(x, mid + 1, high, key);
			} else {
				return binarySearchByRecursive(x, low, mid - 1, key);
			}
		}
		return -1;

	}
}
