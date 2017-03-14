/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree {
	
	public static void main(String[] args){
		ValidateBinarySearchTree vTree = new ValidateBinarySearchTree();
		TreeNode root = vTree.new TreeNode(10);
		TreeNode a = vTree.new TreeNode(5);
		TreeNode b = vTree.new TreeNode(15);
		TreeNode c = vTree.new TreeNode(3);
		TreeNode d = vTree.new TreeNode(7);
		TreeNode e = vTree.new TreeNode(13);
		TreeNode f = vTree.new TreeNode(18);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		System.out.println(vTree.isValidBST3(root));
	}

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
	
	//Recursive method 1
	public boolean isValidBST1(TreeNode root){
		return helper(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
	}

	private boolean helper(TreeNode root, double min, double max) {
		if(root == null)
			return true;
		if(root.val <= min || root.val >= max)
			return false;
		return helper(root, min, root.val) && helper(root, root.val, max);
	}
	
	//Recursive method 2
	public boolean isValidBST2(TreeNode root){
		if(root == null)
			return true;
		return helper2(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	
	private boolean helper2(TreeNode root, double low, double high) {
		if(root.val <= low || root.val >= high)
			return false;
		if(root.left != null && !helper2(root.left, low, root.val)){
			return false;
		}
		if(root.right != null && !helper2(root.right, root.val, high)){
			return false;
		}
		return true;
	}
	
	
	//Iterative
	public boolean isValidBST3(TreeNode root){
		if(root == null)
			return true;
		Queue<BNode> queue = new LinkedList<>();
		queue.offer(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
		
		while(!queue.isEmpty()){
			BNode bNode = queue.poll();
			int val = 0;
			if((val= bNode.node.val) <= bNode.low || val >= bNode.high){
				return false;
			}
			if(bNode.node.left != null){
				queue.offer(new BNode(bNode.node.left, bNode.low, val));
			}
			
			if(bNode.node.right != null){
				queue.offer(new BNode(bNode.node.right, val, bNode.high));
			}
		}
		return true;
	}
	
	public class BNode{
		TreeNode node;
		double low;
		double high;
		public BNode(TreeNode node, double low, double high){
			this.node = node;
			this.low = low;
			this.high = high;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
