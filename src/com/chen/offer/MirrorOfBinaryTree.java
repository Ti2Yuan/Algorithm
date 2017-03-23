/**
 * 
 */
package com.chen.offer;

/**
 *  二叉树的镜像
 */
public class MirrorOfBinaryTree {

	protected static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		
	}

	public static void mirrorRecursively(TreeNode root){
		if(root == null)
			return;
		
		if(root.left == null && root.right == null)
			return;
		
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		
		mirrorRecursively(root.left);
		mirrorRecursively(root.right);
	}
}
