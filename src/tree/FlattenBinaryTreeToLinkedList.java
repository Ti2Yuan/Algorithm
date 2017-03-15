/**
 * 
 */
package tree;

import java.util.Stack;

/** 
 * Flatten Binary Tree to Linked List
 * 
 *  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTreeToLinkedList {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		/**
		 * Constructor
		 */
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Go down through the left, when right is not null, push right to stack.
	 * TODO
	 * @param root
	 * void
	 */
	public void flatten(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode p = root;
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			
			if(node.right != null){
				stack.push(node.right);
			}
			
			if(node.left != null){
				stack.push(node.left);
			}
			
			if(node != p){
				p.right = node;
				p.left = null;
				p = node;
			}
		}
	}
	
	//post order traversal recursively
	private TreeNode prev = null;
	public void flatten2(TreeNode root){
		if(root == null)
			return;
		flatten2(root.right);
		flatten2(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
