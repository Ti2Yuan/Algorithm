/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent(相邻), with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {

	public static void main(String[] args) {
		int[] nums = new int[]{2,1,0};
		sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	//一次遍历,遇到0就与第一个1替换，再与第一个2替换，遇到1就与第一个2替换，遇到2就继续向前
	public static void sortColors2(int[] nums){
		if(nums == null || nums.length <= 0)
			return;
		int index0 = 0;
		int index1 = 0;
		int index2 = 0;
		for(int i = 0, len = nums.length; i<len; i++){
			if(nums[i] == 0){
				swap(nums, i, index1);
				if(index1 < index2){
					swap(nums, i, index2);
				}
				index1++;
				index2++;
			}else if(nums[i] == 1){
				swap(nums, i, index2);
				index2++;
			}else{
				
			}
		}
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	//两次遍历，第一次遍历，记录下0,1,2的个数，第二次遍历，依次赋值0,1,2.
	public static void sortColors(int[] nums){
		if(nums == null || nums.length <= 0)
			return;
		int countR = 0;
		int countW = 0;
		int countB = 0;
		for(int i = 0, len = nums.length; i<len; i++){
			if(nums[i] == 0){
				countR++;
			}else if(nums[i] == 1){
				countW++;
			}else{
				countB++;
			}
		}
		int i = 0;
		while(countR > 0){
			nums[i] = 0;
			countR--;
			i++;
		}
		while(countW > 0){
			nums[i] = 1;
			countW--;
			i++;
		}
		while(countB > 0){
			nums[i] = 2;
			countB--;
			i++;
		}
	}
}
