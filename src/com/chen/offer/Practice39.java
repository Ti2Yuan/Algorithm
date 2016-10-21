package com.chen.offer;

import com.chen.offer.BalancedBinaryTree.TreeNode;


/**
 * ��ָoffer��39��
 * ��Ŀһ����������������
 * ��Ŀ�����ж����Ƿ���ƽ�������
 * @author chenti
 *
 */
public class Practice39 {

	public static void main(String[] args) {
		Practice39 p = new Practice39();
		TreeNode root = p.constructTree();
		Depth depth = new Depth();
		//��Ŀһ
		System.out.println(p.treeDepth(root));
		//��Ŀ��
		System.out.println(p.isBalancedTree(root));
		System.out.println(p.isBalancedTree(root,depth));
	}

	/**
	 * ��������Ƿ���ƽ�������
	 * һ�α���
	 * �����ú�������ķ�ʽ������������ÿһ����㣬�ڱ�����һ�����֮ǰ�����Ѿ���������������������
	 * ֻҪ�ڱ���ÿ������ʱ���¼������ȣ�ĳһ������ȵ�������Ҷ�ڵ��·���ĳ��ȣ���
	 * ���ǾͿ���һ�߱���һ���ж�ÿ������ǲ���ƽ��� 
	 * @param root
	 * @param depth   //������һ�����ã��������Ͳ���
	 * @return
	 */
	private boolean isBalancedTree(TreeNode root, Depth depth) {
		if(root == null){
			depth.height = 0;
			return true;
		}
		Depth left = new Depth();
		Depth right = new Depth();
		if(isBalancedTree(root.left, left) && isBalancedTree(root.right, right)){
			int diff = Math.abs(left.height - right.height);
			if(diff <= 1){
				depth.height = left.height > right.height?left.height+1:right.height+1;
				System.out.println("�����"+root.value+" depth is "+depth.height);
				return true;
			}
		}
		return false;
	}
	
	private static class Depth{
		int height;
	}

	/**
	 * ��������Ƿ���ƽ�������
	 * ���ַ�ʽ��α�����������㣬Ч�ʲ���
	 * @param root
	 * @return
	 */
	private boolean isBalancedTree(TreeNode root) {
		if(root == null)
			return true;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int diff = Math.abs(left-right);
		if(diff > 1){
			return false;
		}
		return isBalancedTree(root.left) && isBalancedTree(root.right);
	}

	/**
	 * ������������
	 * @return
	 */
	private int treeDepth(TreeNode root) {
		if(root == null)
			return 0;
		int leftDepth = treeDepth(root.left);
		int rightDepth = treeDepth(root.right);
		
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}

	private TreeNode constructTree() {
		TreeNode A = new TreeNode('A');
		TreeNode B = new TreeNode('B');
		TreeNode C = new TreeNode('C');
		TreeNode D = new TreeNode('D');
		TreeNode E = new TreeNode('E');
		TreeNode F = new TreeNode('F');
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		D.left = F;		
		return A;
	}

	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		char value;

		public TreeNode(char value) {
			this.value = value;
		}
	}
}
