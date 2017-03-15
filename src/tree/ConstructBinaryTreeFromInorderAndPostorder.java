/**
 * 
 */
package tree;

import com.chen.concurrent.Code_8_11.Node;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Analysis

This problem can be illustrated by using a simple example.

in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)
From the post-order array, we know that last element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.

Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. Recursively, we can build up the tree.

For this example, the constructed tree is:
1/\23/\4578/\####6###
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

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
	 * 根据中序遍历和后序遍历构造二叉树
	 * TODO
	 * @param inorder
	 * @param postorder
	 * @return
	 * TreeNode
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder){
		TreeNode root = null;
		if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return root;
		if(inorder.length != postorder.length)
			return root;
		root = buildHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
		return root;
	}

	/**递归构造二叉树，先找到根节点，再分别构造左右子树
	 * TODO
	 * @param inorder
	 * @param i
	 * @param j
	 * @param postorder
	 * @param k
	 * @param l
	 * @return
	 * TreeNode
	 */
	private TreeNode buildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if(inStart == inEnd && postStart == postEnd){
			TreeNode node = new TreeNode(inorder[inStart]);
			return node;
		}
		int val = postorder[postEnd];
		TreeNode root = new TreeNode(val);
		int i = inStart;
		while(i <= inEnd && inorder[i] != val){
			i++;
		}
		int leftLen = i - inStart;
		int rightLen = inEnd - i;
		if(leftLen > 0){
			root.left = buildHelper(inorder, inStart, inStart+leftLen-1, postorder, postStart, postStart+leftLen-1); 
		}
		if(rightLen > 0){
			root.right = buildHelper(inorder, inEnd - rightLen + 1, inEnd, postorder, postEnd-rightLen, postEnd-1);
		}
		return root;
	}
}
