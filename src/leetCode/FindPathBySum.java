package leetCode;

import java.sql.Struct;
import java.util.Iterator;
import java.util.Vector;

import com.chen.offer.BalancedBinaryTree.TreeNode;

/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·��
 * �����ĸ���㿪ʼ����һֱ��Ҷ�ڵ��������Ľ���γ�һ��·��
 * ����������ݹ飬ջ�洢
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
		 * �ݹ����
		 */
		FindPathRecursively(a,expectedSum,binaryTreeNodesVector,currentSum);
	}

	//����ݹ�������ڵ㣬����ջ�洢·��������·����
	private static void FindPathRecursively(BinaryTreeNode a, int expectedSum,
			Vector<BinaryTreeNode> binaryTreeNodesVector, int currentSum) {
		currentSum += a.m_nValue;
		binaryTreeNodesVector.add(a);
		
		//�ж��Ƿ���Ҷ�ӽڵ㣬����·���ϵĽ��ĺ��Ƿ���������ֵ
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
