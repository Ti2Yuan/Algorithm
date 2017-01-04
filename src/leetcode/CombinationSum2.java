/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 */
public class CombinationSum2 {

	public static void main(String[] args) {

		int[] candidates = new int[]{10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> resultList = combinationSum2(candidates, target);
		for (List<Integer> list : resultList) {
			for (Integer integer : list) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			//当下标>0并且元素值不等于前一个大时
			if(i > index && candidates[i] == candidates[i - 1])
				continue;
			item.add(candidates[i]);
			helper(candidates, target - candidates[i], i+1, item, solution);
			item.remove(item.size()-1);
		}
	}
}
