/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations排列.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * 方法1：插入法 与subset I的方法2很相近。以题中例子说明： 当只有1时候：[1] 当加入2以后：[2, 1], [1, 2] 当加入3以后：[3,
 * 2, 1], [2, 3, 1], [2, 1, 3], [3, 1, 2], [1, 3, 2], [1, 2, 3]
 * 前3个permutation分别对应将3插入[2, 1]的0, 1, 2的位置。同理后3个为插入[1,
 * 2]的。因此可以用逐个插入数字来构造所有permutations。
 * 
 * 递归方法
 */
public class Permutations {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(permute3(nums).toString());
	}

	// 递归方法1
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return result;
		int start = 0;
		permute(nums, start, result);
		return result;
	}

	private static void permute(int[] nums, int start, List<List<Integer>> result) {
		if (start == nums.length) {
			List<Integer> item = new ArrayList<>();
			for (int k = 0; k < nums.length; k++) {
				item.add(nums[k]);
			}
			result.add(new ArrayList<>(item));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			permute(nums, start + 1, result);
			swap(nums, i, start);
		}
	}

	private static void swap(int[] nums, int start, int i) {
		if (start == i)
			return;
		int temp = nums[start];
		nums[start] = nums[i];
		nums[i] = temp;
	}

	// 递归方法2
	public static List<List<Integer>> permute2(int[] nums) {
		ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null) {
			return rst;
		}

		if (nums.length == 0) {
			rst.add(new ArrayList<Integer>());
			return rst;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(rst, list, nums);
		return rst;
	}

	public static void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) {
				continue;
			}
			list.add(nums[i]);
			helper(rst, list, nums);
			list.remove(list.size() - 1);
		}

	}

	// 非递归方法
	public static List<List<Integer>> permute3(int[] nums) {
		ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if (nums == null) {

			return permutations;
		}

		if (nums.length == 0) {
			permutations.add(new ArrayList<Integer>());
			return permutations;
		}

		int n = nums.length;
		ArrayList<Integer> stack = new ArrayList<Integer>();

		stack.add(-1);
		while (stack.size() != 0) {
			Integer last = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);

			// increase the last number
			int next = -1;
			for (int i = last + 1; i < n; i++) {
				if (!stack.contains(i)) {
					next = i;
					break;
				}
			}
			if (next == -1) {
				continue;
			}

			// generate the next permutation
			stack.add(next);
			for (int i = 0; i < n; i++) {
				if (!stack.contains(i)) {
					stack.add(i);
				}
			}

			// copy to permutations set
			ArrayList<Integer> permutation = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				permutation.add(nums[stack.get(i)]);
			}
			permutations.add(permutation);
		}

		return permutations;
	}
}
