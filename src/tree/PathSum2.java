/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum 2
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSum2 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		List<Integer> item = new ArrayList<>();
		helper(root,sum,result,item);
		return result;
	}

	private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> item) {
		if(root.val == sum && root.left == null && root.right == null){
			item.add(root.val);
			result.add(new ArrayList<>(item));
			item.remove(item.size()-1);
		}		
		if(root.left != null){
			item.add(root.val);
			helper(root.left, sum-root.val, result, item);
			item.remove(item.size()-1);
		}
		if(root.right != null){
			item.add(root.val);
			helper(root.right, sum-root.val, result, item);
			item.remove(item.size()-1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
