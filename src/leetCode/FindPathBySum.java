package leetCode;

import java.sql.Struct;
import java.util.Iterator;
import java.util.Vector;

import com.chen.offer.BalancedBinaryTree.TreeNode;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
 * 从树的根结点开始往下一直到叶节点所经过的结点形成一条路径
 * 先序遍历，递归，栈存储
 * @author chenti
 *
 */
public class FindPathBySum {

	public static void main(String[] args) {
		BinaryTreeNode A = new BinaryTreeNode(10);
		BinaryTreeNode B = new BinaryTreeNode(5);
		BinaryTreeNode C = new BinaryTreeNode(12);
		BinaryTreeNode D = new BinaryTreeNode(4);
		BinaryTreeNode E = new BinaryTreeNode(7);
		A.m_pLeft = B;
		A.m_pRight = C;
		B.m_pLeft = D;
		B.m_pRight = E;
		int expectedSum = 22;
		FindPath(A,expectedSum);
		
	}
	
	private static void FindPath(BinaryTreeNode a, int expectedSum) {
		int currentSum = 0;
		Vector<BinaryTreeNode> binaryTreeNodesVector = new Vector<>();
		/**
		 * 递归遍历
		 */
		FindPathRecursively(a,expectedSum,binaryTreeNodesVector,currentSum);
	}

	//先序递归遍历树节点，利用栈存储路径，计算路径和
	private static void FindPathRecursively(BinaryTreeNode a, int expectedSum,
			Vector<BinaryTreeNode> binaryTreeNodesVector, int currentSum) {
		currentSum += a.m_nValue;
		binaryTreeNodesVector.add(a);
		
		//判断是否是叶子节点，并且路径上的结点的和是否等于输入的值
		boolean isLeaf = a.m_pLeft == null && a.m_pRight == null;
		if(currentSum == expectedSum && isLeaf){
			System.out.print("a path found is ");
			Iterator<BinaryTreeNode> bIterator = binaryTreeNodesVector.iterator();
			while (bIterator.hasNext()) {
				BinaryTreeNode temp = (BinaryTreeNode) bIterator.next();
				System.out.print(temp.m_nValue+"  ");
			}
			System.out.println();
		}
		
		if(a.m_pLeft != null){
			FindPathRecursively(a.m_pLeft, expectedSum, binaryTreeNodesVector, currentSum);
		}
		if(a.m_pRight != null){
			FindPathRecursively(a.m_pRight, expectedSum, binaryTreeNodesVector, currentSum);
		}
		
		binaryTreeNodesVector.remove(binaryTreeNodesVector.size()-1);
	}

	static class BinaryTreeNode{
		int m_nValue;
		BinaryTreeNode m_pLeft;
		BinaryTreeNode m_pRight;
		
		public BinaryTreeNode(int value) {
			this.m_nValue = value;
		}
	}

}
