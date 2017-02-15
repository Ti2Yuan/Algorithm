package leetcode;


/**
 * Given an array where elements are sorted in ascending order 
 * Convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
		TreeNode rootNode = sortedArrayToBST(nums);
		inOrder(rootNode);
	}

	public static TreeNode sortedArrayToBST(int[] nums){
//		ConvertSortedArrayToBinarySearchTree tree = new ConvertSortedArrayToBinarySearchTree();
//		TreeNode rootNode = tree.new TreeNode();
		return sortedArrayToBST(nums,0,nums.length-1);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums,int start,int end){
		while(start <= end){
			int mid = (start + end)/2;
			TreeNode leftNode = sortedArrayToBST(nums, start, mid-1);
			TreeNode rightNode = sortedArrayToBST(nums, mid+1, end);
			TreeNode treeNode = new TreeNode(nums[mid]);
			treeNode.leftNode = leftNode;
			treeNode.rightNode = rightNode;
			return treeNode;
		}
		return null;
	}
	
	public static void inOrder(TreeNode rootNode){
		if(rootNode == null)
			return;
		inOrder(rootNode.leftNode);
		System.out.println(rootNode.value);
		inOrder(rootNode.rightNode);
		return;
	}
	
	public static class TreeNode{
		int value;
		TreeNode leftNode;
		TreeNode rightNode;
		
		public TreeNode() {
		}
		
		public TreeNode(int value){
			this.value = value;
		}
		
		public TreeNode(int value, TreeNode leftNode,TreeNode rightNode){
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public TreeNode getRightNode() {
			return rightNode;
		}
		public void setRightNode(TreeNode rightNode) {
			this.rightNode = rightNode;
		}

		public TreeNode getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(TreeNode leftNode) {
			this.leftNode = leftNode;
		}
		
		
	}
}
