/**
 * 
 */
package com.chen.datastructure.sorter;

import java.util.Comparator;

/**
 * 冒泡排序几乎是个程序员都写得出来，但是面试的时候如何写一个逼格高的冒泡排序却不是每个人都能做到
 * 
 * 时间复杂度是O(N^2)
 */
public class BubbleSorter {

	public interface Sorter{
		
		/**
		 * 排序
		 * TODO
		 * @param list 待排序数组
		 * void
		 */
		public <T extends Comparable<T>> void sort(T[] list);
		
		/**
		 * 排序
		 * TODO
		 * @param list 待排序数组
		 * @param comp  比较两个对象的比较器
		 * void
		 */
		public <T> void sort(T[] list, Comparator<T> comp);
	}
	
	/**
	 * 冒泡排序
	 *
	 */
	public class Bubble implements Sorter{

		/* TODO
		 * @see com.chen.datastructure.sorter.BubbleSorter.Sorter#sort(java.lang.Comparable[])
		 * @param list
		 */
		@Override
		public <T extends Comparable<T>> void sort(T[] list) {
			// TODO Auto-generated method stub
			boolean swapped = true;
			int i = 1;
			int len = list.length;
			while(swapped){
				swapped = false;
				for(int j = 0;j<len - i;j++){
					if(list[j].compareTo(list[j+1]) > 0){
						T temp = list[j];
						list[j] = list[j+1];
						list[j+1] = temp;
						swapped = true;
					}
				}
			}
		}

		/* TODO
		 * @see com.chen.datastructure.sorter.BubbleSorter.Sorter#sort(java.lang.Object[], java.util.Comparator)
		 * @param list
		 * @param comp
		 */
		@Override
		public <T> void sort(T[] list, Comparator<T> comp) {
			// TODO Auto-generated method stub
			boolean swapped = true;
			for(int i = 1,len = list.length;i<len && swapped;i++){
				swapped = false;
				for(int j = 0;j<len - i;j++){
					if(comp.compare(list[j], list[j+1]) > 0){
						T temp = list[j];
						list[j] = list[j+1];
						list[j+1] = temp;
						swapped = true;
					}
				}
			}
		}
		
	}
}
