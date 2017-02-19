/**
 * 
 */
package com.chen.offer;

import java.util.HashMap;

/**
 * 数组中重复的数字 
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 */
public class dumplicateInArray {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,
	// so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication
	// in C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications
	// in the array number
	// otherwise false
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || numbers.length == 0 || numbers.length != length)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (map.containsKey(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			}
			map.put(numbers[i], i);
		}
		return false;
	}

	/**
	 * 以数组｛2，3，1，0，2，5，3｝为例来分析找到重复数字的步骤。数组的第0个数字（从0开始计数，和数组的下标保持一致）是2，与它的下标不想等，
	 * 于是把它和下标为2的数字1交换，交换后的数组是｛1，3，2，0，2，5，3｝。此时第0
	 * 个数字是1，仍然与它的下标不想等，继续把它和下标为1的数字3交换，得到数组｛0，1，2，3，2，5，3｝。此时第0
	 * 个数字为0，接着扫描下一个数字，在接下来的几个数字中，下标为1，2，3的三个数字分别为1，2，3，他们的下标和数值都分别相等，因此不需要做任何操作。
	 * 接下来扫描下标为4的数字2.由于它的值与它的下标不登，再比较它和下标为2的数字。注意到此时数组中下标为2的数字也是2，
	 * 也就是数字2和下标为2和下标4的两个位置了，因此找到一个重复的数字。
	 * 
	 * 在代码中尽管有一两个重复现年换，但每个数字最多只要交换两次就能找到属于自己的位置，因此总的时间复杂度为O(n)，
	 * 另外，所有的操作步骤都是在输入数组上进行，不需要额外的分配内存，因此空间复杂度为O(1).
	 */
	public static boolean duplicate2(int numbers[], int length, int[] duplication) {
		if (numbers == null || numbers.length == 0 || numbers.length != length)
			return false;
		for (int i = 0; i < length; i++) {
			while(numbers[i] != i){
				if(numbers[i] == numbers[numbers[i]]){
					duplication[0] = numbers[i];
					return true;
				}else{
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			}
		}
		return false;
	}
	
}
