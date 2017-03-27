/**
 * 
 */
package stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *3Sum
 *
 *Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 *Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Sum3 {

	public static void main(String[] args) {
		int[] nums = new int[]{-1,0,1,2,-1,4};
		System.out.println((threeSum(nums)));
	}

	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return result;
		int len = nums.length;
		Arrays.sort(nums);
		if(len < 3)
			return result;
		//time complexity O(n^2)
		for(int i = 0; i<len-2; i++){
			if(nums[i] > 0)
				break;
			if(i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i+1;
			int end = len-1;
			while(start < end){
				int sum = nums[i] + nums[start] + nums[end]; 
				if(sum == 0){
					List<Integer> item = new ArrayList<>();
					item.add(nums[i]);
					item.add(nums[start]);
					item.add(nums[end]);
					result.add(item);
					start++;
					end--;
					while(start < end && nums[start] == nums[start-1])
						start++;
					while(start < end && nums[end] == nums[end+1])
						end--;
				}else if(sum > 0){
					end--;
				}else{
					start++;
				}
			}
		}
		return result;
	}
}
