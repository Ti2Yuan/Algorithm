/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.List;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * 二叉树两节点的最低公共祖先结点
 * 
 * 对于给定二叉树，输入两个树节点，求它们的最低公共祖先
 * 
 * 特殊情况一：节点带有指向父节点的指针的二叉树
 * 
 * 特殊情况二：二叉搜索树
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * 
 * 特殊情况三：传统二叉树
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 * 思路一： 自底向上递归
 * 思路二：利用栈存储根节点到两个节点的路径，然后把问题转换为两个链表的最后公共结点。
 */
public class LowestCommonAncestor {

	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;
//		System.out.println(lowestCommonAncestorOfaBinarySearchTree(node1, node4, node9).val);
		System.out.println(getLastCommonParent(node1, node2, node8).val);
	}

	public static TreeNode findLowestCommonAncestor(TreeNode root, int x ,int y){
		TreeNode result = null;
		if(root == null){
			return result;
		}
		TreeNode p = isExist(root,x);
		if(p == null){
			return result;
		}
		TreeNode q = isExist(root, y);
		if(q == null){
			return result;
		}
		return lowestCommonAncestor(root, p, q);
	}
	
	private static TreeNode isExist(TreeNode root, int x){
		if(root == null){
			return null;
		}
		if(root.val == x){
			return root;
		}
		TreeNode node = isExist(root.left, x);
		if(node != null)
			return node;
		TreeNode node2 = isExist(root.right, x);
		return node2;
	}

	/**
	 * TODO 传统二叉树，自底向上遍历二叉树
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 * TreeNode
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		
		if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		TreeNode nodeLeft = lowestCommonAncestor(root.left, p, q);
		TreeNode nodeRight = lowestCommonAncestor(root.right, p, q);
		if(nodeLeft != null && nodeRight != null){
			return root;
		}
		return nodeLeft == null ? nodeRight:nodeLeft;
		
		//美团笔试时写的递归算法，大量重复计算
		/*if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		TreeNode nodeLeft = lowestCommonAncestor(root.left, p, q);
		TreeNode nodeRight = lowestCommonAncestor(root.right, p, q);
		if(nodeLeft != null && nodeRight != null){
			return root;
		}else if(nodeLeft != null){
			return lowestCommonAncestor(root.left, p, q);
		}else{
			return lowestCommonAncestor(root.right, p, q);
		}*/
	}
	
	/**
	 * 二叉搜索树的最低公共祖先
	 * TODO
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 * TreeNode
	 */
	public static TreeNode lowestCommonAncestorOfaBinarySearchTree(TreeNode root, TreeNode p, TreeNode q){
		
		//循环方法，空间复杂度O(1)
		while((root.val - p.val) * (root.val - q.val) > 0){
			root = p.val < root.val ? root.left : root.right;
		}
		return root;
		
		//递归方法，具有栈深度
		/*if(root == null)
			return null;
		if(p.val < root.val && q.val < root.val){
			return lowestCommonAncestorOfaBinarySearchTree(root.left, p, q);
		}else if(p.val > root.val && q.val > root.val){
			return lowestCommonAncestorOfaBinarySearchTree(root.right, p, q);
		}else {
			return root;
		}*/
	}
	
	
	/**思路二：利用栈存储根节点到目标节点的路径，转换为求两个链表的最后公共结点*/
	public static TreeNode getLastCommonParent(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || p == null || q == null){
			return null;
		}
		List<TreeNode> pathP = new ArrayList<>();
		List<TreeNode> pathQ = new ArrayList<>();
		
		if(!getNodePath(root, p, pathP)){
			return null;
		}
		
		if(!getNodePath(root, q, pathQ)){
			return null;
		}
		
		return getLastCommonParent(pathP, pathQ);
	}

	
	private static TreeNode getLastCommonParent(List<TreeNode> pathP, List<TreeNode> pathQ) {
		TreeNode parent = null;
		int i = 0,j = 0;
		int lenP = pathP.size();
		int lenQ = pathQ.size();
		while(i < lenP && j < lenQ){
			if(pathP.get(i) == pathQ.get(j)){
				parent = pathP.get(i);
			}
			i++;
			j++;
		}
		return parent;
	}

	private static boolean getNodePath(TreeNode root, TreeNode p, List<TreeNode> pathP) {
		if(root == null){
			return false;
		}
		
		if(root == p){
			pathP.add(root);
			return true;
		}
		
		pathP.add(root);
		if(getNodePath(root.left, p, pathP)){
			return true;
		}
		
		if(getNodePath(root.right, p, pathP)){
			return true;
		}
		pathP.remove(pathP.size()-1);
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
