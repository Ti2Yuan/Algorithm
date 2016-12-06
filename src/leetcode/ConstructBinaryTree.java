package leetcode;


/**
 * Given inorder and postorder traversal of a tree,construct the binary tree
 * @author chenti
 *
 */
public class ConstructBinaryTree {

	public static void main(String[] args) {
		int[] inOrder = new int[]{8,4,9,2,5,1,6,3,7};
		int[] postOrder = new int[]{8,9,4,5,2,6,7,3,1};
		TreeNode treeNode;
		treeNode = buildTree(inOrder,postOrder);
		PreTraversal(treeNode);  //pre traversal of tree
	}
	
	private static void PreTraversal(TreeNode treeNode) {
		if(treeNode == null){
			return;
		}
		System.out.println(treeNode.value);
		PreTraversal(treeNode.left);
		PreTraversal(treeNode.right);
	}

	private static TreeNode buildTree(int[] inOrder, int[] postOrder) {
		return buildTree(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1);
	}

	private static TreeNode buildTree(int[] inOrder, int is, int ie, int[] postOrder, int ps, int pe) {
		if(is>ie || ps>pe){
			return null;
		}
		int rootValue = postOrder[pe];
		TreeNode rootNode = new TreeNode(rootValue);
		for(int i = is;i<=ie;i++){
			if(inOrder[i] == rootValue){
				TreeNode left = buildTree(inOrder, is,i-1, postOrder, ps, ps+i-is-1);
				TreeNode right = buildTree(inOrder, i+1, ie, postOrder, pe-ie+i, pe-1);
				rootNode.left = left;
				rootNode.right = right;
			}
		}
		return rootNode;
	}

	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int value;

		public TreeNode(int value) {
			this.value = value;
		}
	}

}
