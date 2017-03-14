/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class BinaryTreeTraversal {

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
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {

	}
	
	/**
	 * 二叉树的前序遍历
	 * TODO
	 * @param root
	 * @return
	 * List<Integer>
	 */
	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> treeList = new ArrayList<>();
		if(root == null)
			return treeList;
		preorderTraversal(root,treeList);
		return treeList;
		
		/*下面是用栈的思想来实现前序遍历*/
//		Stack<TreeNode> stack = new Stack<>();
//		stack.push(root);
//		while(!stack.isEmpty()){
//			TreeNode node = stack.pop();
//			list.add(node);
//			
//			if(node.right != null){
//				stack.push(node.right);
//			}
//			
//			if(node.left != null){
//				stack.push(node.left);
//			}
//		}
	}
	
	/**
	 * TODO
	 * @param root
	 * @param treeList
	 * void
	 */
	private static void preorderTraversal(TreeNode root, List<Integer> treeList) {
		if(root == null)
			return;
		treeList.add(root.val);
		preorderTraversal(root.left, treeList);
		preorderTraversal(root.right, treeList);
	}

	/**
	 * 中序遍历
	 * TODO
	 * @param root
	 * @return
	 * List<Integer>
	 */
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> treeList = new ArrayList<>();
		if(root == null)
			return treeList;
		inorderTraversal(root,treeList);
		return treeList;
		
		/*下面是用栈的思想来做的*/
//		Stack<TreeNode> stack = new Stack<>();
//		TreeNode p = root;
//		while(!stack.isEmpty() || p != null){
//			if(p != null){
//				stack.push(p);
//				p = p.left;
//			}else {
//				TreeNode node = stack.pop();
//				list.add(node.val);
//				p = node.right;
//			}
//			
//		}
	}
	
	/**
	 * TODO
	 * @param root
	 * @param treeList
	 * void
	 */
	private static void inorderTraversal(TreeNode root, List<Integer> treeList) {
		if(root == null)
			return;
		inorderTraversal(root.left, treeList);
		treeList.add(root.val);
		inorderTraversal(root.right, treeList);
		
	}

	/**
	 * 后序遍历 递归方法不重要，使用迭代方法后序遍历
	 * TODO
	 * @param root
	 * @return
	 * List<Integer>
	 */
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> treeList = new ArrayList<>();
		if(root == null)
			return treeList;
		postorderTraversal(root,treeList);
		return treeList;
		
		/*下面是用迭代方法后序遍历的,也是基于栈的思想*/
//		Stack<TreeNode> stack = new Stack<>();
//		stack.push(root);
//		while(!stack.isEmpty()){
//			TreeNode node = stack.peek();
//			if(node.left == null && node.right == null) {
//				stack.pop();
//				list.add(node.val);
//			}else {
//				if(node.right != null){
//					stack.push(node.right);
//					node.right = null;
//				}
//				
//				if(node.left != null){
//					stack.push(node.left);
//					node.left = null;
//				}
//			}
//		}
		
	}
	
	/**
	 * TODO
	 * @param root
	 * @param treeList
	 * void
	 */
	private static void postorderTraversal(TreeNode root, List<Integer> treeList) {
		if(root == null)
			return;
		postorderTraversal(root.left, treeList);
		postorderTraversal(root.right, treeList);		
		treeList.add(root.val);
	}

	/**
	 * 层次遍历
	 * TODO
	 * @param root
	 * @return
	 * List<Integer>
	 */
	public static List<Integer> levelorderTraversal(TreeNode root){
		//队列的方法(BFS)
		ArrayList result = new ArrayList();
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<>();
			int size = queue.size();
			for(int i = 0;i<size;i++){
				TreeNode node = queue.poll();
				level.add(node.val);
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			result.add(level);
		}
		return result;
	}
	
	/**
	 * 递归方法层次遍历
	 * TODO
	 * @param root
	 * @return
	 * List<Integer>
	 */
	public static List<List<Integer>> levelorderTraversalByRecursively(TreeNode root){
		//队列的方法(BFS)
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		levelHelper(result,root,0);
		return result;
	}
	
	
	/**
	 * TODO
	 * @param result
	 * @param root
	 * @param i
	 * void
	 */
	private static void levelHelper(List<List<Integer>> result, TreeNode root, int height) {
		if(root == null)
			return;
		if(height >= result.size()){
			result.add(new LinkedList<Integer>());
		}
		result.get(height).add(root.val);
		levelHelper(result, root.left, height+1);
		levelHelper(result, root.right, height+1);
	}

	/**
	 * 层次遍历2
	 * 
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.

For example, given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as [[15,7], [9,20],[3]]

	 * TODO
	 * 解题思想：两个queue
	 * @param root
	 * @return
	 * List<Integer>
	 */
	public static List<ArrayList<Integer>> levelorderTraversal2(TreeNode root){
		List<ArrayList<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		current.offer(root);
		
		ArrayList<Integer> item = new ArrayList<>();
		
		while(!current.isEmpty()){
			TreeNode node = current.poll();
			item.add(node.val);
			
			if(node.left != null)
				next.offer(node.left);
			
			if(node.right != null)
				next.offer(node.right);
			
			if(current.isEmpty()){
				current = next;
				next = new LinkedList<>();
				result.add(item);
				item = new ArrayList<>();
			}
		}
		
		//return Collections.reverse(result);
		List<ArrayList<Integer>> reverseResult = new ArrayList<>();
		for(int i = result.size()-1;i >= 0;i--){
			reverseResult.add(result.get(i));
		}
		return reverseResult;
	}
	
	
	
	
	
	
	
	

}
