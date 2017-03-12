/**
 * 
 */
package com.chen.offer;

import java.util.Stack;

/**
 * 找到二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶子节点所经过的结点形成一条路径
 * 
 * 利用栈存储路径
 * 递归（深度优先搜索）
 * 
 */
public class FindPath {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public void findPath(TreeNode root, int value){
		if(root == null)
			return;
		Stack<Integer> path = new Stack<>();
		find(root, value, path);
	}
	
	public void find(TreeNode root, int value, Stack<Integer> path){
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			if(root.val == value){
				for (int i : path) {
					System.out.print(i+" ");
				}
				System.out.println(value);
			}
		}else {
			path.push(root.val);
			if(root.left != null)
				find(root.left, value-root.val, path);
			if(root.right != null)
				find(root.right, value-root.val, path);
            path.pop();
		}
	}
}
