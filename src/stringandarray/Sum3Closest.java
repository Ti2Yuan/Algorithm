/**
 * 
 */
package stringandarray;

import java.util.Arrays;

/**
 * 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 *  Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Sum3Closest {

	public static void main(String[] args) {
	}

	public static int threeSumClosest(int[] nums, int target){
		if(nums == null || nums.length <= 0)
			return 0;
		int len = nums.length;
		Arrays.sort(nums);
		int result = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<len; i++){
			int start = i+1;
			int end = len-1;
			while(start < end){
				int sum = nums[i]+nums[start]+nums[end];
				int diff = Math.abs(target-sum);
				if(diff == 0)
					return sum;
				if(diff < min){
					min = diff;
					result = sum;
				}
				if(sum > target){
					end--;
				}else{
					start++;
				}
			}
		}
		return result;
	}
}
