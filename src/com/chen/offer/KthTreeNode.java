/**
 * 
 */
package com.chen.offer;

/**
 * 给定一颗二叉搜索树，请找出其中的第K大的节点。例如，5/\37/\/\2468中，
 * 按节点数值大小顺序第三个节点的值为4.
 */
public class KthTreeNode {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(3);  
		TreeNode c = new TreeNode(10);  
		TreeNode d = new TreeNode(1);  
		TreeNode e = new TreeNode(6);  
		TreeNode f = new TreeNode(14);  
		TreeNode g = new TreeNode(4);  
		TreeNode h = new TreeNode(7);  
		TreeNode i = new TreeNode(13);  
          
        a.left = b;  
        a.right = c;  
        b.left = d;  
        b.right = e;  
        c.right = f;  
        e.left = g;  
        e.right = h;  
        f.left = i;  
        System.out.println(KthNode(a, 6));
	}

	public static TreeNode KthNode(TreeNode pRoot, int k){
		Integer count = new Integer(0);
		int[] count1 = new int[1];
		count1[0] = 0;
		TreeNode result = null;
		if(pRoot == null || k <= 0)
			return result;
		result = KthNode(pRoot, k, count1);
		return result;
	}
	
	/**
	 * TODO
	 * @param pRoot
	 * @param k
	 * @param count
	 * @return
	 * TreeNode
	 */
	private static TreeNode KthNode(TreeNode pRoot, int k, int[] count) {
		if(pRoot == null)
			return null;
		TreeNode res = KthNode(pRoot.right, k, count);
		if(res != null){
			return res;
		}
		count[0]++;
		if(k == count[0]){
			return pRoot;
		}
		res = KthNode(pRoot.left, k, count);
		return res == null ? null : res;
	}

	public static class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		
		public TreeNode(int val){
			this.val = val;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			//return super.toString();
			return ""+this.val;
		}
		
		
	}
}
