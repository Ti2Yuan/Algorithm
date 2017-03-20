/**
 * 
 */
package tree;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Binary Tree Maximum Path Sum (Leetcode hard)
 * 
 * Given a binary tree, find the maximum path sum.

 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 * The path must contain at least one node and does not need to go through the root.

 * For example:
 * Given the below binary tree,
       1
      / \
     2   3
 * Return 6.
 * 
 * 思路：
1. 与常规path sum不同，这题的path sum可以不起始于root，也可以不终止于leaf。

2. 这样的path可以归纳为两种情况：
(1) root->leaf path中的一段：即题目例子中的1-2或1-3。
(2) 两个节点之间经过它们lowest common ancestor (LCA)的path：即题目中的2-1-3。

3. 显然top-down的递归并不适用于这题，因为对于类型(2)的path，它的path sum同时取决于LCA左右sub path的最大值。而这样的path sum是无法通过top-down传递来获取的。

4. 所以这里可以采用bottom-up的递归方法:
对于节点x:
定义PS1(x)为从x出发向leaf方向的第一类path中最大的path sum。
定义PS2(x)为以x为LCA的第二类path中的最大path sum。
显然如果我们求得所有节点x的PS1 & PS2，其中的最大值必然就是要求的max path sum。

5. 如何求PS1(x)、PS2(x)?
(1) PS1(x) 、PS2(x)至少应该不小于x->val，因为x自己就可以作为一个单节点path。
(2) PS1(x) 、 PS2(x)可以从PS1(x->left)和PS1(x->right)来求得：
PS1(x) = max [ max(PS1(x->left), 0), max(PS1(x->right), 0) ] + x->val
PS2(x) = max(PS1(x->left), 0) + max(PS1(x->right), 0) + x->val
注意这里并不需要PS2(x->left) 以及 PS2(x->right) 因为子节点的2型path无法和父节点构成新的path。

6. 需要返回PS1(x)以供上层的节点计算其PS1 & PS2.

7. 对于leaf节点：PS1(x) = PS2(x) = x->val.
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
	}
	
	/**
	 * 
	 * TODO bottom-up递归
	 * @param root
	 * @return
	 * int
	 */
	public static int maxPathSum(TreeNode root){
		if(root == null)
			return 0;
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		helper(root,max);
		return max[0];
	}

	private static int helper(TreeNode root, int[] max) {
		if(root == null)
			return 0;
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		
		int current = Math.max(root.val, Math.max(left+root.val, right+root.val));
		max[0] = Math.max(max[0], Math.max(left+right+root.val, current));
		return current;
	}
	
}
