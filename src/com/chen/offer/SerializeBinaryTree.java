/**
 * 
 */
package com.chen.offer;

import java.util.ArrayList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * 我们可以采用先序遍历的思想，只是在这里需要改动。为了能够在重构二叉树时结点能够插入到正确的位置，
 * 在使用先序遍历保存二叉树到文件中的时候需要把NULL结点也保存起来（可以使用特殊符号如“#”来标识NULL结点）。
 */
public class SerializeBinaryTree {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		String str = serialize(a);
		System.out.println(str);
		System.out.println(serialize(deserialize(str)));
	}

	/**
	 * 序列化二叉树 TODO
	 * 
	 * @param root
	 * @return String
	 */
	public static String serialize(TreeNode root) {
		if (root == null)
			return "{}";
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		// 将二叉树的节点按照从上到下，从左到右存储在list中
		for (int i = 0; i < list.size(); i++) {
			TreeNode q = list.get(i);
			if (q == null)
				continue;
			list.add(q.left);
			list.add(q.right);
		}
		// 去除叶子节点的左右孩子，这个孩子是空值
		while (list.get(list.size() - 1) == null) {
			list.remove(list.size() - 1);
		}
		// 遍历list，转换成字符串
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(list.get(0).val);
		for (int i = 1; i < list.size(); i++) {
			TreeNode q = list.get(i);
			if (q != null) {
				sb.append(",");
				sb.append(q.val);
			} else {
				sb.append(",#");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 反序列化二叉树 TODO
	 * 
	 * @param str
	 * @return TreeNode
	 */
	public static TreeNode deserialize(String str) {
		if (str == null || str.length() == 0)
			return null;
		if (str.equals("{}"))
			return null;
		// 以逗号分割
		String[] vals = str.substring(1, str.length() - 1).split(",");
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		// 根节点
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		list.add(root);
		int index = 0;
		boolean isLeftChild = true;
		for (int i = 1; i < vals.length; i++) {
			if (!vals[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				if (isLeftChild) {
					list.get(index).left = node;
				} else {
					list.get(index).right = node;
				}
				list.add(node);
			}
			if (!isLeftChild) {
				index++;
			}
			isLeftChild = !isLeftChild;
		}
		return root;
	}

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			// return super.toString();
			return "" + this.val;
		}

	}
}
