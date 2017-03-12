/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Arrays;

/**
 * 归并排序 时间复杂度O(nlog2n) 空间复杂度O(n)之间 稳定
 */
public class MergeSorter {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[] { 1, 4, 7, 8, 9, 1, 5, 10, 18, 23, 41, 19 };
		mergeSort(data);
		System.out.println(Arrays.toString(data));
	}

	public static void mergeSort(int[] data) {
		if (data == null || data.length <= 0) {
			return;
		}
		int len = data.length;
		mergeSortRecursively(data, 0, len - 1);
	}

	private static void mergeSortRecursively(int[] data, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSortRecursively(data, start, mid);
			mergeSortRecursively(data, mid + 1, end);
			merge(data, start, mid, end);
		}
	}

	private static void merge(int[] data, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int[] copy = new int[end+1];
		int index = start;
		while (i <= mid && j <= end) {
			if(data[i] <= data[j]) {
				copy[index++] = data[i++];
			}
			else{
				copy[index++] = data[j++];
			}
		}
		if (i <= mid) {
			while (i <= mid) {
				copy[index++] = data[i++];
			}
		}
		if (j <= end) {
			while (j <= end) {
				copy[index++] = data[j++];
			}
		}
		for (int k = start; k <= end; k++) {
			data[k] = copy[k];
		}
	}

}
