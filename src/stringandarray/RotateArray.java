/**
 * 
 */
package stringandarray;

import java.util.Arrays;

/**
 *Rotate Array
 *
 *Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * solution-reversal
	 * 
	 * 1.divide the array into two parts:1,2,3,4 and 5,6,7
	 * 2.reverse first part:4,3,2,1
	 * 3,reverse second part:7,6,5
	 * 4,reverse the whole array:7,6,5,1,2,3,4
	 */
	public static void rotate(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return;
		if(nums.length < k){
			k = k % nums.length;
		}
		reverse(nums,0,nums.length-k-1);
		reverse(nums,nums.length-k, nums.length-1);
		reverse(nums, 0, nums.length-1);
	}
	
	public static void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
