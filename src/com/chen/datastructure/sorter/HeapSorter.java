/**
 * 
 */
package com.chen.datastructure.sorter;

/**
 * 堆排序
 * 时间复杂度O(nlog2n)
 * 空间复杂度O(1)之间
 * 不稳定
 */
public class HeapSorter {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r = new int[]{8,3,0,12,6,23,78};
		heapSort(r);
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
}
