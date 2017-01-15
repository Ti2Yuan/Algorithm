/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 * 
 * 方法就是对于重复的元素循环时跳过递归函数的调用，只对第一个未被使用的进行递归，
 * 我们那么这一次结果会出现在第一个的递归函数结果中，而后面重复的会被略过。
 * 如果第一个重复元素前面的元素还没在当前结果中，那么我们不需要进行递归。
 * 想明白了这一点，代码其实很好修改。首先我们要对元素集合排序，从而让重复元素相邻，
 * 接下来就是一行代码对于重复元素和前面元素使用情况的判断即可。
 */
public class Permutations2 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2 };
		System.out.println(permuteUnique2(nums).toString());
	}

	// solution 1
	public static List<List<Integer>> permuteUnique2(int[] nums) {
		
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		
		if (nums == null) {
			return results;
		}
		
		if (nums.length == 0) {
			results.add(new ArrayList<Integer>());
			return results;
		}
		
		Arrays.sort(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] visited = new int[nums.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		
		helper(results, list, visited, nums);
		return results;
	}
	
	public static void helper(ArrayList<List<Integer>> results, ArrayList<Integer> list, int[] visited, int[] nums) {
		
		if (list.size() == nums.length) {
			results.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
				continue;
			}
			/*
			 * 上面的判断主要是为了去除重复元素影响。 比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
			 * 我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
			 * 当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就 不应该让后面的2使用。
			 */
			visited[i] = 1;
			list.add(nums[i]);
			helper(results, list, visited, nums);
			list.remove(list.size() - 1);
			visited[i] = 0;
		}
	}
	
	
	// solution 2
	//not correct, need to be improve.
//	public static List<List<Integer>> permuteUnique(int[] nums) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		if (nums == null || nums.length == 0)
//			return result;
//		// 先排序
//		Arrays.sort(nums);
//		boolean[] visited = new boolean[nums.length];
//		Arrays.fill(visited, false);
//		int start = 0;
//		permute(nums, start, result,visited);
//		return result;
//	}
//
//	private static void permute(int[] nums, int start, List<List<Integer>> result,boolean[] visited) {
//		if (start == nums.length) {
//			List<Integer> item = new ArrayList<>();
//			for (int k = 0; k < nums.length; k++) {
//				item.add(nums[k]);
//			}
//			result.add(new ArrayList<>(item));
//			return;
//		}
//		for (int i = start; i < nums.length; i++) {
//			if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
//				continue;
//			}
//			visited[i] = true;
//			swap(nums, start, i);
//			permute(nums, start + 1, result,visited);
//			swap(nums, i, start);
//			visited[i] = false;
//		}
//	}
//
//	private static void swap(int[] nums, int start, int i) {
//		if (start == i)
//			return;
//		int temp = nums[start];
//		nums[start] = nums[i];
//		nums[i] = temp;
//	}

}
