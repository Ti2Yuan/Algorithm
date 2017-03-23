/**
 * 
 */
package tree;

import java.util.Stack;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Binary Search Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * 解题思路：
 * 维护一个栈，从根节点开始，每次迭代地将根节点的左孩子压入栈，直到左孩子为空为止。

 * 调用next()方法时，弹出栈顶，如果被弹出的元素拥有右孩子，则以右孩子为根，将其左孩子迭代压栈。
 * 
 * O(h)意味着栈不能一次性全部存储树中节点
 */
public class BinarySearchTreeIterator {

	public static void main(String[] args) {
	}

	static Stack<TreeNode> stack;
	public BinarySearchTreeIterator(TreeNode root){
		stack = new Stack<>();
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}
	
	/**@return whether we have a next smallest number*/
	public static boolean hasNext(){
		return !stack.isEmpty(); 
	}
	
	/**@return the next smallest number*/
	public static int next(){
		TreeNode node = stack.pop();
		int result = node.val;
		if(node.right != null){
			node = node.right;
			while(node != null){
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
	
	/**
	 * Your BSTIterator will be call like this:
	 * BinarySearchTreeIterator i = new BinarySearchTreeIterator(root);
	 * while(i.hasNext()){
	 *    v[f()] = i.next();
	 * }
	 */
}
