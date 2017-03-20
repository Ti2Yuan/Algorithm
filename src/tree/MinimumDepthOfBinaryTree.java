/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l = root.left = new TreeNode(2);
		TreeNode r = root.right = new TreeNode(3);
		l.left = new TreeNode(4);
		l.right = new TreeNode(5);
		minDepthByQueue(root);
	}

	/**
	 * 
	 * TODO 递归求解最小的深度
	 * @param root
	 * @return
	 * int
	 */
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		if(leftDepth != 0 && rightDepth != 0){
		return leftDepth <= rightDepth ? leftDepth + 1 : rightDepth + 1;
		}
		else if (leftDepth == 0) {
			return rightDepth+1;
		}else {
			return leftDepth+1;
		}
	}
	
	/**
	 * 
	 * TODO 利用队列的思想存储层数，若这层中某一结点的左右子树缺失了，就是最少深度，比递归少遍历结点
	 * @param root
	 * @return
	 * int
	 */
	public static int minDepthByQueue(TreeNode root){
		if(root == null)
			return 0;
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> counts = new LinkedList<>();  //存储对应结点的深度
		
		nodes.add(root);
		counts.add(1);
		while(!nodes.isEmpty()){
			TreeNode node = nodes.poll();
			int val = counts.poll();
			if(node.left != null){
				nodes.add(node.left);
				counts.add(val+1);
			}
			if (node.right != null) {
				nodes.add(node.right);
				counts.add(val+1);
			}
            if(node.left == null && node.right == null){
				return val;
			}
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
