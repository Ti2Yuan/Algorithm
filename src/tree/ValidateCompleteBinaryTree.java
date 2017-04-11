/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树？
 * 
 * 首先要知道什仫是完全二叉树？
 * 
 * 完全二叉树就是除最后一层外，每一层上的结点数均达到最大值；在最后一层上只缺少右边的若干结点。
 * 
 * 思路：
 * 采用广度优先遍历，从根节点开始，入队列，如果队列不为空，循环。
 * 遇到第一个没有左儿子或者右儿子的节点，设置标志位，如果之后再遇到有左/右儿子的节点，那么这不是一颗完全二叉树。
 * 这个方法需要遍历整棵树，复杂度为O(N)，N为节点的总数。
 */
public class ValidateCompleteBinaryTree {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
	}

	/**
	 * 利用队列广度遍历
	 * */
	public static boolean isCompleteBianryTree(TreeNode root){
		if(root == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean flag = false;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			//如果flag==true说明之前的结点（ 只有左结点或者没有子节点）已存在，因此后面的结点应该都没有子节点的，否则返回false.
			if(flag && (node.left != null || node.right != null)){
				return false;
			}
			//左右子节点都存在
			if(node.left != null && node.right != null){
				queue.offer(node.left);
				queue.offer(node.right);
			}else if(node.left != null){  //只有左结点
				queue.offer(node.left);
				flag = true;
			}else if(node.right != null){  //只有右结点
				return false;
			}else {   //左右子节点都不存在
				flag = true;
			}
		}
		return true;
	}
	
	/***
	 * 剩余队列判空法:
	 *在完全二叉树中，如果按照层序遍历将所有节点包括他们叶子节点的空的左右孩子结点也入队列并弹出对应结点，则最后队列中一定全部剩余的是空结点
	 *
	 * 对于非完全二叉树来说，按照层序遍历，入队列遇到第一个空指针结束，此时队列中的元素不全为空，甚至该树尚未遍历完全，所以不是完全二叉树
	 *
	 * TODO
	 * @param root
	 * @return
	 * boolean
	 */
	public static boolean isCompleteBinaryTree(TreeNode root){
		if(root == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		//按照层序遍历的办法入队列，直到遇到第一个NULL停止
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == null){
				break;
			}
			queue.offer(node.left);
			queue.offer(node.right);
		}
		//如果队列中全为null则是完全二叉树，否则不是
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node != null){
				return false;
			}
		}
		return true;
	}
}























