/**
 * 
 */
package tree;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

 *思路：递归方法
 */
public class SymmetricTree {

	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.right = node5;
		System.out.println(isSymmetric(node1));
	}
	
	public static boolean isSymmetric(TreeNode root){
		if(root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null && right == null){
			return true;
		}else if(left == null || right == null){
			return false;
		}
		
		//两个节点都不为空
		if(left.val != right.val){
			return false;
		}
//		if(!isSymmetric(left.left, right.right)){
//			return false;
//		}
//		if(!isSymmetric(left.right, right.left)){
//			return false;
//		}
//		return true;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
