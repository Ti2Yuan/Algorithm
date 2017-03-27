/**
 * 
 */
package stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**4Sum
 * 
 *Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 *Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Sum4 {

	public static void main(String[] args) {
	}

	//A typical k-sum problem. Time is N to the power of (k-1).O(n^(k-1))
	public static List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length <= 0)
			return result;
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i<len-3; i++){
			if(i != 0 && nums[i] == nums[i-1])
				continue;
			for(int j = i+1; j<len-2; j++){
				if(j != i+1 && nums[j] == nums[j-1])
					continue;
				int start = j+1;
				int end = len-1;
				while(start < end){
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					if(sum == target){
						List<Integer> item = new ArrayList<>();
						item.add(nums[i]);
						item.add(nums[j]);
						item.add(nums[start]);
						item.add(nums[end]);
						result.add(item);
						start++;
						end--;
						while(start < end && nums[start] == nums[start-1])
							start++;
						while(start < end && nums[end] == nums[end+1])
							end--;
					}else if(sum <target){
						start++;
					}else{
						end--;
					}
				}
			}
		}
		return result;
	}
}
