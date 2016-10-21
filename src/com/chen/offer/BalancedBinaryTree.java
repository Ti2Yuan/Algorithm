package com.chen.offer;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author chenti
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode A = new TreeNode('A');
		TreeNode B = new TreeNode('B');
		TreeNode C = new TreeNode('C');
		TreeNode D = new TreeNode('D');
		TreeNode E = new TreeNode('E');
		TreeNode F = new TreeNode('F');
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		D.left = F;
		boolean isBalancedBinaryTree = isBalanced(A);
		System.out.println(isBalancedBinaryTree);
	}

	private static boolean isBalanced(TreeNode rootNode) {
		return determine(rootNode) >= 0 ? true : false;
	}

	private static int determine(TreeNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		int leftDepth = determine(rootNode.left);
		int rightDepth = determine(rootNode.right);
		if (leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		char value;

		public TreeNode(char value) {
			this.value = value;
		}
	}

}
