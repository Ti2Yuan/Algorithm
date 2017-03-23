/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.ConvertSortedArrayToBinarySearchTree.TreeNode;

/**
 * Binary Tree Right Side View
 * 
 *Given a binary tree, imagine yourself standing on the right side of it, 
 *return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * 
 * 思路：利用一个队列存储每一层的结点，每次只打印一层中最后一个节点
 */
public class BinaryTreeRightSideView {

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
		System.out.println(rightSideView(node1));
	}

	/**利用一个队列存储每一层的结点，每次只打印一层中最后一个节点*/
	
    public static List<Integer> rightSideView(TreeNode root){
    	List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int levelCount = 1;
		int currCount = 0;
		while(!queue.isEmpty()){
			for(int i = 0; i<levelCount;i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.offer(node.left);
					currCount++;
				}
				if(node.right != null){
					queue.offer(node.right);
					currCount++;
				}
				if(i == levelCount-1){
					list.add(node.val);
				}
			}
			levelCount = currCount;
			currCount = 0;
		}
		return list;
	}
    
    /**
     * The core idea of this algorithm:
     * 1.Each depth of the tree only select one node.
     * 2.View depth is current size of result list.
     * TODO
     * @param root
     * @return
     * List<Integer>
     */
    public static List<Integer> rightSideView2(TreeNode root){
    	List<Integer> result = new ArrayList<>();
    	helper(root,result,0);
    	return result;
    }
    
    public static void helper(TreeNode root, List<Integer> result, int currDepth){
    	if(root == null)
    		return;
    	if(currDepth == result.size()){
    		result.add(root.val);
    	}
    	
    	helper(root.right, result, currDepth+1);
    	helper(root.left, result, currDepth+1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
