/**
 * 
 */
package tree;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 */
public class BalancedBinaryTree {

	public static boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		int[] height = new int[1];
		return helper(root,height);
	}

	private static boolean helper(TreeNode root, int[] height) {
		if(root == null){
			height[0] = 0;
			return true;
		}
		int[] l = new int[1];
		int[] r = new int[1];
		if(helper(root.left, l) && helper(root.right, r)){
			if(Math.abs(l[0]-r[0]) > 1){
				return false;
			}else{
				height[0] = Math.max(l[0], r[0]) + 1;
				return true;
			}
		}
		return false;
	}
}
