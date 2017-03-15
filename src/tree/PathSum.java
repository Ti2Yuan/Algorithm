/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

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
	
	/**
	 * 递归方法
	 * TODO
	 * @param root
	 * @param sum
	 * @return
	 * boolean
	 */
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null)
			return false;
		return helper(root,sum);
		
		/*下面是改进版递归方法*/
//		if(root == null)
//			return false;
//		if(root.val == sum && root.left == null && root.right == null)
//			return true;
//		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}

	private boolean helper(TreeNode root, int sum) {
		if(root.val == sum && root.left == null && root.right == null)
			return true;
		boolean left = false;
		if(root.left != null){
			left = helper(root.left, sum-root.val);
		}
		boolean right = false;
		if(root.right != null){
		    right = helper(root.right, sum-root.val);
		}
		return left || right;
	}
	
	/**
	 * Add all node to a queue and store sum value of each node to another queue.
	 * When it is a leaf node, check the stored sum value.
	 * For the tree above, the queue would be:5-4-8-11-13-4-7-2-1.
	 * It will check node 13,7,2,1.
	 * This is a typical breadth first search(BFS) problem.
	 * 
	 * 利用两个队列辅助
	 * TODO
	 * @param root
	 * @param sum
	 * @return
	 * boolean
	 */
	public boolean hasPathSum2(TreeNode root, int sum){
		if(root == null)
			return false;
		
		Queue<TreeNode> nodesQueue = new LinkedList<>();
		Queue<Integer> valueQueue = new LinkedList<>();
		
		nodesQueue.offer(root);
		valueQueue.offer(root.val);
		
		while(!nodesQueue.isEmpty()){
			TreeNode currNode = nodesQueue.poll();
			int currValue = valueQueue.poll();
			
			if(currValue == sum && currNode.left == null && currNode.right == null){
				return true;
			}
			
			if(currNode.left != null){
				nodesQueue.offer(currNode.left);
				valueQueue.offer(currValue+currNode.left.val);
			}
			
			if(currNode.right != null){
				nodesQueue.offer(currNode.right);
				valueQueue.offer(currValue+currNode.right.val);
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
