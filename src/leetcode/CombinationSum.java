/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3] ]
 * 
 * solution: first,sort the input array
 * 
 * 这个题是一个NP问题，方法仍然是N-Queens中介绍的套路。基本思路是先排好序，
 * 然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，
 * 然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。算法复杂度因为是NP问题，所以自然是指数量级的。
 */
public class CombinationSum {

	public static void main(String[] args) {

		int[] candidates = new int[] { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> solution = combinationSum(candidates, target);
		for (List<Integer> list : solution) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> solution = new ArrayList<>();
    	if(candidates == null || candidates.length == 0 || target < 0){
    		return solution;
    	}
    	Arrays.sort(candidates);
    	List<Integer> item = new ArrayList<>();
        helper(candidates,target,0,item,solution);
        return solution;
    }

	private static void helper(int[] candidates, int target, int index, List<Integer> item, List<List<Integer>> solution) {
		if(target < 0)
			return;
		if(target == 0){
			solution.add(new ArrayList<>(item));
			return;
		}
		for(int i = index;i<candidates.length;i++){
			//当当前元素已小于target时，不向后遍历，因为数组升序排列
			if(candidates[i] > target)
				break;
			item.add(candidates[i]);
			helper(candidates, target - candidates[i], i, item, solution);
			item.remove(item.size()-1);
		}
	}
}
