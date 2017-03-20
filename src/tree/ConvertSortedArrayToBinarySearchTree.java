/**
 * 
 */
package tree;

/**
 * Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
		TreeNode root = sortedArrayToBST(nums);
		inOrderTraversal(root);
	}
	
	/**
	 * 递归方法构造平衡的二叉搜索树,先找到数组中间位置，即根节点
	 * TODO
	 * @param nums
	 * @return
	 * TreeNode
	 */
	public static TreeNode sortedArrayToBST(int[] nums){
		TreeNode root = null;
		if(nums == null || nums.length <= 0)
			return root;
		root = helper(nums,0,nums.length-1);
		return root;
	}

	public static TreeNode helper(int[] nums, int start, int end){
		if(start == end){
			return new TreeNode(nums[start]);
		}
		int mid = start + (end - start)/2;
		TreeNode root = new TreeNode(nums[mid]);
		if(mid - start > 0){
			root.left = helper(nums, start, mid-1);
		}
		if(end - mid > 0){
			root.right = helper(nums, mid+1, end);
		}
		return root;
	}
	
	public static void inOrderTraversal(TreeNode root){
		if(root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
