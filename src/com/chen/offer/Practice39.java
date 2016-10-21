package com.chen.offer;

import com.chen.offer.BalancedBinaryTree.TreeNode;


/**
 * 剑指offer第39题
 * 题目一：求二叉树树的深度
 * 题目二：判断树是否是平衡二叉树
 * @author chenti
 *
 */
public class Practice39 {

	public static void main(String[] args) {
		Practice39 p = new Practice39();
		TreeNode root = p.constructTree();
		Depth depth = new Depth();
		//题目一
		System.out.println(p.treeDepth(root));
		//题目二
		System.out.println(p.isBalancedTree(root));
		System.out.println(p.isBalancedTree(root,depth));
	}

	/**
	 * 求二叉树是否是平衡二叉树
	 * 一次遍历
	 * 我们用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们已经遍历了它的左右子树。
	 * 只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶节点的路径的长度），
	 * 我们就可以一边遍历一边判断每个结点是不是平衡的 
	 * @param root
	 * @param depth   //必须是一个引用，基本类型不行
	 * @return
	 */
	private boolean isBalancedTree(TreeNode root, Depth depth) {
		if(root == null){
			depth.height = 0;
			return true;
		}
		Depth left = new Depth();
		Depth right = new Depth();
		if(isBalancedTree(root.left, left) && isBalancedTree(root.right, right)){
			int diff = Math.abs(left.height - right.height);
			if(diff <= 1){
				depth.height = left.height > right.height?left.height+1:right.height+1;
				System.out.println("结点是"+root.value+" depth is "+depth.height);
				return true;
			}
		}
		return false;
	}
	
	private static class Depth{
		int height;
	}

	/**
	 * 求二叉树是否是平衡二叉树
	 * 这种方式多次遍历二叉树结点，效率不高
	 * @param root
	 * @return
	 */
	private boolean isBalancedTree(TreeNode root) {
		if(root == null)
			return true;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int diff = Math.abs(left-right);
		if(diff > 1){
			return false;
		}
		return isBalancedTree(root.left) && isBalancedTree(root.right);
	}

	/**
	 * 求二叉树的深度
	 * @return
	 */
	private int treeDepth(TreeNode root) {
		if(root == null)
			return 0;
		int leftDepth = treeDepth(root.left);
		int rightDepth = treeDepth(root.right);
		
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}

	private TreeNode constructTree() {
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
		return A;
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
